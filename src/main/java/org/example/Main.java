package org.example;

import org.example.domain.BalanceLine;
import org.example.domain.File;
import org.example.domain.Record;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePathA = args[0];
        int keyAStart = Integer.parseInt(args[1]);
        int keyAEnd = Integer.parseInt(args[2]);

        String filePathB = args[3];
        int keyBStart = Integer.parseInt(args[4]);
        int keyBEnd = Integer.parseInt(args[5]);

        File fileA = new File(filePathA, keyAStart, keyAEnd);
        fileA.readFile();
        fileA.sortFileByKey();

        File fileB = new File(filePathB, keyBStart, keyBEnd);
        fileB.readFile();
        fileB.sortFileByKey();

        BalanceLine balanceLine = new BalanceLine(fileA, fileB);
        List<Record> onlyMatchRecord = balanceLine.matchFiles();


        for (Record r: onlyMatchRecord) {
            System.out.println(r.recordLine());
        }
    }

}