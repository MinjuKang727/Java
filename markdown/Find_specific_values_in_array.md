# 배열에서 특정 값 찾기
`Java` `array` `배열`

<br>

## 1. 반복문
> `for`문 또는 `forEach`문을 사용해 배열의 요소에 접근  
> `equals()`메서드를 사용해 특정 값을 비교  

- **`for`문 이용하기**
```java
public class MyClass {
    public static void main(String args[]) {
        String[] strArr = {"AB", "BC", "BCD", "CD", "CDEF"};
        String target = "AB";
        
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(target)) {
                System.out.println(target + "는 strArr의 " + i +"인덱스에 존재합니다.");
            }
        }
    }
}
```

<details>
  <summary>Output</summary>

  ```
  AB는 strArr의 0인덱스에 존재합니다.
  ```
</details>

<br>

- **`forEach`문 이용하기**
```java
public class MyClass {
    public static void main(String args[]) {
        String[] strArr = {"AB", "BC", "BCD", "CD", "CDEF"};
        String target = "AB";
        
        for (String str : strArr) {
            if (str.equals(target)) {
                System.out.println(target + "는 strArr에 존재합니다.");
            }
        }
    }
}
```
<details>
    <summary>Output</summary>

    ```
    AB는 strArr에 존재합니다.
    ```
</details>

  
## List 변환 후, 찾기
  - boolean `contains(찾고자 하는 값)`  
    > 특정 값이 List에 포함되어 있으면 `true`를 반환  
    > 특정 값이 List에 포함되어 있지 않으면 `false`를 반환  
    ```java
    import java.util.List;
    import java.util.Arrays;
    
    public class MyClass {
        public static void main(String args[]) {
            List<String> strList = Arrays.asList("a", "sd", "bca", "d", "O");
            
            System.out.println("strList = " + strList);
            System.out.println("strList.contains(\"A\") = " + strList.contains("A"));
            System.out.println("strList.contains(\"a\") = " + strList.contains("a"));
            
            
            List<Integer> intList = Arrays.asList(1, 3, -1, 1023, 0);
            
            System.out.println("intList = " + intList);
            System.out.println("intList.contains(10) = " + intList.contains(10));
            System.out.println("intList.contains(1023) = " + intList.contains(1023));
        }
    }
    ```
    <details>
        <summary>Output</summary>
    
        ```
        strList = [a, sd, bca, d, O]
        strList.contains("A") = false
        strList.contains("a") = true
        intList = [1, 3, -1, 1023, 0]
        intList.contains(10) = false
        intList.contains(1023) = true
        ```
    </details>

  - boolean `containsAll(List list)`  
    > List가 전달받은 list의 원소를 모두 포함하면 `true`를 반환  
    > List가 전달받은 list의 원소 중 적어도 하나를 포함하지 않으면 `false`를 반환  
    ```java
    import java.util.List;
    import java.util.Arrays;
    
    public class MyClass {
        public static void main(String args[]) {
            List<String> strList = Arrays.asList("a", "sd", "bca", "d", "O");
            List<String> TargetStrList1 = Arrays.asList("O", "bca", "a");
            List<String> TargetStrList2 = Arrays.asList("abc", "c", "A");
            List<String> TargetStrList3 = Arrays.asList("O", "bca", "b");
            
            System.out.println("strList = " + strList);
            System.out.println("TargetStrList1 = " + TargetStrList1);
            System.out.println("strList.containsAll(TargetStrList1) = " + strList.containsAll(TargetStrList1));
            System.out.println("TargetStrList2 = " + TargetStrList2);
            System.out.println("strList.containsAll(TargetStrList2) = " + strList.containsAll(TargetStrList2));
            System.out.println("TargetStrList3 = " + TargetStrList3);
            System.out.println("strList.containsAll(TargetStrList3) = " + strList.containsAll(TargetStrList3));
            
            List<Integer> intList = Arrays.asList(1, 3, -1, 1023, 0);
            List<Integer> TargetIntList1 = Arrays.asList(0, -1, 3);
            List<Integer> TargetIntList2 = Arrays.asList(100, 11, 6);
            List<Integer> TargetIntList3 = Arrays.asList(0, 1, 10);
            
            System.out.println("intList = " + intList);
            System.out.println("TargetIntList1 = " + TargetIntList1);
            System.out.println("intList.containsAll(TargetIntList1) = " + intList.containsAll(TargetIntList1));
            System.out.println("TargetIntList2 = " + TargetIntList2);
            System.out.println("intList.containsAll(TargetIntList2) = " + intList.containsAll(TargetIntList2));
            System.out.println("TargetIntList3 = " + TargetIntList3);
            System.out.println("intList.containsAll(TargetIntList3) = " + intList.containsAll(TargetIntList3));
            
        }
    }
    ```
    <details>
        <summary>Output</summary>
    
        ```
        strList = [a, sd, bca, d, O]
        TargetStrList1 = [O, bca, a]
        strList.containsAll(TargetStrList1) = true
        TargetStrList2 = [abc, c, A]
        strList.containsAll(TargetStrList2) = false
        TargetStrList3 = [O, bca, b]
        strList.containsAll(TargetStrList3) = false
        intList = [1, 3, -1, 1023, 0]
        TargetIntList1 = [0, -1, 3]
        intList.containsAll(TargetIntList1) = true
        TargetIntList2 = [100, 11, 6]
        intList.containsAll(TargetIntList2) = false
        TargetIntList3 = [0, 1, 10]
        intList.containsAll(TargetIntList3) = false
        ```
        ***원소 중 일부만 포함하는 List는 `false`를 반환***
    </details>

  
  - `indexOf(찾고자 하는 값)`  
    > 찾고자 하는 값이 List에 포함되어 있으면 **가장 첫번째 값의** `index`를 반환  
    > 포함되어 있지 않으면 `-1`을 반환  
    ```java
    import java.util.List;
    import java.util.Arrays;
    
    public class MyClass {
        public static void main(String args[]) {
            List<String> strList = Arrays.asList("a", "sd", "bca", "d", "O");
            
            System.out.println("strList = " + strList);
            System.out.println("strList.indexOf(\"b\") = " + strList.indexOf("b"));
            System.out.println("strList.indexOf(\"a\") = " + strList.indexOf("a"));
           
            List<Integer> intList = Arrays.asList(1, 3, -1, 1023, 0);
            
            System.out.println("intList = " + intList);
            System.out.println("intList.indexOf(10) = " + intList.indexOf(10));
            System.out.println("intList.indexOf(0) = " + intList.indexOf(0));
        }
    }
    ```
    <details>
        <summary>Output</summary>
    
        ```
        strList = [a, sd, bca, d, O]
        strList.indexOf("b") = -1
        strList.indexOf("a") = 0
        intList = [1, 3, -1, 1023, 0]
        intList.indexOf(10) = -1
        intList.indexOf(0) = 4
        ```
    </details>

