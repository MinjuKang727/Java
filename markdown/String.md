# String(문자열)

## 형변환
### char to String
- String **`Character.toString(char c)`**
  ```java
  String str = "char to String";
  char[] cArr = str.toCharArray();
  String cArr2s = "";
              
  for (int j = 0; j < cArr.length; j++) {
      cArr2s+= Character.toString(cArr[j]);
  }
  System.out.println(cArr2s);
  ```
  <details>
    <summary>Output</summary>

    ```
    char to String
    ```
	</details>

- String **`String.valueOf(char c)`**
  > 매개변수로 `null`이 들어오면 **NullPointerException** 발생
  ```java
  char c = 'a';
  System.out.println("String.valueOf(c) = " + String.valueOf(c));
  System.out.println("String.valueOf(null) = " + String.valueOf(null));
  ```
  <details>
    <summary>Output</summary>

    ```
    String.valueOf(c) = a
    
    Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "value" is null
    	at java.base/java.lang.String.<init>(String.java:278)
    	at java.base/java.lang.String.valueOf(String.java:4475)
    	at stringExample.main(stringExample.java:7)
    ```
	</details>
<br>

### char[] to String
- String **`new String(Char[] c, int offset, int count)`**
  > char[]형 객체를 인덱스 `offset` ~ `count`까지 잘라 String형 객체를 반환  
  > `offset`과 `count`를 생략하면 char[]형 객체의 원소 전체를 합쳐 String형 객체 반환    
  > `offset` : 시작 인덱스  
  > `count` : 마지막 인덱스  
  
  
  ```java
  char[] cArr = {'a', 'b', 'c', 'd'};
  String s = new String(cArr, 1, 3);
  String s2 = new String(cArr);
  
  System.out.println("new String(cArr, 1, 3) = " + s);
  System.out.println("new String(cArr) = " + s2);
  ```
  <details>
    <summary>Output</summary>

    ```
    new String(cArr, 1, 3) = bcd
    new String(cArr) = abcd
    ```
    ***String클래스가 내부적으로 char[]형을 업그레이드해서 만들어졌기 때문에 변환이 가능***  

  **참고**
    - 기본형 변수 : `int`, `char`, `byte` 등
    - String은 기본형 변수가 아니라 자바에서 제공해 주는 클래스
      ```
      new연산자로 생성해 주는 것이 원칙이지만  
      굉장히 많이 사용하는 클래스이기 때문에
      자바에서 new 연산자 없이 생성 가능하도록 만들어 준 것 임.
      ```
  </details>

- String **`String.valueOf(char[] c)`**  
  > 매개변수로 `null`이 들어오면 **NullPointerException**을 반환  
  
  ```java
  char[] cArr = {'a','b','c','d','e'};
  String s = String.valueOf(cArr);
  System.out.println("String.valueOf(cArr) = " + String.valueOf(cArr));
  System.out.println("String.valueOf(null)" + String.valueOf(null));
  ```
  <details>
    <summary>Output</summary>

    ```
    String.valueOf(cArr) = abcde
    
    Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "value" is null
    	at java.base/java.lang.String.<init>(String.java:278)
    	at java.base/java.lang.String.valueOf(String.java:4475)
    	at stringExample.main(stringExample.java:8)
    ```
	</details>

- **for문 이용하기**
  ```java
  char[] cArr = {'c', 'h', 'a', 'r', 'A', 'r', 'r', 'a', 'y'};
  String s = "";
              
  for (int i = 0; i < cArr.length; i++) {
      s += Character.toString(cArr[i]);
  }
  
  System.out.println("char[] to String: s = " + s);
  ```
  <details>
    <summary>Output</summary>

    ```
    char[] to String: s = charArray
    ```
	</details>
  
<br>

### String to char[]
- **`char배열.toString()`으로 변환하면 안될까?**
  ```java
  char[] arr = {'a', 'b', 'c', 'd', 'e'};
  String str = arr.toString();
  System.out.println(str + "의 자료형은 " +str.getClass().getName());
  ```
  <details>
    <summary>Output</summary>

    ```
    [C@7344699f의 자료형은 java.lang.String
    ```
    ***char[]에 `toString()`메서드가 존재하지만
    String클래스로 변환해 주는 것이 아닌 해시코드를 가져오는 메서드***

    ```java
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    ```
  </details>

