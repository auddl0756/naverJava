package api.hashmap;

public class Main {
    public static void main(String[] args) {
        String[] languages = new String[]{"java", "java", "java", "c++", "c++", "python"};

        Counter hashMapCounter = new HashMapCounter();
        hashMapCounter.count(languages);

        Counter hashTableCounter = new HashTableCounter();
        hashTableCounter.count(languages);


    }
}

//<HashMap이 어떻게 구현되어 있는지>

/* HashMap , HashTable => intellij에서 직접 클래스에 타고 들어가봐도 설명 많음.
    key에 대한 해시 값을 이용하여 value를 저장,조회함.
    key-value 쌍의 개수에 따라 크기가 증가하는 연관 배열(Map,Dictionary)

    둘 다 Map 인터페이스를 구현.
    HashMap은 보조 해시 함수를 사용한다? 그래서 성능상 이점이 있다?
    HashTable은 옛날 것이고, 현재는 하위 호환성을 제공하는 의미밖에 없다.

    HashMap의 말 뜻은
    Key 집합인 정의역과 value 집합인 공역의 대응(mapping)에 해시 함수를 사용한다는 것이다.
 */

/* Hash 분포와 충돌
    모든 객체를 다른 bucket에 할당하는 해시함수는 완전한 해시 함수(perfect hash function)이라 불린다.
    bucket의 개수는 제한적이므로 충돌이 발생할 수 있다.
    충돌은 open addressing 또는 chaining 방식으로 해결하는 것이 대표적.

    open addressing은 해시된 key값에 해당하는 bucket이 이미 할당되어 있으면
    다른 대체 bucket을 찾아서 거기에 할당하는 것을 의미한다.
    대체 bucket을 linear search로 찾을 수도 있고, quadratic search,
    hashing을 한번 더 하는 double hashing을 사용할 수도 있다.
    open addressing은 연속된 공간에 데이터를 저장한다.
    메모리에서 데이터는 byte보다 큰 단위로 가져오므로 여러 연속된 데이터를 cache에 가져오게 된다.
    따라서 open addressing은 cache 효율이 높다. 하지만 배열 크기가 커지면
 */

/* java8에서 hashmap의 충돌 해결 방법
    java hashmap은 chaining을 사용한다.
    java 7까지는 동일한 버켓에 여러 데이터가 매핑되면 연결 리스트 방식으로 저장.
    java 8부터는 버켓의 데이터 개수에 따라 연결 리스트(6개 이하) 또는 트리 구조(8개 이상)를 사용.
    이는 데이터가 균등 분포하더라도 비둘기집의 원리처럼 한 버켓에 데이터가 몰릴 수 있기 때문이다.
 */

/*  bucket의 개수에 따른 성능 */

/* 보조 해시 함수
*   key 해시 값을 변형해 해시 충돌 가능성을 줄이는 것이 목적.
* */

/* String 객체에 대한 해시 함수 */

