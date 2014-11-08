package me.jadianes.yhat.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author jadianes ${EMAIL}
 */
public class LimeDataSetResult {

    @JsonProperty("X")
    public int[] x;

    @JsonProperty("Lime.Age")
    public int[] limeAge;

    @JsonProperty("Lime.Weight")
    public int[] limeWeight;

    @JsonProperty("Lime.Circumference")
    public int[] limeCircumference;

    @JsonProperty("Lime.Origin")
    public String[] limeOrigin;

    @JsonProperty("Cut.Type")
    public String[] cutType;

    @JsonProperty("Juice.Volume")
    public int[] juiceVolume;


}