<br>

## Stream API 이용하기
> Java 버전 1.8 이상부터 사용 가능  

- **`anyMatch()`**
  > 특정 값을 확인하는 람다식 또는 메소드 참조식을 전달해 특정 값이 있는지 확인해서  
  > 특정값이 있으면 `true`를 반환  
  > 특정값이 없으면 `false`를 반환
  ```java
  import java.util.Arrays;

  public class MyClass {
      public static void main(String args[]) {
          String[] strArr = {"a", "sd", "bca", "d", "O"};
          String target = "a";
          
          boolean isExist = Arrays.stream(strArr).anyMatch(target::equals);
          System.out.println("strArr = " + Arrays.toString(strArr));
          System.out.println("\"a\"가 strArr의 원소인가? " + isExist);
          
          target = "b";
          isExist = Arrays.stream(strArr).anyMatch(target::equals);
          System.out.println("\"b\"가 strArr의 원소인가? " + isExist);
         
          int[] intArr = {1, 3, -1, 1023, 0};
          Integer target2 = 1;
          isExist = Arrays.stream(intArr).anyMatch(target2::equals);
          System.out.println("intArr = " + Arrays.toString(intArr));
          System.out.println("1이 intArr의 원소인가? " + isExist);
          
          target2 = 2;
          isExist = Arrays.stream(intArr).anyMatch(target2::equals);
          System.out.println("2가 intArr의 원소인가? " + isExist);
      }
  }
  ```
  <details>
    <summary>Output</summary>
  
    ```
    strArr = [a, sd, bca, d, O]
    "a"가 strArr의 원소인가? true
    "b"가 strArr의 원소인가? false
    intArr = [1, 3, -1, 1023, 0]
    1이 intArr의 원소인가? true
    2가 intArr의 원소인가? false
    ```
  </details>

## 배열 정렬 후, `binarySearch()` 메소드
> `binarySearch()` 메서드는 정렬을 해야 사용할 수 있다.  

