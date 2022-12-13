package com.test.auto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Data
public class NextBestAction {
    @JsonProperty(value = "ActionID", required = true)
    public String actionID;
    @JsonProperty(value = "Action", required = true)
    public String action;
    @JsonProperty(value = "RankedResults", required = true)
    public List<RankedResult> rankedResults;

    @Override
    public String toString() {
        return "NextBestAction [actionID=" + actionID + ", action=" + action + ", rankedResults=" + rankedResults + "]";
    }

}
