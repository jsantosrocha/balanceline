package org.example;

import org.example.domain.BalanceLine;
import org.example.domain.File;
import org.example.domain.Record;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        if ((args.length < 5) || (Integer.parseInt(args[3]) <= 0) || (Integer.parseInt(args[4]) <= 0)){
            System.out.println();
            System.out.println("Number of params invalid, try:");
            System.out.println("java -jar balanceline.jar <fileIn1> <fileIn2> <fileOut> <posKey> <lengthKey>");
            System.out.println("fileIn1....= File in 1");
            System.out.println("fileIn2....= File in 2");
            System.out.println("fileOut....= File out");
            System.out.println("posKey.....= Initial position of key, value must be greater than zero");
            System.out.println("lengthKey..= Length key, value must be greater than zero");
            System.out.println();
            System.exit(1);
        }

        String pathFile1 = args[0];
        String pathFile2 = args[1];
        String pathFile3 = args[2];

        int keyStart = (Integer.parseInt(args[3]) - 1);
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