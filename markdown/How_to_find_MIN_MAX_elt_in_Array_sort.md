# 배열의 최대·최솟값 구하기

## for문 이용하기
```java
int[] arr = {1, 3, 5, 10, 0, -1};
int max = arr[0];
int min = arr[0];

for (int i = 0; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
    if (arr[i] < min) {
        min = arr[i];
    }
}

System.out.println("arr의 최대원 : " + max);
System.out.println("arr의 최소원 : " + min);
```
<details>
  <summary>Output</summary>

  ```
  arr의 최대원 : 10
  arr의 최소원 : -1
  ```
</details>

## `Arrays.sort()`(오름차순 정렬) 이용하기
```java
import java.util.Arrays;

public class arraySort {
    public static void main(String args[]) {
int[] arr = {1, 3, 5, 10, 0, -1};

Arrays.sort(arr);

int max = arr[arr.length-1];
int min = arr[0];

System.out.println("arr의 최대원 : " + max);
System.out.println("arr의 최소원 : " + min);
System.out.println("arr = " + Arrays.toString(arr));
    }
}
```
<details>
  <summary>Output</summary>

  ```
  arr의 최대원 : 10
  arr의 최소원 : -1
  arr = [-1, 0, 1, 3, 5, 10]
  ```
</details>

---
# 배열 정렬

## Arrays.sort(배열);
```java
import java.util.Arrays;

public class arraySort {
    public static void main(String args[]) {
int[] intArr = new int[] {5, 1, 10, -1};                     
double[] doubletArr = new double[] {3.3, 1.1, -5.5, 12.0, 3.14}; 
String[] strArr = new String[] {"A","b","B","E","D"};

Arrays.sort(intArr);            
Arrays.sort(doubletArr);    
Arrays.sort(strArr);

System.out.println("intArr = " + Arrays.toString(intArr));
System.out.println("doubletArr = " + Arrays.toString(doubletArr));
System.out.println("strArr = " + Arrays.toString(strArr));
    }
}
```
<details>
  <summary>Output</summary>

  ```
  intArr = [-1, 1, 5, 10]
  doubletArr = [-5.5, 1.1, 3.14, 3.3, 12.0]
  strArr = [A, B, D, E, b]
  ```
</details>
<br>

### 정렬 범위 지정
- **`Arrays.sort(배열, int fromIdx, int toIdx);`**
  > 매개변수로 정렬 시작 인덱스와 종료 인덱스를 주어 정렬 범위를 지정할 수 있다.
  > `fromIdx` : 정렬 시작 인덱스
  > `toIdx` : 정렬 범위 종료 인덱스 + 1

  ```java
  import java.util.Arrays;
  
  public class arraySort {
      public static void main(String args[]) {
          int[] intArr = new int[] {5, 1, 10, -1, 165, 22, 0};        
          System.out.println("intArr = " + Arrays.toString(intArr));
          
          Arrays.sort(intArr, 3, 6);    
          System.out.println("Arrays.sort(intArr, 3, 6); 결과: " + Arrays.toString(intArr));
          Arrays.sort(intArr, 1, 4);    
          System.out.println("Arrays.sort(intArr, 1, 4); 결과: " + Arrays.toString(intArr));
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    intArr = [5, 1, 10, -1, 165, 22, 0]
    Arrays.sort(intArr, 3, 6); 결과: [5, 1, 10, -1, 22, 165, 0]
    Arrays.sort(intArr, 1, 4); 결과: [5, -1, 1, 10, 22, 165, 0]
    ```
    
	</details>
 <br>

### 역순 정렬
- **`Arrays.sort(배열, Collections.reverseOrder());`**
  > `Collections.reverseOrder()`는 **Comparator** 객체  
  > 역순으로 정렬해 줌.


  ```java
  import java.util.Arrays;
  import java.util.Collections;
  
  public class arraySort {
      public static void main(String args[]) {
  Integer[] intArr = {5, 1, 10, -1, 165, 22, 0};        
  System.out.println("intArr = " + Arrays.toString(intArr));
  
  Arrays.sort(intArr, Collections.reverseOrder());    
  System.out.println("intArr = " + Arrays.toString(intArr));
  
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    intArr = [5, 1, 10, -1, 165, 22, 0]
    intArr = [165, 22, 10, 5, 1, 0, -1]
    ```
    ***int[]형에서는 에러 발생
    Integer[]형으로 배열 생성해야 사용 가능***
	</details>

<br>

#### Collections.sort
  > ArrayList, LinkedList와 같은 Collections 타입의 정렬을 지원  
  > 이 함수의 정렬 알고리즘은 **merge sort** (∵ quicksort와 달리 stable한 정렬이기 때문)  
  > **stable sort** : 같은 key값을 가진 node가 정렬 전과 정렬 후, 위치가 달라지지 않는다는 의미  
    *int형의 경우, 같은 값이 여러개 있을 때, 해당 숫자는 서로 위치가 달라져도 문제될 것이 없기 때문에 **quick sort** 사용*  
  > 내림차순 정렬에 사용


#### 내림차순 Comparator 구현
```java
import java.util.Arrays;
import java.util.Comparator;

public class arraySort {
    public static void main(String args[]) {
        Integer[] arr = {1, 26, 17, 25, 99, 44, 303};
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        System.out.println("Sorted arr[] : " + Arrays.toString(arr));

    }
}
```
<details>
  <summary>Output</summary>

  ```
  Sorted arr[] : [303, 99, 44, 26, 25, 17, 1]
  ```
</details>
- Lambda를 사용한 구현

---

##### References(참고 자료)
[[Java] 배열(Array) 정렬하기 (오름차순, 내림차순, 사용자 정의 정렬, 람다)](https://velog.io/@dlzlqlzl/Java-%EB%B0%B0%EC%97%B4-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-%EC%98%A4%EB%A6%84%EC%B0%A8%EC%88%9C-%EB%82%B4%EB%A6%BC%EC%B0%A8%EC%88%9C-%EC%82%AC%EC%9A%A9%EC%9E%90-%EC%A0%95%EB%A0%AC)  
[Java - 배열 정렬(Sorting) (오름차순, 내림차순)](https://codechacha.com/ko/java-sorting-array/#google_vignette)
[Java에 내장된 정렬 함수 사용하기](https://yahwang.github.io/posts/61)  
