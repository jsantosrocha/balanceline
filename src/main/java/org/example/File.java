package org.example;

public class File implements Comparable<File>{
    String key;
    String line;

    public File(String key, String line) {
        this.key = key;
        this.line = line;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public int compareTo(File o) {
        return this.key.compareTo(o.getKey());
    }
}
