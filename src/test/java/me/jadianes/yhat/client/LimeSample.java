package me.jadianes.yhat.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.jadianes.yhat.model.Prediction;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
public class LimeSample extends Prediction {
    private String fromRow;
    private String toRow;

    @JsonProperty("from.row")
    public String getFromRow() {
        return fromRow;
    }

    @JsonProperty("to.row")
    public String getToRow() {
        return toRow;
    }
}
