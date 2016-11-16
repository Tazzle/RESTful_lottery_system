package com.newsweaver.lotterysystem.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ticket {

    private final String id;
    private final List<Line> lines;

    public Ticket(String id, List<Line> lines) {
        this.id = id;
        this.lines = lines;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public List<Line> getLines() {
        return lines;
    }

    public void sortLines() {
        lines.sort((l1, l2) -> Integer.compare(l1.getOutcome(), l2.getOutcome()));
    }


}
