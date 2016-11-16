package com.newsweaver.lotterysystem.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Line {

    private final List<Integer> values;
    private int outcome;

    private final Random random = new Random();
    private final int numberOfValues = 3;
    private final int valueRange = 3;


    public Line() {

        values = new ArrayList<>();

        for (int i = 0; i < numberOfValues; i++) {
            values.add(random.nextInt(valueRange));
        }

        calculateOutcome();

    }

    private void calculateOutcome() {

        Set<Integer> valueSet = new HashSet<>(values);

        //if sum of values is 2 outcome is 10
        if (values.stream().mapToInt(Integer::intValue).sum() == 2) {outcome = 10;}

            //if all values the same outcome is 5
        else if (valueSet.size() == 1) {outcome = 5;}

            // if 2nd and 3rd numbers are different from the 1st outcome is 1
        else if (!values.get(0).equals(values.get(1)) && !values.get(0).equals(values.get(2))) {outcome = 1;}

            //otherwise outcome is 0
        else {
            outcome = 0;
        }

    }

    @JsonProperty
    public int getOutcome() {
        return outcome;
    }

    @JsonProperty
    public List<Integer> getValues() {
        return values;
    }


}
