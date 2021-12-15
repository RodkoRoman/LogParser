package org.rodko.logparser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        TxtReader txtReader = new TxtReader();
        Statistics statistics = new Statistics();
        Report report = new Report();

        List<String> file = txtReader.readTxt(new File("C:\\Users\\Admin\\Desktop\\тест"));
        System.out.println(file);
        Map<String, Integer[]> map = statistics.collectStatistics(file);
        String report1 = report.createReport(map);

        System.out.println(report1);

    }
}
