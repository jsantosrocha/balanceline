package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePathA = args[0];
        int keyPositionStart = Integer.parseInt(args[1]);
        int keyPositionEnd = Integer.parseInt(args[2]);
        String key;


        List<File> fileA = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(filePathA);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                key = line.substring(keyPositionStart, keyPositionEnd);
                fileA.add(new File(key, line));
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(fileA);

        for (File a: fileA) {
            System.out.println(a.line);
        }
    }
}