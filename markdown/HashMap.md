# HashMap(해시맵)

## HashMap이란?
- Map 인터페이스를 구현한 대표적인 Map 컬렉션
- Map은 키(Key)와 값(Value)으로 구성된 Entry 객체를 저장하는 구조를 가지고 있는 자료구조
- 키(Key)와 값(Value)는 모두 객체
- 값(Value)은 중복 저장될 수 있지만 키(Key)는 중복 저장될 수 없다.

## 사용 방법
### 사용 전 import
`import java.util.HashMap;`

<br>

### 선언
`HashMap<TYPE, TYPE> HASHMAP_OBJECT_NAME = new HashMap<(TYPE, TYPE)>();`

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        // Type 설정
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        // Type 파라미터 생략
        HashMap<String, Integer> hm2 = new HashMap<>();
        // 초기 용량 설정
        HashMap<String, Integer> hm4 = new HashMap<>(10);
        // hm2 copy
        HashMap<String, Integer> hm5 = new HashMap<>(hm2);
        // type없음, Object 입력(타입을 입력하지 않으면 에러남)
        // HashMap<> hm3 = new HashMap<>();  // error: illegal start of type
    }
}
```

<br>

### 삽입
- **`.put()`** 메서드:   `HASHMAP_OBJECT.put(K key,V value);`
  > 중복 Key가 입력되었을 때 업데이트 함.



- **`.putIfAbsent()`** 메서드: `HASHMAP_OBJECT.putIfAbsent(K key,V value);`
  > 중복 Key가 입력되었을 때 업데이트 하지 않음.

<br>

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        
        // 데이터 접근 : .get()메서드
        System.out.println(hm1.get("Key1"));
        
        hm1.put("Key1", 1);
        System.out.println(hm1.get("Key1"));
        
        hm1.putIfAbsent("Key1", 2);
        System.out.println(hm1.get("Key1"));
    }
}
```

##### Output
```
0
1
1
```

-**`.putAll()`** 메서드 : `HASHMAP_OBJECT.putAll(MAP)`
  > 모든 MAP 값 추가

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 1);
        hm1.put("Key4", 10);
        System.out.println("hm1 : " + hm1);
        System.out.println("hm2 : " + hm2);

        hm2.putAll(hm1);
        System.out.println("hm2.putAll(hm1) 실행 >> ");
        System.out.println("hm1 : " + hm1);
        System.out.println("hm2 : " + hm2);

    }
}
```
#### Output
```
hm1 : {Key2=5, Key1=0, Key4=10, Key3=1}
hm2 : {}
hm2.putAll(hm1) 실행 >> 
hm1 : {Key2=5, Key1=0, Key4=10, Key3=1}
hm2 : {Key2=5, Key1=0, Key4=10, Key3=1}
```


### 삭제
- **`.remove()`** 메서드: `HASHMAP_OBJECT.remove(K Key);`
  > KEY 값에 해당하는 value 삭제

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);
        
        hm1.remove("Key1");
        System.out.println(hm1.get("Key1"));
        System.out.println(hm1.get("Key2"));
        System.out.println(hm1.get("Key3"));
    }
}
```

##### Output
```
null
5
10
```

- **`.clear()`** 메서드: `HASHMAP_OBJECT.clear();`
  > 모든 value 삭제

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);
        
        hm1.clear();
        System.out.println(hm1.get("Key1"));
        System.out.println(hm1.get("Key2"));
        System.out.println(hm1.get("Key3"));
    }
}
```
##### Output
```
null
null
null
```

### 접근
- **`.get()`** 메서드: `HASHMAP_OBJECT.get(K key);`
  > Value(값)을 반환

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 10);
        System.out.println(hm1.get("Key1"));
    }
}
```
##### Output
```
10
```

- **`.keySet()`** 메서드: `HASHMAP_OBJECT.keySet();`
  > Set<k>를 반환

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);
    
    System.out.println("hm1.keySet() = " + hm1.keySet());
    }
}
```
##### Output
```
hm1.keySet() = [Key2, Key1, Key3]
```

- **`.values()`** 메서드: `HASHMAP_OBJECT.values();`
  > Collection<v>를 반환

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);

        System.out.println("hm1.values() =" + hm1.values());
    }
}
```
##### Output
```
hm1.values() =[5, 0, 10]
```

- **`.entrySet()`** 메서드: `HASHMAP_OBJECT.entrySet();`
  > Set<Entry<k, v>>를 반환
  - HashMap에 저장된 모든 Entry 객체 반환
  - getKey()와 getValue()로 접근 가능