<br>
  
## String to Char[]
- **`String.toCharArray()`**  
  > 문자열을 한 글자씩 나눠 `char[]`형으로 반환
  > 배열을 생성하여 처리하기 때문에 속도가 느리다.
  
  ```java
  import java.util.Arrays;
  
  public class stringExample {
      public static void main(String args[]) {
          String str = "Char 변환하기";
          char[] arr = str.toCharArray();
          System.out.println(Arrays.toString(arr));
      }
  }
  ```
   <details>
    <summary>Output</summary>

    [C, h, a, r,  , 변, 환, 하, 기]
  </details>  

<br>

### 배열을 문자열로 출력하기
- String **`Arrays.toString(배열)`**
  ```java
  char[] c = {'1', '2', '3', '4'};
  System.out.println("c = " + c);
  System.out.println("char[] 출력: " + Arrays.toString(c));
  
  String[] s = {"a", "n", "d", "e"};
  System.out.println("s = " + s);
  System.out.println("String[] 출력: " + Arrays.toString(s));
  
  int[] i = {1, 32, 12, 5, 0};
  System.out.println("i = " + i);
  System.out.println("int[] 출력: " + Arrays.toString(i));
  ```
  <details>
    <summary>Output</summary>

    ```
    c = [C@7344699f
    char[] 출력: [1, 2, 3, 4]
    s = [Ljava.lang.String;@7e9e5f8a
    String[] 출력: [a, n, d, e]
    i = [I@8bcc55f
    int[] 출력: [1, 32, 12, 5, 0]
    ```
    ***배열을 그냥 출력하면 배열이 아닌 다른 값이 출력되는 것을 확인할 수 있다.  
    `Arrays.toString()`을 이용한 출력 결과에서는 배열의 원소들을 모두 확인 가능하다는 것을 알 수 있다.***
	</details>


### Integer to String
- **빈 문자열 더하기**  
  > String + String = String  
  > String + Integer = Strng  *(Integer + String = String)*
  
  ```java
  int num = 10;
  String strN = "" + num;
  String strN2 = num + "";
  ```
- String **`Integer.toString(int n)`**
  ```java
  int num = 10;
  String strN = Integer.toString(num);
  ```

- String **`String.valueOf(int n)`**
  > `Integer.toString()`과 정확히 같은 기능
  ```java
  int num = 10;
  String strN = String.valueOf(num);
  ```
<br>

### String to Integer
- int **`Integer.parseInt(String s)`**
  ```java
  String strN = "10";
  int n = Integer.parseInt(strN);
  ```
  ***단, String형 숫자가 int형의 값 범위 안이어야 한다.  
  아래 범위를 넘어가면 NumberFormatException 발생***

#### int형의 값 범위
```java
System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
```
<details>
    <summary>Output</summary>

    ```
    Integer.MAX_VALUE = 2147483647
    Integer.MIN_VALUE = -2147483648
    ```
</details>


<br><br>

## 문자열 길이
- int **length()**  
  > 문자열 길이를 반환  

  ```java
  String str = "나Java봐라!";
  
  System.out.println("str.length() = " + str.length());
  ```
  <details>
    <summary>Output</summary>

    ```
    str.length() = 8
    ```
  </details>

  ## 특정 인덱스 문자 가져오기
  - char **`String.charAt(int index)`**  
    > 문자열에서 특정 위치(index)에 있는 값을 반환
    > `toCharArray()`메서드에 비해내부적인 처리 속도가 빠름. (∵ 배열 생성x)

    ```java
    String str = "나Java봐라!";
    
    for (int i = 0; i < str.length(); i++) {
        System.out.println("str.charAt(" + i + ") = " + str.charAt(i));
    }
    ```
    <details>
      <summary>Output</summary>
  
      ```
      str.charAt(0) = 나
      str.charAt(1) = J
      str.charAt(2) = a
      str.charAt(3) = v
      str.charAt(4) = a
      str.charAt(5) = 봐
      str.charAt(6) = 라
      str.charAt(7) = !
      ```
    </details>

