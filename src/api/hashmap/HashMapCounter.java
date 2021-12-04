package api.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapCounter extends Counter{
    @Override
    Map<String,Integer> getCounter() {
        return new HashMap<>();
    }
}
