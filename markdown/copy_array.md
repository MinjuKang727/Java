# 배열 복사하기

## 주소값 복사
- **`B = A;`**
  > 배열 `B`에 배열`A`의 주소를 할당  
  > 주소값을 복사하는 것이기 때문에 `A`의 원소 일부를 변경 후,  
  > 배열 `B`의 원소를 따로 변경하지 않더라도 배열`A`와 배열`B`의 원소가 모두 일치함.
  
    ```java
    import java.util.Arrays;

    public class copyArray {
        
        public static void main(String args[]) {
            int[] arr = {1, 3, 10, -1, 999999999};
            int[] copyArr = arr;
            
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            System.out.println("Arrays.toString(copyArr) = " + Arrays.toString(copyArr));
            
            System.out.println("\narr의 원소를 수정 후, copyArr에 arr 할당 없이 출력");
            arr[3] = 486;
            
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            System.out.println("Arrays.toString(copyArr) = " + Arrays.toString(copyArr));
     
        }
    }
    ```
    <details>
      <summary>Output</summary>
    
      ```
      Arrays.toString(arr) = [1, 3, 10, -1, 999999999]
      Arrays.toString(copyArr) = [1, 3, 10, -1, 999999999]
      
      arr의 원소를 수정 후, copyArr에 arr 할당 없이 출력
      Arrays.toString(arr) = [1, 3, 10, 486, 999999999]
      Arrays.toString(copyArr) = [1, 3, 10, 486, 999999999]
      ```
      ***`B = A;` 코드 실행 결과, 배열이 같아진 것을 확인할 수 있다.  
      주소값을 복사한 것이므로  
      배열값 일부를 변경해도 다시 할당 없이 계속 같은 배열인 것을 확인할 수 있다.***
    </details>

<br>

## 복제
  > 새로운 메모리 공간에 값 복사

- **`B = A.clone();`**
  > 배열 `A`의 값들을 배열 `A`에 복사  
  > 주소값 복사x → 새로운 메모리 공간에 값 복사  
  > 배열 복제 후 변경 내용은 적용x
  > 1차원 배열 복사
  
  ```java
  import java.util.Arrays;
  
  
  public class copyArray {
      
      public static void main(String args[]) {
          int[] arr = {1, 3, 10, -1, 999999999};
          int[] copyArr = arr.clone();
          
          System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
          System.out.println("Arrays.toString(copyArr) = " + Arrays.toString(copyArr));
          
          System.out.println("\narr의 원소를 수정 후, copyArr에 arr 할당 없이 출력");
          arr[3] = 486;
          
          System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
          System.out.println("Arrays.toString(copyArr) = " + Arrays.toString(copyArr));
   
      }
  }
  ```
  <details>
      <summary>Output</summary>
  
      ```
      Arrays.toString(arr) = [1, 3, 10, -1, 999999999]
      Arrays.toString(copyArr) = [1, 3, 10, -1, 999999999]
      
      arr의 원소를 수정 후, copyArr에 arr 할당 없이 출력
      Arrays.toString(arr) = [1, 3, 10, 486, 999999999]
      Arrays.toString(copyArr) = [1, 3, 10, -1, 999999999]
      ```
      ***`clone()`메서드 사용 결과, 두 배열 값이 같아진 것을 확인할 수 있다.  
      하지만, 새로운 메모리 공간에 값을 복사한 것이므로  
      한쪽 배열을 수정한 결과가 다른 배열에 적용되지는 않는다.
      두 배열을 같게 만들고 싶으면 다시 배열을 복사해 주어야 함.***
  </details>
<Br>

