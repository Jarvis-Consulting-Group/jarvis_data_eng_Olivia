package ca.jrvs.apps.grep;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class JavaGrepTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testJavaGrepImp() {
        JavaGrep javaGrep = new JavaGrepImp();
        String inputFile = "src/test/resources/input.txt";
        String outputFile = "src/test/resources/output.txt";
        String regex = "\\btest\\b";
        javaGrep.process(inputFile, outputFile, regex);
        String expectedOutput = "This is a test file.\n" + "This is another test.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}