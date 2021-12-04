package api.hashmap;

public class Main {
    public static void main(String[] args) {
        String[] languages = new String[]{"java","java","java","c++","c++","python"};

        Counter hashMapCounter = new HashMapCounter();
        hashMapCounter.count(languages);

        Counter hashTableCounter = new HashTableCounter();
        hashTableCounter.count(languages);

    }
}
