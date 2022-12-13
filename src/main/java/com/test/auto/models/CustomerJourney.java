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
public class CustomerJourney {
    @JsonProperty(value = "Status", required = false)
    public String status;
    @JsonProperty(value = "ContainerList", required = false)
    public List<ContainerList> containerList;

    @Override
    public String toString() {
        return "||CustomerJourney [status=" + status + ", containerList=" + containerList + "]";
    }

}
