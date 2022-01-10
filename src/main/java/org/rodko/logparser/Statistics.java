package org.rodko.logparser;


import java.util.*;

public class Statistics {
    public Map<String, Integer[]> collectStatistics(List<String> statistics) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> latency = new ArrayList<>();
        HashMap<String, Integer> nameAndLatency = new HashMap<>();

        for (int i = 0; i < statistics.size(); i++) {
            String string = statistics.get(i);
//            System.out.println(string);

            StringTokenizer tokenizer = new StringTokenizer(string, " ");
            String token1 = tokenizer.nextToken(); //время
            String token2 = tokenizer.nextToken(); //имя
            String token3 = tokenizer.nextToken(); //задержка
            name.add(token2);                      //добавляем в список имён
//            System.out.println("Name: " + token2);
            latency.add(Integer.valueOf(token3));  //добавляем в список задержек
//            System.out.println("Latensy: " + token3);
            nameAndLatency.put(token2, Integer.valueOf(token3));
        }
        Map<String, Integer[]> resultStatistics = searchesForOriginalNames(name, latency, nameAndLatency);
//        System.out.println(resultStatistics);
        return resultStatistics;
    }

    private Map<String, Integer[]> searchesForOriginalNames(ArrayList<String> name,
                                                            ArrayList<Integer> latency,
                                                            HashMap<String, Integer> nameAndLatency) {

        ArrayList<String> originalName = new ArrayList<>(nameAndLatency.keySet());
//        System.out.println(originalName);
        ArrayList<Integer> maxMinAvg = new ArrayList<>();
        Map<String, Integer[]> namesAndValuesLatency = new HashMap<>();


        for (int i = 0; i < originalName.size(); i++) {
            for (int j = 0; j < name.size(); j++) {
                int min = 0;
                int max = 0;
                int avg = 0;
                if (originalName.get(i).equals(name.get(j))) {
//                    System.out.println(i + " " + originalName.get(i) + " = " + j + name.get(j));
                    maxMinAvg.add(latency.get(j));
//                    System.out.println(maxMinAvg);
//                    System.out.println(maxMinAvg.size());
                    min = minValueSearch(maxMinAvg);
                    max = maxValueSearch(maxMinAvg);
                    avg = avgValueSearch(maxMinAvg);
//                    System.out.println("min " + min);
//                    System.out.println("max " + max);
//                    System.out.println("avg " + avg);
                    Integer[] arrayLatency = new Integer[3];
                    arrayLatency[0] = min;
                    arrayLatency[1] = max;
                    arrayLatency[2] = avg;
                    namesAndValuesLatency.put(originalName.get(i), arrayLatency);
                }
            }
//            System.out.println(namesAndValuesLatency);
            maxMinAvg.clear();
        }

        return namesAndValuesLatency;
    }

    private Integer minValueSearch(ArrayList<Integer> maxMinAvg) {
        Integer min = Integer.MAX_VALUE;
        if (maxMinAvg.size() > 1) {
            for (int i = 0; i < maxMinAvg.size(); i++) {
                if (min > maxMinAvg.get(i)){
                    min = maxMinAvg.get(i);
                }
            }
        } else {
            min = maxMinAvg.get(0);
        }
        return min;
    }

    private Integer maxValueSearch(ArrayList<Integer> maxMinAvg) {
        Integer max = Integer.MIN_VALUE;
        if (maxMinAvg.size() > 1) {
            for (int i = 0; i < maxMinAvg.size(); i++) {
                if (max < maxMinAvg.get(i)){
                    max = maxMinAvg.get(i);
                }
            }
        } else {
            max = maxMinAvg.get(0);
        }
        return max;
    }

    private Integer avgValueSearch(ArrayList<Integer> maxMinAvg) {
        Integer avg = 0;
        int count=0;
        if (maxMinAvg.size() > 1) {
            for (int i = 0; i < maxMinAvg.size(); i++) {
                avg += maxMinAvg.get(i);
                count++;
            }
            avg = avg / count;
        } else {
            avg = maxMinAvg.get(0);
        }
        return avg;
    }
}
