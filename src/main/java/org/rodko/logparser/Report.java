package org.rodko.logparser;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Report {
    public ArrayList createReport(Map<String, Integer[]> report) {

        ArrayList result = new ArrayList();

        String heading = "             Latency Table\n " +
                "name | minLatency | maxLatency | avgLatency\n " +
                "-------------------------------------------\n";
        result.add(heading);


        for (String s : report.keySet()) {
            String intArrayString = Arrays.toString(report.get(s));
            StringTokenizer tokenizer = new StringTokenizer(intArrayString, " [,]");
            String token1 = tokenizer.nextToken(); //min
            String token2 = tokenizer.nextToken(); //max
            String token3 = tokenizer.nextToken(); //avg
            String resultTable = s + "\t  |     " + token1 + "\t   |     " + token2 + "\t|    " + token3 + "\n";
            result.add(resultTable);
        }

        return result;
    }
}
