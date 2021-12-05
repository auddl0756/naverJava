package api.hashmap;

import java.util.Hashtable;
import java.util.Map;

public class HashTableCounter extends Counter {
    @Override
    Map<String, Integer> getCounter() {
        return new Hashtable<>();
    }
}