### 배열의 일부만 복사 & 원하는 위치에 붙여넣기
  > `clone()`보다 더 빠른 코드"  
  > `System.arraycopy()`는 Java Native Interface를 사용하기 때문에 `clone()`보다 더 빠름.

  - **`System.arraycopy(Object o, int idx1, Object o2, int idx2, int len);`**
    > `o1` : 복사할 대상  
    > `idx1` : 복사할 배열(`o1`)의 시작 **index**  
    > `o2` : 복사될 곳  
    > `idx2` : 복사될 곳(`o2`)의 시작 **index**  
    > `len` : 복사할 길이(**원소 개수**)  
              `o1.length - idx1 <= len`  
              `o2.length - idx2 >= len`
      ```java
      import java.util.Arrays;

      public class copyArray {
          
          public static void main(String args[]) {
              int[] arr1 = {1, 3, 10, -1, 999999999};
              int[] arr2 = {123, 65, 0, 10, -45, 6};
              
              System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
              System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
              
              System.out.println("\n배열 arr1의 인덱스 2번부터 3개 원소를 배열 arr2의 2번 인덱스를 시작 인덱스로 복사");
              System.arraycopy(arr1, 2, arr2, 2, 3);
              System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
              System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
              
          }
      }
      ```
      <details>
          <summary>Output</summary>
      
          ```
          Arrays.toString(arr1) = [1, 3, 10, -1, 999999999]
          Arrays.toString(arr2) = [123, 65, 0, 10, -45, 6]
          
          배열 arr1의 인덱스 2번부터 3개 원소를 배열 arr2의 2번 인덱스를 시작 인덱스로 복사
          Arrays.toString(arr1) = [1, 3, 10, -1, 999999999]
          Arrays.toString(arr2) = [123, 65, 10, -1, 999999999, 6]
          ```
      </details>
<Br>

## 원하는 길이만큼 복사
- **`B = Arrays.copyOf(A, int len);`**
  > 복사할 배열을 `0`번 인덱스부터 `len` 길이만큼 복사  
  > `A` : 복사할 배열  
  > `len` : 새로 만들 배열(`B`)의 길이  

  ```java
  import java.util.Arrays;
  
  public class copyArray {
      
      public static void main(String args[]) {
          int[] arr1 = {1, 3, 10, -1, 999999999};
          int[] arr2 = Arrays.copyOf(arr1, 4);
          
          System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
          System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
          
          arr2 = Arrays.copyOf(arr1, 10);
          System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
      }
  }
  ```
  <details>
      <summary>Output</summary>
  
      ```
      Arrays.toString(arr1) = [1, 3, 10, -1, 999999999]
      Arrays.toString(arr2) = [1, 3, 10, -1]
      Arrays.toString(arr2) = [1, 3, 10, -1, 999999999, 0, 0, 0, 0, 0]
      ```
      ***배열 길이를 복사할 배열의 길이보다 길게 주면 복사할 배열 길이보다 긴 뒷부분 인덱스의 값은 `0`으로 채움***
  </details>

<br>

## 원하는 시작점, 종료점 설정
- **`B = Arrays.copyOfRange(A, int idx1, int idx2);`**
  > 복사할 배열의 `idx1`인덱스부터 `idx2 - 1`인덱스까지 복사  
  > `idx2 > A.length`이면 `A.length`인덱스의 원소부터는 `0`으로 초기화  
  > `A` : 복사할 배열  
  > `idx1` : 복사할 배열의 시작 **index**  
  > `idx2` : 복사할 배열의 종료 **index**

    ```java
    import java.util.Arrays;

    public class copyArray {
        
        public static void main(String args[]) {
            int[] arr1 = {1, 3, 10, -1, 999999999};
            int[] arr2 = Arrays.copyOfRange(arr1, 2, 4);
            
            System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
            System.out.println("Arrays.copyOfRange(arr1, 2, 4) 결과 : " + Arrays.toString(arr2));
            
            
            arr2 = Arrays.copyOfRange(arr1, 2, 10);
            System.out.println("Arrays.copyOfRange(arr1, 2, 10) 결과 : " + Arrays.toString(arr2));
        }
    }
    ```
    <details>
        <summary>Output</summary>
    
        ```
        Arrays.toString(arr1) = [1, 3, 10, -1, 999999999]
        Arrays.copyOfRange(arr1, 2, 4) 결과 : [10, -1]
        Arrays.copyOfRange(arr1, 2, 10) 결과 : [10, -1, 999999999, 0, 0, 0, 0, 0]
        ```
    </details>

<Br>

---
##### References(참고 자료)
[[Java] Array copy 배열 복사/복제](https://owlyr.tistory.com/17)
