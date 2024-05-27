# 리스트

#### 리스트(List) vs 배열
- 배열은 크기가 정해져 있지만 리스트는 크기가 변한다.

**자료형의 개수가 계속 변하는 경우, 리스트를 사용한다.**

#### 리스트 자료형
- ArrayList
- Vector
- LinkedList  
  등...

## ArrayList
> 리스트 자료형에서 가장 일반적으로 사용하는 자료형

### import 
```java
import java.util.ArrayList;
```

### 생성

```java
ArrayList 객체명 = new ArrayList();
```
> 기본 크기가 10인 배열 생성
> 자료형을 선언해 주지 않으면, 자료형에 관계 없이 값 삽입 가능  

```java
import java.util.ArrayList;

public class arraylist {
    public static void main(String args[]) {

        ArrayList arraylist = new ArrayList();
        arraylist.add(1);
        arraylist.add("1");
        arraylist.add('a');
        arraylist.add(1.1);
        arraylist.add(null);
        
        System.out.println(arraylist);

    }
}
```
<details>
  <summary>Output</summary>

  ```
  [1, 1, a, 1.1, null]
  ```
  ***ArrayList의 원소로 자료형에 관계없이 삽입 가능한 것을 확인
  `null`도 삽입 가능***
</details>

<br>

```java
ArrayList 객체명 = new ArrayList(기본크기);
```
> 기본 크기를 지정  
*(배열이 다 차면 기본크기만큼 사이즈가 증가함)*

<br>

```java
ArrayList<제네릭> 객체명 = new ArrayList<>();
```
> 배열 값의 자료형을 지정  
> *(자바 J2SE 5.0 버전부터 객체를 포함하는 자료형을 명확하게 표현할 것을 권고하고 있다.👍)*  

  - 제네릭(Generic)
    - 컬렉션 객체를 생성할 때 저장되는 데이터의 타입을 미리 지정하는 기능
    - 제네릭으로 지정한 타입 외에는 담길 수 없도록 함

```java
import java.util.ArrayList;

public class arraylist {
    public static void main(String args[]) {
        ArrayList<String> arraylist = new ArrayList<>();
        
        arraylist.add("1");
        arraylist.add(null);
        
        System.out.println(arraylist);
    }
}
```
<details>
  <summary>Output</summary>

  ```
  [1, null]
  ```
  ***지정한 자료형 혹은 `null`만 삽입 가능***
</details>


