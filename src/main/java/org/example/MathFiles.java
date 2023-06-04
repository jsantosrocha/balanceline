package org.example;

import org.example.domain.BalanceLine;
import org.example.domain.File;
import org.example.domain.Record;

import java.util.List;

public class MathFiles {
    public static void main(String[] args) {

        if (args.length < 5){
            System.out.println("Number of params invalid, try:");
            System.out.println("\"java MathFiles <fileIn1> <fileIn2> <fileOut> <posKey> <lengthKey>\"");
            System.exit(1);
        }

        String pathFile1 = args[0];
        String pathFile2 = args[1];
        String pathFile3 = args[2];

        int keyStart = Integer.parseInt(args[3]);
        int keyLength = Integer.parseInt(args[4]);
        int keyEnd = keyStart + keyLength;

        File fileIn1 = new File(pathFile1, keyStart, keyEnd);
        fileIn1.readFile();
        fileIn1.sortFileByKey();

        File fileIn2 = new File(pathFile2, keyStart, keyEnd);
        fileIn2.readFile();
        fileIn2.sortFileByKey();

        BalanceLine balanceLine = new BalanceLine(fileIn1, fileIn2);
        List<Record> onlyMatchRecord = balanceLine.matchFiles();

        File fileOut = new File(pathFile3);
        fileOut.writeFile(onlyMatchRecord);

        System.out.println("Files successfully processed");
        System.out.println("Number of records fileIn1: " + fileIn1.getSizeRecordList());
        System.out.println("Number of records fileIn2: " + fileIn2.getSizeRecordList());
        System.out.println("Number of records fileOut: " + onlyMatchRecord.size());
        System.exit(0);
    }

}