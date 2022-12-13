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
public class ContainerList {
    @JsonProperty(value = "Status", required = true)
    public String status;
    @JsonProperty(value = "NextBestActions", required = true)
    public List<NextBestAction> nextBestActions;
    @JsonProperty(value = "ContainerName", required = true)
    public String containerName;

    @Override
    public String toString() {
        return "ContainerList [status=" + status + ", nextBestActions=" + nextBestActions + ", containerName="
                + containerName + "]";
    }

}
