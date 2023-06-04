package org.example.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class File{
    private final String path;
    private final int keyStart;
    private final int keyEnd;
    private final List<Record> recordList = new ArrayList<>();

    public File(String path, int keyStart, int keyEnd) {
        this.path = path;
        this.keyStart = keyStart;
        this.keyEnd = keyEnd;
    }

    public void readFile(){
        String tempKey;
        String tempLine;
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((tempLine = bufferedReader.readLine()) != null){
                tempKey = tempLine.substring(keyStart, keyEnd);
                recordList.add(new Record(tempKey, tempLine));
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSizeRecordList() {
        return recordList.size();
    }
    public List<Record> getRecordList() {
        return recordList;
    }

    public void sortFileByKey(){
        Collections.sort(recordList);
    }

}