### 배열 정렬하기
- void **`sort()`**메서드
  > 데이터의 양이 많지 않을 때, 사용하자!
  
  ```java
  import java.util.Arrays;

  public class MyClass {
      public static void main(String args[]) {
          int[] intArr1 = {1, 3, -1, 1023, 0};
          
          System.out.println("intArr1 = " + Arrays.toString(intArr1));
          Arrays.sort(intArr1);
          System.out.println("sort() 정렬 후, intArr1 = " + Arrays.toString(intArr1));
  
      }
  }
  ```
  <details>
      <summary>Output</summary>
  
      ```
      intArr1 = [1, 3, -1, 1023, 0]
      sort() 정렬 후, intArr1 = [-1, 0, 1, 3, 1023]
      ```
  </details>

- **`parallelSort()`**
  > parallelSort()와 Sort()의 차이점([링크🔗](https://github.com/MinjuKang727/Java/blob/main/markdown/parallelSort_vs_Sort.md))
  > `sort()`메서드와 기능의 차이는 없으나 `parallelSort()`는 멀티쓰레드이므로 데이터 양의 5000개 이상일 때, 사용하는 것을 추천
  
  ```java
  import java.util.Arrays;

  public class MyClass {
      public static void main(String args[]) {
          int[] intArr2 = {1, 3, -1, 1023, 0};
          
          System.out.println("intArr2 = " + Arrays.toString(intArr2));
          Arrays.parallelSort(intArr2);
          System.out.println("parallelSort() 정렬 후, intArr2 = " + Arrays.toString(intArr2));
  
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    intArr2 = [1, 3, -1, 1023, 0]
    parallelSort() 정렬 후, intArr2 = [-1, 0, 1, 3, 1023]
    ```
  </details>

### 값 찾기
- int **`binarySearch(배열, 찾고 싶은 값)`**메서드
  > 정렬된 배열에서 이진 탐색을 할 수 있음.  
  > `찾고 싶은 값`이 배열에 있으면 `index`를 반환  
  > `찾고 싶은 값`이 배열에 없으면 `Insertion point * (-1) - 1`을 반환  
  > `Insertion point` : `찾고 싶은 값`보다 큰 최초의 `index`  
  >> `찾고 싶은 값`보다 큰 원소가 존재하지 않으면 `배열 길이`라고 생각하면 됨.  
      *자세히 알고 싶으면 아래 참고 자료 링크(java arrays binarysearch 함수를 알아봅시다.) 참고*  

  ```java
  import java.util.Arrays;

  public class MyClass {
      public static void main(String args[]) {
          String[] strArr = {"a", "sd", "bca", "d", "O"};
  
          System.out.println("strArr = " + Arrays.toString(strArr));
          Arrays.toString(strArr);
          System.out.println("정렬 후, strArr = " + Arrays.toString(strArr));
          
          System.out.println("Arrays.binarySearch(strArr, \"a\") = " + Arrays.binarySearch(strArr, "a"));
          System.out.println("Arrays.binarySearch(strArr, \"b\") = " + Arrays.binarySearch(strArr, "b"));
          
  
         
          int[] intArr = {1, 3, -1, 1023, 0};
          
          System.out.println("intArr = " + Arrays.toString(intArr));
          Arrays.sort(intArr);
          System.out.println("정렬 후, intArr = " + Arrays.toString(intArr));
          
          System.out.println("Arrays.binarySearch(intArr, 1) = " + Arrays.binarySearch(intArr, 1));
          System.out.println("Arrays.binarySearch(intArr, 2) = " + Arrays.binarySearch(intArr, 2));
          
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    strArr = [a, sd, bca, d, O]
    정렬 후, strArr = [a, sd, bca, d, O]
    Arrays.binarySearch(strArr, "a") = 0
    Arrays.binarySearch(strArr, "b") = -2
    intArr = [1, 3, -1, 1023, 0]
    정렬 후, intArr = [-1, 0, 1, 3, 1023]
    Arrays.binarySearch(intArr, 1) = 2
    Arrays.binarySearch(intArr, 2) = -4
    ```
  </details>
---

##### References(참고 자료)
[[JAVA] 배열에서 특정 값 찾기](https://velog.io/@hamsangjin/JAVA-%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C-%ED%8A%B9%EC%A0%95-%EA%B0%92-%EC%B0%BE%EA%B8%B0)  
[java arrays binarysearch 함수를 알아봅시다.](https://codingdog.tistory.com/entry/java-arrays-binarysearch-%ED%95%A8%EC%88%98%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4)  
