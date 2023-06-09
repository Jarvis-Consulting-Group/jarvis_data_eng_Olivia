package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"coordinates", "type"})

@SuppressWarnings("unused")
public class Coordinates {

    @JsonProperty("coordinates")
    private List<Double> coordinates = null;

    @JsonProperty("type")
    private String type;

    public Coordinates() {}

    @JsonProperty("coordinates")
    public List<Double> getCoordinates() {
        return this.coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
