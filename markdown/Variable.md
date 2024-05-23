# 변수

## 변수명 확인 방법
- **`변수명.getClass().getName()`**

  ```java
  import java.util.ArrayList;
  import java.util.Stack;
  import java.util.HashMap;
  
  public class variableTypeCheck {
      public static void main(String args[]) {
          Integer n = 3;
          System.out.println(n.getClass().getName());
          Double d = 1.3;
          System.out.println(d.getClass().getName());
          Boolean b = true;
          System.out.println(b.getClass().getName());
          Character c = 'a';
          System.out.println(c.getClass().getName());
          String s = "abc";
          System.out.println(s.getClass().getName());
          
          Integer[] intArr = {1, 3, 10, -1};
          System.out.println(intArr.getClass().getName());
          Double[] fArr = {1.0, 30.1, 2.123};
          System.out.println(fArr.getClass().getName());
          Boolean[] bArr = {true, true, false};
          System.out.println(bArr.getClass().getName());
          Character[] cArr = {'1', 'a', 'ㅇ'};
          System.out.println(cArr.getClass().getName());
          String[] sArr = {"H", "a", "a", "P", "y"};
          System.out.println(sArr.getClass().getName());
          
          ArrayList<String> sArrList = new ArrayList<>();
          System.out.println(sArrList.getClass().getName());
          Stack<Integer> stack = new Stack<>();
          System.out.println(stack.getClass().getName());
          HashMap<String, Integer> hm = new HashMap<>();
          System.out.println(hm.getClass().getName());
  
          
      }
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    java.lang.Integer
    java.lang.Double
    java.lang.Boolean
    java.lang.Character
    java.lang.String
    [Ljava.lang.Integer;
    [Ljava.lang.Double;
    [Ljava.lang.Boolean;
    [Ljava.lang.Character;
    [Ljava.lang.String;
    java.util.ArrayList
    java.util.Stack
    java.util.HashMap
    ```
    ***int, double, char의 기본형이 아닌 Object 타입의 변수형 확인이 가능한 것 같다.***
  </details>


---

##### References(참고 자료)
[자바 변수 타입 확인방법](https://wakestand.tistory.com/186)
