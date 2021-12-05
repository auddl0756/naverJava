package api.hashmap;

import java.util.Map;

public abstract class Counter {
    abstract Map<String, Integer> getCounter();

    void count(String[] languages) {
        Map<String, Integer> count = getCounter();

        for (String language : languages) {
            count.put(language, count.getOrDefault(language, 0) + 1);
        }

        count.forEach((key, val) -> {
            System.out.println(key + " " + val);
        });
    }
}
