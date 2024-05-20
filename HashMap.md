# HashMap(해시맵)
- **Hash**(해시)
  - **입력된 데이터를 고정된 길이의 데이터로 변환한 값**
  - = `Hash value(해시 값)`, `해시 코드`, `체크섬`
  - **해시 함수**에 의해서 얻게 됨.
  - 데이터의 Key값이 해시 함수를 통해서 변환된 간단한 정수
  - 정수로 변환된 해시는 배열의 `인덱스`, `위치`, `데이터 값`을 저장하거나 검색할 때 활용

<img alt="데이터의 key값이 해시 함수를 통해 해시 값으로 변환된 과정 이미지" src="https://github.com/MinjuKang727/Java/assets/108849480/6306c5aa-a075-43f3-9f32-783dba33eab5" width="50%">

데이터의 key값이 해시 함수를 통해 해시 값으로 변환된 과정 이미지 | 출처 : [DEV_제임스](https://kang-james.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9CHASH-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)

<br>

## 자료 구조의 특징
- `키(KEY)`에 `데이터(Value)`를 **매핑**할 수 있는 데이터 구조
- 해시 함수를 통해 키의 데이터를 배열에 저장할 수 있는 주소(인덱스 번호)를 계산🤨
- 키를 통해서 저장된 데이터를 빠르게 **`검색`**, **`저장`** 및 **`탐색`** 속도가 획기적으로 빨라짐

## 알아둘 용어
### 1. Hash Function(해시 함수)
   > 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수
- 입력받은 데이터를 해시 값으로 출력시키는 알고리즘
- 해시값은 알고리즘에 따라 다양한 결과를 보임.
  > 함수는 목적에 맞게 다양하게 설계되어야 함.  
  > `자료구조`, `캐시`, `검색`, `에러 검출`, `암호` 등으로 유용하게 사용됨.
  
### 2. Hash Table(해시 테이블)
  > 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
- **키(Key)와 값(Value)을 함께 저장**해 둔 데이터 구조
*데이터가 행과 열로 구성된 표에 저장되는 것과 유사*
- 테이블의 데이터를 저장할 때 위치는 무작위로 지정
  > 중간에 여유 공간이 발생할 수 있음.
### 추가 용어
- **버킷**(Bucket) : 하나의 주소를 갖는 파일의 한 구역
  > 버킷의 크기는 같은 주소에 포함될 수 있는 레코드 수

- **슬롯**(Slot) : 한 개의 레코드를 저장할 수 있는 공간
  > 한 버킷 안에 여러 개의 슬롯이 있음.

### 3. Hashing(해싱)
> 해시 함수에서 해시를 출력하고, 테이블에 저장하는 과정까지의 행위

<img alt="Hashing(해싱)" src="https://github.com/MinjuKang727/Java/assets/108849480/2470824b-6af5-44ce-9061-9fd58ce90355" width="50%">

해싱(Hashing) | [DEV_제임스](https://kang-james.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9CHASH-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)

## 해시 자료구조의 장·단점, 용도
### 장점
- 데이터 `저장`, `읽기` 속도가 빠름 (`검색` 속도가 빠름)
- 해시는 키에 대한 데이터가 있는지 확인이 쉬움

### 단점
- 일반적으로 저장공간이 많이 필요
- 여러 키에 해당하는 주소(인덱스)가 동일한 경우, 충돌을 해결하기 위한 별도 자료구조 필요

### 주요 용도
- **검색**이 많이 필요한 경우
- **저장**, **삭제**, **읽기**가 빈번한 경우
- 캐쉬 구현

## 해시 구현하기
```java
 // 기본적인 해시 테이블 구현
public class Hash {
  
    // Hash table
    public Slot[] hashTable; // 배열 형태로 선언
    
    // Hash 객체를 생성할 때 table 사이즈 지정
    public Hash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    // Slot에는 value를 가짐
    public class Slot {
      
        String value;
        
        Slot(String value) {
            this.value = value;
        }
    }
    
    // Hash function
    public int hashFunction(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length; // 나머지
    }
    
    // 입력 받은 key를 해시 함수로 인덱스화 하고, 해당 인덱스에 value를 저장
    public boolean saveData(String key, String value) {
      
      // Key는 해시 함수를 거쳐서 해시 값(해시, 해시 주소)을 반환 -> 여기선 배열의 인덱스와 동일
        Integer address = this.hashFunction(key);
        
        if (this.hashTable[address] != null) {
          // 해당 주소에 이미 데이터가 있을 경우
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        
        return true;
      
    }
    
    // Key에 해당하는 값을 반환
    public String getData(String key) {
        // Key는 해시 함수를 거쳐서 해시 값(해시, 해시 주소를 반환)
        Integer address = this.hashFunction(key);
        
        if(this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        Hash myHash = new Hash(20);
        
        myHash.saveData("Lee", "30000");
        myHash.saveData("James", "15000");
        myHash.saveData("Denny", "5000");
        
        System.out.println("Lee 키의 값 : " + myHash.getData("Lee"));
        System.out.println("James 키의 값 : " + myHash.getData("James"));
        System.out.println("Denny 키의 값 : " + myHash.getData("Denny"));
        System.out.println("Kang 키의 값 : " + myHash.getData("Kang"));

        // Collision 유도
        System.out.println("Lion 키의 값 : " + myHash.getData("Lion"));
        myHash.saveData("Lily", "36000");
        System.out.println("Lily 키의 값 : " + myHash.getData("Lily"));
        System.out.println("Lee 키의 값 : " + myHash.getData("Lee"));    
    }
}
```
##### Output
```java
Lee 키의 값 : 30000
James 키의 값 : 15000
Denny 키의 값 : 5000
Kang 키의 값 : null
Lion 키의 값 : 30000
Lily 키의 값 : 36000
Lee 키의 값 : 36000
```
*저장하지 않은 Lion의 값이 30000으로 출력됨.  
Lily의 값을 36000으로 저장하고 Lee의 값을 가져오자 36000을 반환*

## Collision(충돌)
*위에서 작성한 코드는 해시의 기본 원리를 이해하기 위해 작성된 방법입니다.*

> 위의 코드에서 Hash클래스의 hashfunction()메서드 부분을 보면,  
매개변수 key의 첫번째 문자를 배열의 크기로 나눈 나머지를 인덱스로 사용합니다.  
하지만, 이는 **첫번째 문자가 동일한 서로 다른 key에 대해 동일한 인덱스를 반환**하므로  
배열에서 같은 장소에 저장되고 이전에 저장된 데이터가 사라지게 됩니다.  
이를 **Collision**(충돌)이 발생했다고 합니다.

### 충돌이 발생되는 이유
- 함수 알고리즘의 성능이 좋지 못함.
- 저장되는 데이터 양이 해시 테이블의 크기(Size)보다 큼.

### 충돌 해결하기
#### 1. Chaining 기법 ([구현하기✅](https://github.com/MinjuKang727/Java/blob/ea88115c20c5e8e00851d4bb403623863de41df9/Hash_Chaining.java))
- 개방 해싱 또는 Open Hashing 기법 중 하나
  - 해시 테이블 저장 공간 외에 공간을 활용하는 기법
- 충돌이 발생했을 때, 연결 리스트(Linked List) 자료구조를 사용해서 해결하는 방법

<img alt="Chaining 기법으로 충돌 해결하기" src="https://github.com/MinjuKang727/Java/assets/108849480/3bfb4032-de9b-4ddd-b2f4-5213ec7d57fc" width="30%">

Chaining 기법으로 충돌 해결하기 | [DEV_제임스
](https://kang-james.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9CHASH-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)

#### 2. Linear Probing 기법([구현하기✅](https://github.com/MinjuKang727/Java/blob/bce24a854dd79d3b2a45d63ef14402774668bd14/Hash_LinearProbing.java))
- 폐쇄 해싱 또는 Closing Hashing 기법 중 하나
  - 해시 테이블 저장 공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 발생했을 때, 해당 해시 주소(index)의 다음 주소(index)부터 맨 처음까지 순회하며 빈 공간을 찾는 방식
- 저장 공간 활용도를 높이기 위한 기법
  
## 시간 복잡도
- 충돌이 없는 일반적인 경우 : **O(1)**
  > 키를 통해 바로 저장과 검색을 하여 값을 구하기 때문입니다.
- 만약 최악의 경우, 모든 index에서 충돌이 발생하는 경우 : **O(n)**

---

#### References(참고 자료)
[[COLLECTION] 이것만 알면 해시맵(HASHMAP) 정복 가능 - HASHMAP의 특징, 사용법 예제](https://reakwon.tistory.com/151)  
[[Java] 자바 - HashMap 사용방법 (개념, 특징, 메소드 및 예제)](https://kadosholy.tistory.com/120)  
[[자료구조] 해시(HASH) 알아보기](https://kang-james.tistory.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9CHASH-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)  
[[Java] 해시맵(HashMap) 자료구조 정리](https://velog.io/@db_jam/Java-%ED%95%B4%EC%8B%9C%EB%A7%B5HashMap-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%A0%95%EB%A6%AC)