## 일치
- boolean **`equals(String s)`**  
  > 문자열의 내용이 같은지 확인  

  ```java
  String str = "-_/.=*+";
  String[] findStar = str.split("");
  
  for (int i = 0; i < str.length(); i++) {
      System.out.println(findStar[i] + " 가 * 인가? " + findStar[i].equals("*"));
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    - 가 * 인가? false
    _ 가 * 인가? false
    / 가 * 인가? false
    . 가 * 인가? false
    = 가 * 인가? false
    * 가 * 인가? true
    + 가 * 인가? false
    ```
  </details>

## 문자열 자르기
- String **`subString(int from, int to)`**
  > 문자열의 해당 인덱스 범위(from ~ to - 1)의 내용을 반환  
 
  ```java
  String str = "****여기서부터~~~여기까지*****";
  
  System.out.println("str = " + str);
  System.out.println("str.substring(4,16) = " + str.substring(4,16));
  ```
  <details>
    <summary>Output</summary>

    ```
    str = ****여기서부터~~~여기까지*****
    str.substring(4,16) = 여기서부터~~~여기까지
    ```
  </details>

- String[] **`String.split(String s, int n)`**
  > `String` : 자를 문자열  
  > 매개변수 `s`: 문자열을 자를 기준 문자열  
  > 매개변수 `n` : 결과값 배열 길이 제한 *(지정해 주지 않으면 배열 길이 제한 없음)*

  - `문자열.split("")` : 한 문자씩 잘라서 배열을 만듦.
  - `문자열.split("/")` : 문자열을 자르는 기준 문자열은 /, 배열 길이 제한 없음.
  - `문자열.split("1", 4)` : 문자열을 자르는 기준 문자열은 1, 배열 길이는 최대 4
    *(원소 3개까지 자른 후,  
    뒷부분은 기준 문자열인 1을 포함하고 있더라도  
    더 이상 자르지 않고 마지막 원소로 넣음)*

  ```java
  String str = "13526142645116";
  System.out.println("str = " + str);
  System.out.println("str.split() = " + Arrays.toString(str.split("")));
  System.out.println("str.split(1) = " + Arrays.toString(str.split("1")));
  System.out.println("str.split(1, 2) = " + Arrays.toString(str.split("1", 2)));
  ```
  <details>
    <summary>Output</summary>

    ```
    str = 13526142645116
    str.split() = [1, 3, 5, 2, 6, 1, 4, 2, 6, 4, 5, 1, 1, 6]
    str.split(1) = [, 3526, 42645, , 6]
    str.split(1, 2) = [, 3526142645116]
    ```
  </details>

- **Stream이용**
  > `char()`메서드로 `IntStream`화 한 후,  
  > `char`형 `stream`으로 변환
  > `forEach`로 한 글자씩 분리

  ```java
  String str = "stream으로 분리해봐";

  str.chars() // (IntStream)
  		.mapToObj(i -> (char) i) // Stream<Character> 으로 변환
          .forEach(System.out::println); // 출력
  ```
  <details>
    <summary>Output</summary>

    ```
    s
    t
    r
    e
    a
    m
    으
    로
     
    분
    리
    해
    봐
    ```
	</details>

---

##### References(참고 자료)
[[Java] String 문자열을 char 배열로 변환하기](https://hianna.tistory.com/542)  
[Java | split(""), toCharArray(), charAt(i), chars(IntStream) | 문자열 한 글자씩 분리하기](https://velog.io/@lynn080/Java-%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%95%9C-%EA%B8%80%EC%9E%90%EC%94%A9-%EB%B6%84%EB%A6%AC%ED%95%98%EA%B8%B0)  
[자바 String을 Char로, Char를 String으로 변환하기](https://kutar37.tistory.com/entry/%EC%9E%90%EB%B0%94-String%EC%9D%84-Char%EB%A1%9C-Char%EB%A5%BC-String%EC%9C%BC%EB%A1%9C-%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0)
