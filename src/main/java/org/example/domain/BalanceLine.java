package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class BalanceLine {
    private final File fileA;
    private final File fileB;

    private boolean endMatch = false;
    private int indA = 0, indB = 0;
    private int qntRegsA, qntRegsB;

    private String keyA = "", recordLineA = "";
    private String keyB = "";

    public BalanceLine(File fileA, File fileB) {
        this.fileA = fileA;
        this.fileB = fileB;
    }

    public List<Record> matchFiles(){

        qntRegsA = fileA.getSizeRecordList();
        qntRegsB = fileB.getSizeRecordList();

        List<Record> matchRecords = new ArrayList<>();

        keyA = fileA.getRecordList().get(indA).key();
        recordLineA = fileA.getRecordList().get(indA).recordLine();

        keyB = fileB.getRecordList().get(indB).key();

        while (!endMatch){

            int comparisonResult = keyA.compareTo(keyB);

            if(comparisonResult == 0){
                matchRecords.add(new Record(keyA,recordLineA));
                nextRecordA();
                nextRecordB();
            } else if (comparisonResult > 0) {
                nextRecordB();
            } else {
                nextRecordA();
            }

            if ((indA == qntRegsA - 1) && (indB == qntRegsB - 1)){
                endMatch = true;
            }
        }
        return matchRecords;
    }

    // When I get to the end of de list, move "\uD83F\UDFFF" (Unicode Code Point Maximum) to keyA
    private void nextRecordA(){
        if (indA < qntRegsA - 1){
            indA += 1;
            keyA = fileA.getRecordList().get(indA).key();
            recordLineA = fileA.getRecordList().get(indA).recordLine();
        }else keyA = "\uD83F\uDFFF";
    }

    // When I get to the end of de list, move "\uD83F\UDFFF" (Unicode Code Point Maximum) to keyB
    private void nextRecordB(){
        if (indB < qntRegsB - 1){
            indB += 1;
            keyB = fileB.getRecordList().get(indB).key();
        } else keyB = "\uD83F\uDFFF";
    }

}
