package org.example.domain;

public record Record(String key, String recordLine) implements Comparable<Record> {

    @Override
    public int compareTo(Record o) {
        return this.key.compareTo(o.key());
    }

}