```java
import java.util.HashMap;
import java.util.Map.Entry;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);

        for (Entry<String, Integer> entry : hm1.entrySet()) {
        		System.out.print("key: " + entry.getKey());			
            System.out.println(", value: " + entry.getValue());
        }
    }
}
```
##### Output
```
key: Key2, value: 5
key: Key1, value: 0
key: Key3, value: 10
```

- **`.Iterator()`** 메서드: `ENTRYSET.Iterator();`

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);

        Iterator iter = hm1.entrySet().iterator();
      	while(iter.hasNext()) {
        		Map.Entry entry = (Map.Entry)iter.next();
        		System.out.println("key: " + entry.getKey() + ", value: "+entry.getValue());
      	}
    }
}
```
##### Output
```
key: Key2, value: 5
key: Key1, value: 0
key: Key3, value: 10
```

### 기타
- **`.replace()`** 메서드: `HASHMAP_OBJECT.replace(K key, V new_value);`
  > 새 value 값으로 업데이트한다.
  > HashMap에 Key 값이 없다면 null을 반환
  
```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        System.out.println("hm1.get(Key1) = " + hm1.get("Key1"));

        hm1.replace("Key1", 10);
        System.out.println("hm1.get(Key1) = " + hm1.get("Key1"));
    }
}
```
##### Output
```
hm1.get(Key1) = 0
hm1.get(Key1) = 10
```

- **`.size()`** 메서드: `HASHMAP_OBJECT.size();`
  > int형 반환
  
```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        hm1.put("Key2", 5);
        hm1.put("Key3", 10);
        System.out.println("hm1.size() = " + hm1.size());
    }
}
```
##### Output
```
hm1.size() = 3
```

- **`.containsKey()`** 메서드: `HASHMAP_OBJECT.containsKey(Object key);`
- **`.containsValue()`** 메서드: `HASHMAP_OBJECT.containsKey(Object Value);`
  > boolean형 반환
  > HashMap에 입력한 key나 value가 있으면 `true`, 없으면 `false`를 반환
  
```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        
        System.out.println("hm1.containsKey(Key1) = " + hm1.containsKey("Key1"));
        System.out.println("hm1.containsKey(Key2) = " + hm1.containsKey("Key2"));

        System.out.println("hm1.containsValue(0) = " + hm1.containsValue(0));
        System.out.println("hm1.containsValue(5) = " + hm1.containsValue(5));
    }
}
```
##### Output
```
hm1.containsKey(Key1) = true
hm1.containsKey(Key2) = false
hm1.containsValue(0) = true
hm1.containsValue(5) = false
```

- **`.getOrDefault()`** 메서드: `HASHMAP_OBJECT.getOrDefault(Object Key, V defaultValue);`
  > HashMap에 없는 KEY로 `HASHMAP.get(KEY)` 호출 시, null 반환
  > `.getOrDefault()`는 KEY에 해당하는 VALUE가 있으면 반환, 없으면 defaultValue 반환
  
```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        hm1.put("Key1", 0);
        
        System.out.println("hm1.get(Key1) = " + hm1.get("Key1"));
        System.out.println("hm1.get(Key2) = " + hm1.get("Key2"));

        System.out.println("hm1.getOrDefault(Key1, 10) = " + hm1.getOrDefault("Key1", 10));
        System.out.println("hm1.getOrDefault(Key2, 10) = " + hm1.getOrDefault("Key2", 10));
    }
}
```
##### Output
```
hm1.get(Key1) = 0
hm1.get(Key2) = null
hm1.getOrDefault(Key1, 10) = 0
hm1.getOrDefault(Key2, 10) = 10
```

- **`.isEmpty()`** 메서드 : `HASHMAP_OBJECT.isEmpty()`
  > HashMap이 비어있다면 `true` 반환

```java
import java.util.HashMap;

public class hashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();

        System.out.println("hm1.isEmpty() = " + hm1.isEmpty());
        hm1.put("Key1", 0);
        System.out.println("값 추가 후, hm1.isEmpty() = " + hm1.isEmpty());
    }
}
```
#### Output
```
hm1.isEmpty() = true
값 추가 후, hm1.isEmpty() = false
```

---

#### References(참고 자료)
[[Java] 자바 HashMap 사용법](https://yeoeun-ji.tistory.com/131)  
[[Java] Map을 Key, Value로 정렬하기](https://velog.io/@dev-easy/Java-Map%EC%9D%84-Key-Value%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0)  
[Hash, HashMap에 대하여](https://thkim-study.tistory.com/53)