### 추가
- **`add(int index, Ojbect o)**
  > `index`매개변수는 생략가능
  > `index` 매개변수를 주면 해당 인덱스로 값 삽입

  ```java
  import java.util.ArrayList;

  public class arraylist {
      public static void main(String args[]) {
  
  ArrayList<String> arraylist = new ArrayList<>();
  
  arraylist.add("1");
  arraylist.add("4");
  arraylist.add("0");
  
  System.out.println(arraylist);
  
  arraylist.add(1, "idx1");
  System.out.println("1번 인덱스에 idx1가 들어왔을까? " + arraylist);
  
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    [1, 4, 0]
    1번 인덱스에 idx1가 들어왔을까? [1, idx1, 4, 0]
    ```
  </details>

  <br>

- boolean **`addAll(배열)`**  
  > 두 컬렉션을 합침

  ```java
  import java.util.ArrayList;

  public class arrayList {
      public static void main(String args[]) {
          ArrayList<String> arrList1 = new ArrayList<>();
        
          arrList1.add("a");
          arrList1.add("4");
          arrList1.add("0");
        
          ArrayList<String> arrList2 = new ArrayList<>();
      
          arrList2.add("1");
          arrList2.add("apple");
          arrList2.add("banana");
        
          System.out.println("arrList1 = " + arrList1);
          System.out.println("arrList2 = " + arrList2);
        
          System.out.println("arrList1.addAll(arrList2) = " + arrList1.addAll(arrList2));
          System.out.println("arrList1 = " + arrList1);
      }
  }
  ```
  <details>
    <summary>Output</summary>

     ```
     arrList1 = [a, 4, 0]
     arrList2 = [1, apple, banana]
     arrList1.addAll(arrList2) = true
     arrList1 = [a, 4, 0, 1, apple, banana]
     ```
  </details>

<br>

  
### 추출
- **`get(int index)`**  
  > ArrayList에서 `index`의 값을 반환  

  ```java
  import java.util.ArrayList;

  public class arraylist {
      public static void main(String args[]) {
  
        ArrayList<String> arraylist = new ArrayList<>();
        
        arraylist.add("1");
        arraylist.add("a");
        arraylist.add("앙");
        arraylist.add("!");
        arraylist.add("-1");
        
        System.out.println("arraylist = " + arraylist);
        System.out.println("arraylist.get(2) = " + arraylist.get(2));
        
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [1, a, 앙, !, -1]
    arraylist.get(2) = 앙
    ```
	</details>

<br>

- int **`indexOf(VALUE)`**
  > 배열에 `VALUE`가 존재하면 해당 값의 첫번째 `index`를 반환  
  > 배열에 `VALUE`가 존재하지 않으면 `-1`을 반환  

  ```java
  import java.util.ArrayList;

  public class arrayList {
      public static void main(String args[]) {
    
        ArrayList<Integer> arrList = new ArrayList<>();
      
        arrList.add(1);
        arrList.add(0);
        arrList.add(2);
        arrList.add(10);
        arrList.add(-5);
        arrList.add(123);
    
        System.out.println("arrList = " + arrList);
    
        System.out.println("arrList.indexOf(1) = " + arrList.indexOf(1));
        System.out.println("arrList.indexOf(10) = " + arrList.indexOf(10));
        System.out.println("arrList.indexOf(-1) = " + arrList.indexOf(-1));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList = [1, 0, 2, 10, -5, 123]
    arrList.indexOf(1) = 0
    arrList.indexOf(10) = 3
    arrList.indexOf(-1) = -1
    ```
  </details>

<br>

- **`lastIndexOf(VALUE)`**
  > 배열에 `VALUE`가 존재하면 해당 값의 마지막 `index`를 반환  
  > 배열에 `VALUE`가 존재하지 않으면 `-1`을 반환

  ```java
  import java.util.ArrayList;

  public class arrayList {
      public static void main(String args[]) {
    
        ArrayList<Integer> arrList = new ArrayList<>();
    
        arrList.add(1);
        arrList.add(0);
        arrList.add(2);
        arrList.add(10);
        arrList.add(-5);
        arrList.add(0);
        arrList.add(123);
    
        System.out.println("arrList = " + arrList);
    
        System.out.println("arrList.lastIndexOf(0) = " + arrList.lastIndexOf(0));
        System.out.println("arrList.lastIndexOf(10) = " + arrList.lastIndexOf(10));
        System.out.println("arrList.lastIndexOf(-1) = " + arrList.lastIndexOf(-1));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList = [1, 0, 2, 10, -5, 0, 123]
    arrList.lastIndexOf(0) = 5
    arrList.lastIndexOf(10) = 3
    arrList.lastIndexOf(-1) = -1
    ```
  </details>

  
### 크기
- int **`size()`**
  > ArrayList의 요소의 개수를 반환  

  ```java
  import java.util.ArrayList;
  
  public class arraylist {
      public static void main(String args[]) {
          
          ArrayList<String> arraylist = new ArrayList<>();
          
          arraylist.add("1");
          arraylist.add("a");
          arraylist.add("앙");
          arraylist.add("!");
          arraylist.add("-1");
          
          System.out.println("arraylist = " + arraylist);
          System.out.println("arraylist.size() = " + arraylist.size());
  
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [1, a, 앙, !, -1]
    arraylist.size() = 5
    ```
	</details>

 <br>
 
### 요소 포함 여부
- boolean **`contains()`**
  > 리스트 안에 해당 항목이 있는지 판별해 그 결과를 `boolean`으로 반환  

  - **자료형이 다른(`String`, `char`, `int`) 1의 포함 여부를 `contains()`메서드를 통해 알아보자.**
  ```java
  import java.util.ArrayList;
  
  public class arraylist {
      public static void main(String args[]) {
  
          ArrayList<String> arraylist = new ArrayList<>();
          
          arraylist.add("1");
          arraylist.add("a");
          arraylist.add("앙");
          arraylist.add("!");
          arraylist.add("-1");
          
          System.out.println("arraylist = " + arraylist);
          System.out.println("arraylist.contains(\"1\") = " + arraylist.contains("1"));
          System.out.println("arraylist.contains('1') = " + arraylist.contains('1'));
          System.out.println("arraylist.contains(1) = " + arraylist.contains(1));
  
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [1, a, 앙, !, -1]
    arraylist.contains("1") = true
    arraylist.contains('1') = false
    arraylist.contains(1) = false
    ```
    ***`contains()`메서드는 자료형과 값까지 일치하는 요소를 포함하는지 체크 함.***
	</details>

<br>

- boolean **`containsAll(v1, v2, ...)`**
  > 배열에 매개변수의 모든 값이 포함되어 있으면 `true` 반환  
  > 배열에 매개변수의 모든 값이 포함되어 있지 않으면 `false` 반환

  ```java
  import java.util.ArrayList;

  public class arrayList {
      public static void main(String args[]) {
    
        ArrayList<Integer> arrList1 = new ArrayList<>();
    
        arrList1.add(1);
        arrList1.add(0);
        arrList1.add(2);
        arrList1.add(10);
        arrList1.add(-5);
        arrList1.add(123);
    
        ArrayList<Integer> arrList2 = new ArrayList<>();
    
        arrList2.add(10);
        arrList2.add(0);
    
        System.out.println("arrList1 = " + arrList1);
        System.out.println("arrList2 = " + arrList2);
    
        System.out.println("arrList1.containsAll(arrList2) = " + arrList1.containsAll(arrList2));
      
        arrList2.add(369);
        arrList2.add(-55);
        System.out.println("arrList2 = " + arrList2);
        System.out.println("arrList1.containsAll(arrList2) = " + arrList1.containsAll(arrList2));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList1 = [1, 0, 2, 10, -5, 123]
    arrList2 = [10, 0]
    arrList1.containsAll(arrList2) = true
    arrList2 = [10, 0, 369, -55]
    arrList1.containsAll(arrList2) = false
    ```
  </details>

  <Br>
  
### 삭제
- **`remove(Object o)`**
  > 리스트에서 값이 `o`인 요소를 삭제 후,  
  > 그 결과를 `true` 또는 `false`로 반환  

  ```java
  import java.util.ArrayList;
  
  public class arraylist {
      public static void main(String args[]) {
      
          ArrayList<String> arraylist = new ArrayList<>();
          
          arraylist.add("1");
          arraylist.add("a");
          arraylist.add("앙");
          arraylist.add("!");
          arraylist.add("-1");
          
          System.out.println("arraylist = " + arraylist);
          System.out.println("arraylist.remove(\"!\") = " + arraylist.remove("!"));
          System.out.println("arraylist = " + arraylist);
          System.out.println("arraylist.remove(\"d\") = " + arraylist.remove("d"));
          System.out.println("arraylist = " + arraylist);
      
      }
  }
  ```
  <details>
    <summary>Output</summary>
    
    ```
    arraylist = [1, a, 앙, !, -1]
    arraylist.remove("!") = true
    arraylist = [1, a, 앙, -1]
    arraylist.remove("d") = false
    arraylist = [1, a, 앙, -1]
    ```
  </details>

  - **ArrayList에 같은 요소가 여러개있으면 어떻게 삭제될까?**
    ```java
    import java.util.ArrayList;
    
    public class arraylist {
        public static void main(String args[]) {
        
            ArrayList<String> arraylist = new ArrayList<>();
            
            arraylist.add("1");
            arraylist.add("a");
            arraylist.add("앙");
            arraylist.add("1");
            arraylist.add("!");
            arraylist.add("1");
            
            System.out.println("arraylist = " + arraylist);
            System.out.println("arraylist.remove(\"1\") = " + arraylist.remove("1"));
            System.out.println("arraylist = " + arraylist);
            System.out.println("arraylist.remove(\"1\") = " + arraylist.remove("1"));
            System.out.println("arraylist = " + arraylist);
        
        }
    }
    ```
    <details>
      <summary>Output</summary>
      
      ```
      arraylist = [1, a, 앙, 1, !, 1]
      arraylist.remove("1") = true
      arraylist = [a, 앙, 1, !, 1]
      arraylist.remove("1") = true
      arraylist = [a, 앙, !, 1]
      ```
      ***인덱스가 작은 요소부터 삭제가 되는 것을 확인할 수 있다.***
    </details>

<Br>

- **`remove(int index)`**  
  > 리스트에서 인덱스가 `index`인 요소를 삭제 후, 그 요소를 반환  
  > ArrayList의 인덱스 범위를 넘어선 `index`를 매개변수로 주면 **IndexOutOfBoundsException** 발생  
  > 
 
  ```java
  import java.util.ArrayList;
  
  public class arraylist {
    public static void main(String args[]) {
  
        ArrayList<String> arraylist = new ArrayList<>();
        
        arraylist.add("1");
        arraylist.add("a");
        arraylist.add("앙");
        arraylist.add("!");
        arraylist.add("-1");
        
        System.out.println("arraylist = " + arraylist);
        System.out.println("arraylist.remove(0) = " + arraylist.remove(0));
        System.out.println("arraylist = " + arraylist);
        System.out.println("arraylist.remove(\"d\") = " + arraylist.remove(-1));
        System.out.println("arraylist = " + arraylist);
  
    }
  }
  ```
  <details>
    <summary>Output</summary>
    
    ```
    arraylist = [1, a, 앙, !, -1]
    arraylist.remove(0) = 1
    arraylist = [a, 앙, !, -1]
    
    Exception in thread "main" java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 4
      at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
      at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
      at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
      at java.base/java.util.Objects.checkIndex(Objects.java:385)
      at java.base/java.util.ArrayList.remove(ArrayList.java:551)
      at arraylist.main(arraylist.java:17)
    ```
  </details>

  - **ArrayList<Integer>로 생성한 ArrayList는 `remove(int index)`로 삭제시, 요소로 삭제될까? index로 삭제될까?**
    ```java
    import java.util.ArrayList;
  
    public class arraylist {
        public static void main(String args[]) {
        
            ArrayList<Integer> arraylist = new ArrayList<>();
            
            arraylist.add(1);
            arraylist.add(0);
            arraylist.add(2);
            arraylist.add(10);
            arraylist.add(-5);
            arraylist.add(123);
            
            System.out.println("arraylist = " + arraylist);
            System.out.println("arraylist.remove(1) = " + arraylist.remove(1));
            System.out.println("arraylist = " + arraylist);
            System.out.println("arraylist.remove(0) = " + arraylist.remove(0));
            System.out.println("arraylist = " + arraylist);

        }
    }
    ```
    <details>
      <summary>Output</summary>
      
      ```
      arraylist = [1, 0, 2, 10, -5, 123]
      arraylist.remove(1) = 0
      arraylist = [1, 2, 10, -5, 123]
      arraylist.remove(0) = 1
      arraylist = [2, 10, -5, 123]
      ```
      ***`remove()`메서드의 매개변수를 인덱스가 아닌 요소로 보고 삭제를 한 것을 확인할 수 있다.***
    </details>
    
    <br>
    
- boolean **`retainAll(배열)`**'  
  > 매개변수로 준 `배열`의 원소와 일치하는 값을 제외한 모든 값을 삭제  

  ```java
  import java.util.ArrayList;
  
  public class arrayList {
      public static void main(String args[]) {
    
          ArrayList<Integer> arrList1 = new ArrayList<>();
        
          arrList1.add(1);
          arrList1.add(0);
          arrList1.add(2);
          arrList1.add(10);
          arrList1.add(-5);
          arrList1.add(123);
        
          ArrayList<Integer> arrList2 = new ArrayList<>();
        
          arrList2.add(3);
          arrList2.add(10);
          arrList2.add(5);
          arrList2.add(-1);
          arrList2.add(100);
          arrList2.add(0);
        
          System.out.println("arrList1 = " + arrList1);
          System.out.println("arrList2 = " + arrList2);
        
          System.out.println("arrList1.retainAll(arrList2) = " + arrList1.retainAll(arrList2));
          System.out.println("arrList1 = " + arrList1);

  	  System.out.println("arrList1.retainAll(arrList2) = " + arrList1.retainAll(arrList2));
          System.out.println("arrList1 = " + arrList1);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList1 = [1, 0, 2, 10, -5, 123]
    arrList2 = [3, 10, 5, -1, 100, 0]
    arrList1.retainAll(arrList2) = true
    arrList1 = [0, 10]
    arrList1.retainAll(arrList2) = false
    arrList1 = [0, 10]
    ```
  </details>

<br>

- **`removeAll(배열)`**  
  > 매개변수로 준 `배열`의 원소와 일치하는 값을 모두 삭제
  > `retainAll()`메서드와 반대  

  ```java
  import java.util.ArrayList;
  
  public class arrayList {
      public static void main(String args[]) {
      
          ArrayList<Integer> arrList1 = new ArrayList<>();
        
          arrList1.add(1);
          arrList1.add(0);
          arrList1.add(2);
          arrList1.add(10);
          arrList1.add(-5);
          arrList1.add(123);
        
          ArrayList<Integer> arrList2 = new ArrayList<>();
        
          arrList2.add(3);
          arrList2.add(10);
          arrList2.add(5);
          arrList2.add(-1);
          arrList2.add(100);
          arrList2.add(0);
        
          System.out.println("arrList1 = " + arrList1);
          System.out.println("arrList2 = " + arrList2);
        
          System.out.println("arrList1.removeAll(arrList2) = " + arrList1.removeAll(arrList2));
          System.out.println("arrList1 = " + arrList1);
    
          System.out.println("arrList1.removeAll(arrList2) = " + arrList1.removeAll(arrList2));
          System.out.println("arrList1 = " + arrList1);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList1 = [1, 0, 2, 10, -5, 123]
    arrList2 = [3, 10, 5, -1, 100, 0]
    arrList1.removeAll(arrList2) = true
    arrList1 = [1, 2, -5, 123]
    arrList1.removeAll(arrList2) = false
    arrList1 = [1, 2, -5, 123]
    ```
  </details>

- **`clear()`**
  > 배열의 값을 모두 삭제

  ```java
  import java.util.ArrayList;

  public class arrayList {
      public static void main(String args[]) {
    
          ArrayList<Integer> arrList = new ArrayList<>();
        
          arrList.add(1);
          arrList.add(0);
          arrList.add(2);
          arrList.add(10);
        
          System.out.println("arrList = " + arrList);
          arrList.clear();
          System.out.println("clear()메서드 사용 후, arrList = " + arrList);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList = [1, 0, 2, 10]
    clear()메서드 사용 후, arrList = []
    ```
  </details>

### 배열 to ArrayList
- **`Arrays.asList(배열)`**
  ```java
  import java.util.ArrayList;
  import java.util.Arrays;
    
      public class arraylist {
          public static void main(String args[]) {
              Integer[] intArr = {1, 3, 0, 10};
              ArrayList<Integer> arraylist = new ArrayList<>(Arrays.asList(intArr));
              
              System.out.println("arraylist = " + arraylist);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [1, 3, 0, 10]
    ```
    ***※ 위의 매개변수에는 int[]형을 넣으면 에러 발생***
	</details>
 <br>
 
 **매개변수에 직접 요소를 넣어서 ArrayList를 만들 수도 있다.**
  ```java
  import java.util.ArrayList;
  import java.util.Arrays;
    
      public class arraylist {
          public static void main(String args[]) {
              ArrayList<Integer> arraylist = new ArrayList<>(Arrays.asList(1, 3, 0, 10));
              
              System.out.println("arraylist = " + arraylist);
      }
  }
  ```
  <details>
    <summary>Output</summary>
    
    ```
    arraylist = [1, 3, 0, 10]
    ```
  </details>
  
<br>

## ArrList to 배열
- **`toArray()`**
  > ArrayList 타입의 인스턴스를 일반 배열 타입으로 반환  
  > 저장할 배열 타입에 맞춰 자동 형변환  
  > 배열 크기 또한 자동으로 맞춰서 바꿔줌  

  ```java
  import java.util.ArrayList;
  import java.util.Arrays;

  public class arrayList {
      public static void main(String args[]) {
    
          ArrayList<String> arrList = new ArrayList<>();
        
          arrList.add("1");
          arrList.add("0");
          arrList.add("2");
          arrList.add("10");
        
          System.out.println("arrList = " + arrList);
        
          String[] strArr = new String[0];
          System.out.println("strArr = " + Arrays.toString(arrList.toArray(strArr)));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arrList = [1, 0, 2, 10]
    strArr = [1, 0, 2, 10]
    ```
  </details>
  
## 요소를 합쳐 문자열 만들기
- **`String.join(String s, ArrayList arraylist)`**
  > 첫번째 매개변수는 구분자  
  > 두번째 매개변수는 리스트 객체  
  > 리스트의 각 요소에 구분자를 넣어 하나의 문자열로 만들어 반환  
  
  ```java
  import java.util.ArrayList;

  public class arraylist {
      public static void main(String args[]) {
          ArrayList<String> arraylist = new ArrayList<>();
          arraylist.add("H");
          arraylist.add("A");
          arraylist.add("P");
          arraylist.add("P");
          arraylist.add("Y");
          
          System.out.println("String.join(\",\", arraylist) = " + String.join("+",arraylist));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    String.join(",", arraylist) = H+A+P+P+Y
    ```
	</details>
<br>

### 정렬
> `sort()`메서드를 사용 *(Java8 버전부터 사용 가능)*

- **오름차순(순방향) 정렬**
  `Comparator.naturalOrder()`

  ```java
  import java.util.ArrayList;
  import java.util.Comparator;
  
  public class arraylist {
      public static void main(String args[]) {
          ArrayList<String> arraylist = new ArrayList<>();
          arraylist.add("Hello");
          arraylist.add("Apple");
          arraylist.add("People");
          arraylist.add("Pocket");
          arraylist.add("Yellow");
          
          arraylist.sort(Comparator.naturalOrder());
          System.out.println("arraylist = " + arraylist);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [Apple, Hello, People, Pocket, Yellow]
    ```
	</details>
 <br>
 
- **내림차순(역방향) 정렬**
  `Comparator.reverseOrder()`
  ```java
  import java.util.ArrayList;
  import java.util.Comparator;
  
  public class arraylist {
      public static void main(String args[]) {
          ArrayList<String> arraylist = new ArrayList<>();
          arraylist.add("Hello");
          arraylist.add("Apple");
          arraylist.add("People");
          arraylist.add("Pocket");
          arraylist.add("Yellow");
          
          arraylist.sort(Comparator.reverseOrder());
          System.out.println("arraylist = " + arraylist);
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    arraylist = [Yellow, Pocket, People, Hello, Apple]
    ```
	</details>


---
##### References(참고 자료)
[점프 투 자바 / 03장 자바의 기초 - 자료형 / 03-07 리스트](https://wikidocs.net/207#contains)  
