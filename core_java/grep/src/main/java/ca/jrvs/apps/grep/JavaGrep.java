package ca.jrvs.apps.grep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public interface JavaGrep {

    String getRootPath();
    void setRootPath(String rootPath);
    String getRegex();
    void setRegex(String regex);
    String getOutFile();
    void setOutFile(String outFile);

    default void process(String inputFile, String outputFile, String regex) {
        List<String> matchedLines = new ArrayList<>();
        try {
            List<File> files = listFiles(getRootPath());
            for (File file : files) {
                List<String> lines = readLines(file);
                for (String line : lines) {
                    if (containsPattern(line)) {
                        matchedLines.add(line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading files: " + e.getMessage());
        }
        writeToFile(matchedLines);
    }

    default List<File> listFiles(String rootDir) throws IOException {
        List<File> files = new ArrayList<>();
        Files.walk(Paths.get(rootDir)).filter(Files::isRegularFile).forEach(file -> files.add(file.toFile()));
        return files;
    }

    default List<String> readLines(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    default boolean containsPattern(String line) {
        return line.matches(getRegex());
    }

    default void writeToFile(List<String> lines) {
        try (FileWriter writer = new FileWriter(getOutFile())) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }

}