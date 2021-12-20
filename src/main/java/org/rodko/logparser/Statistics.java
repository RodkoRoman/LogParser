package org.rodko.logparser;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Statistics {
    public Map<String, Integer[]> collectStatistics(List<String> statistics) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> latensy = new ArrayList<>();
        for (int i = 0; i < statistics.size(); i++) {
            String string = statistics.get(i);
            System.out.println(string);

            StringTokenizer tokenizer = new StringTokenizer(string, " ");
            String token1 = tokenizer.nextToken();
            String token2 = tokenizer.nextToken();
            String token3 = tokenizer.nextToken();
            name.add(token2);
            System.out.println("Name: " + token2);
            latensy.add(Integer.valueOf(token3));
            System.out.println("Latensy: " + token3);
            searchesForOriginalNames(name);
        }
        searchesForOriginalNames(name);
        return null;
    }

    private ArrayList<String> searchesForOriginalNames(ArrayList<String> name) {
        for (int i = 0; i < name.size(); i++) {                   //сравнимаем все элементы списка
            for (int j = 0; j < name.size(); j++) {                
                if (name.get(i).equals(name.get(j))) {

                }
            }
        }
        return null;
    }
}
