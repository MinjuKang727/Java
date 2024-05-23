## Stack(스택)
  > 수식계산, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로 같은 기능들을 구현할 때 활용  
- Stack에 저장된 원소는 top으로 정한 곳만 접근이 가능  
- 후입선출(**LIFO**; Last In First Out) 구조 : 마지막에 삽입한 원소는 맨 위에 쌓여 있다가 가장 먼저 삭제 된다.  
- 1차원 배열 혹은 LinkedList로 구현 가능  
  
![스택 구조](https://github.com/MinjuKang727/Java/assets/108849480/379f8d29-2d01-4852-a2e3-2e7de9a41b5d)

### import
```java
import java.util.Stack;
```
<br>

### 선언
- **방법1**    
  ```java
  Stack 변수명 = new Stack();
  ```
  > 어떤 자료형이든 삽입, 삭제 가능  
  
  - **자료형 없이 생성한 Stack에 Integer값과 String값을 넣어보자.**
    ```java
    Stack stack = new Stack();
    
    stack.add(3);
    stack.add("3");
    System.out.println(stack);
    ```
    <details>
      <summary>Output</summary>
    
      ```
      [3, 3]
      ```
      ***자료형에 관계없이 모든 값이 잘 들어간 것을 확인할 수 있다.***
    </details>

- **방법2**  
  ```java
  Stack<자료형> 변수명 = new Stack<>();
  ```
  > 자료형에 넣은 자료형만 삽입, 삭제 가능  

  ```java
  Stack<Integer> stack = new Stack<>();

  stack.add(3);
  System.out.println(stack);
  ```
  <details>
    <summary>Output</summary>

    ```
    [3]
    ```
  </details>

  - **Stack\<Integer\>로 생성한 Stack에 String값을 넣으면 어떻게 될까?**
    ```java
    Stack<Integer> stack = new Stack<>();
    
    stack.add("3");
    ```
    <details>
      <summary>Output</summary>
    
      ```
      stackExample.java:8: error: incompatible types: String cannot be converted to Integer
              stack.add("3");
                        ^
      Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
      1 error
      ```
      ***선언한 자료형과 다른 값을 넣으면 에러가 발생***
    </details>

### 삽입
- Object **`push(Object item)`**  
  > **Stack**에 객체(`item`)를 저장  
  > 삽입한 객체(`item`)의 값을 반환

  ```java
  Stack<Integer> stack = new Stack<>();

  System.out.println("stack.push(10) = " + stack.push(10));
  System.out.println("stack = " + stack);
  ```
  <details>
    <summary>Output</summary>
  
    ```
    stack.push(10) = 10
    stack = [10]
    ```
  </details>

- boolean **`add(Object item)`**  
  > **Stack**에 객체(`item`)를 저장
  > 삽입 **성공**시, `ture` 반환
  > 삽입 **실패**시, `false` 반환

  ```java
  Stack<Integer> stack = new Stack<>();

  System.out.println("stack.add(10) = " + stack.add(10));
  System.out.println("stack = " + stack);

  System.out.println("stack.add(10) = " + stack.add(10));
  System.out.println("stack = " + stack);
  ```
  <details>
    <summary>Output</summary>

    ```
    stack.add(10) = true
    stack = [10]
    stack.add(10) = true
    stack = [10, 10]
    ```
  </details>

<br>

### 삭제
- Object **`pop()`**  
  > **Stack**의 맨 위에 저장된 객체 삭제 및 반환  
  ※ **Stack**이 비었을 때는 **EmptyStackException** 발생  

- **비어있지 않은 Stack에 원소의 개수보다 많이 `pop()`메서드를 실행하고 반환값을 확인해 보자.**
  ```java
  Stack<Integer> stack = new Stack<>();

  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("stack.pop() = " + stack.pop());
  System.out.println("stack.pop() = " + stack.pop());
  System.out.println("stack.pop() = " + stack.pop());
  System.out.println("stack.pop() = " + stack.pop());
  ```
  <details>
    <summary>Output</summary>
  
    ```
    stack.pop() = 5
    stack.pop() = 0
    stack.pop() = 10
    
    Exception in thread "main" java.util.EmptyStackException
    	at java.base/java.util.Stack.peek(Stack.java:103)
    	at java.base/java.util.Stack.pop(Stack.java:85)
    	at stackExample.main(stackExample.java:14)
    ```
    ***맨 뒤에 넣은 값(가장 최근 값)이 먼저 삭제 됨.  
    빈 Stack에 `pop()`메서드를 실행하면 EmptyStackException 발생***  
  </details>
<br>

- Object **`remove(int index)`**  
  > **Stack**의 맨 위에 저장된 객체 삭제 및 반환  
  ※ 옳지 않은 index 입력 시, **ArrayIndexOutOfBoundsException** 발생
  *(index는 삽입된 순서대로 0 ~ stack.size()-1의 범위 안의 값)

  ```java
    Stack<Integer> stack = new Stack<>();

  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("stack = " + stack);
  System.out.println("stack.remove(0) = " + stack.remove(0));
  System.out.println("stack = " + stack);
  ```
  <details>
    <summary>Output</summary>

    ```
    stack = [10, 0, 5]
    stack.remove(0) = 10
    stack = [0, 5]
    ```
  </details>


  - **옳지 않은 인덱스를 넣으면 어떻게 될까?**
    - stack 크기보다 큰 인덱스를 넣을 때
      ```java
      Stack<Integer> stack = new Stack<>();
  
      stack.push(10);
      stack.push(0);
      stack.push(5);
      
      System.out.println("stack = " + stack);
      System.out.println("stack.remove(5) = " + stack.remove(5));
      System.out.println("stack = " + stack);
      ```
      <details>
        <summary>Output</summary>
  
        ```
        stack = [10, 0, 5]
        
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
        	at java.base/java.util.Vector.remove(Vector.java:844)
        	at stackExample.main(stackExample.java:12)
        ```
        ***ArrayIndexOutOfBoundsException 발생***  
    </details>

    - 음수 인덱스를 넣을 때
      ```java
      Stack<Integer> stack = new Stack<>();
  
      stack.push(10);
      stack.push(0);
      stack.push(5);
      
      System.out.println("stack = " + stack);
      System.out.println("stack.remove(-1) = " + stack.remove(-1));
      System.out.println("stack = " + stack);
      ```
      <details>
        <summary>Output</summary>
  
        ```
        stack = [10, 0, 5]
  
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 10
        at java.base/java.util.Vector.elementData(Vector.java:731)
        	at java.base/java.util.Vector.remove(Vector.java:845)
        	at stackExample.main(stackExample.java:12)
        ```
        ***ArrayIndexOutOfBoundsException 발생***  
        *Stack의 크기를 넘어가는 인덱스는 양수든 음수든 Exception 발생*  
      </details>
    
<br>

### Top에 있는 원소 읽기
- Object **`peek()`**  
  > **Stack**의 맨 위(Top)에 저장된 객체를 반환  
  - `pop()`과 달리 **Stack**에서 객체를 꺼내지 않음  
  ※ 비었을 때는 **EmptyStackException** 발생

  ```java
  Stack<Integer> stack = new Stack<>();
  
  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("stack = " + stack);
  System.out.println("stack.peek() = " + stack.peek());
  System.out.println("stack = " + stack);
  ```
  <details>
    <summary>Output</summary>
  
    ```
    stack = [10, 0, 5]
    stack.peek() = 5
    stack = [10, 0, 5]
    ```
  </details>

<br>

### 크기
- int **`size()`**  
  > 현재 Stack에 저장된 객체의 개수를 반환

  ```java
  Stack<Integer> stack = new Stack<>();
  
  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("stack.size() = " + stack.size());
  
  stack.clear();
  System.out.println("Stack초기화 후, stack.size() = " + stack.size());
  ```
  <details>
    <summary>Output</summary>
  
    ```
    stack.size() = 3
    Stack초기화 후, stack.size() = 0
    ```
  </details>


<br>

### Stack 비어있는지(공백 상태) 여부
> **Stack**이 비어있는지 알려줌
> Stack이 비어있으면, `true` 반환  
> Stack이 비어있지 않으면 `false` 반환  

- boolean **`isEmpty()`**  
  ```java
  Stack<Integer> stack = new Stack<>();
  
  System.out.println("원소 삽입 전, stack.isEmpty() = " + stack.isEmpty());
  
  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("원소 삽입 후, stack.isEmpty() = " + stack.isEmpty());
  ```
  <details>
    <summary>Output</summary>
  
    ```
    원소 삽입 전, stack.isEmpty() = true
    원소 삽입 후, stack.isEmpty() = false
    ```
  </details>
  
  
- boolean **`empty()`**  
  ```java
  Stack<Integer> stack = new Stack<>();
  
  System.out.println("원소 삽입 전, stack.empty() = " + stack.empty());
  
  stack.push(10);
  stack.push(0);
  stack.push(5);
  
  System.out.println("원소 삽입 후, stack.empty() = " + stack.empty());
  ```
  <details>
    <summary>Output</summary>
  
    ```
    원소 삽입 전, stack.empty() = true
    원소 삽입 후, stack.empty() = false
    ```
  </details>

<br>

### 검색
- int **`search(Object o)`**  
  > Stack에서 해당 객체가 top에서부터 몇 번째에 존재하는지 알려줌.  
    *(1 ~ stack.size())*
  > 존재하지 않으면 `-1` 반환
  **※ 배열과 달리 위치가 1부터 시작**
  
  ```java
  Stack<Integer> stack = new Stack<>();
  
  stack.push(10);
  
  System.out.println("stack = " + stack);
  System.out.println("stack.search(10) = " + stack.search(10));
  System.out.println("stack.search(0) = " + stack.search(0));
  ```
  <details>
    <summary>Output</summary>

    ```
    stack = [10]
    stack.search(10) = 1
    stack.search(0) = -1
    ```
  </details>

- Object **`elementAt(int index)`**  
  > 해당 index에 존재하는 객체 반환  
  > 옳지 않은 index 입력 시, **ArrayIndexOutOfBoundsException** 발생  
  *(index는 삽입된 순서대로 0 ~ stack.size()-1)*  

  ```java
  Stack<String> stack = new Stack<>();

  stack.push("10");
  stack.push("0");
  
  System.out.println("stack = " + stack);
  System.out.println("stack.elementAt(0) = " + stack.elementAt(0));
  System.out.println("stack.elementAt(10) = " + stack.elementAt(10));
  ```
  <details>
    <summary>Output</summary>

    ```
    stack = [10, 0]
    stack.elementAt(0) = 10
    
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10 >= 2
    	at java.base/java.util.Vector.elementAt(Vector.java:466)
    	at stackExample.main(stackExample.java:12)
    ```
    ***알맞은 index를 매개변수로 줬을 때는 해당 index의 객체가 반환
    하지만 옳지 않은 index를 매개변수로 줬을 때는 ArrayIndexOutOfBoundsException 발생***
  </details>
  

### 수정
- Object **`set(int index, Object o)`**  
  > 변경 전 객체 값 반환  
  > 옳지 않은 index 입력 시, **ArraysIndexOutOfBoundsException** 발생  
    *(index는 삽입된 순서대로 0 ~ stack.size() -1 범위 안의 값)*
  ```java
  Stack<Integer> stack = new Stack<>();
  
  stack.push(10);
  stack.push(0);
  
  System.out.println("stack = " + stack);
  System.out.println("stack.set(0, -1) = " + stack.set(0, -1));
  System.out.println("stack = " + stack);
  ```
  <details>
    <summary>Output</summary>

    ```
    stack = [10, 0]
    stack.set(0, -1) = 10
    stack = [-1, 0]
    ```
  </details>

  - **`set()`메서드에 Stack의 인덱스 범위 밖의 값을 넣으면 어떻게 될까?**
    ```java
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    stack.push(0);
    
    System.out.println("stack = " + stack);
    System.out.println("stack.set(-1, -1) = " + stack.set(-1, -1));
    System.out.println("stack = " + stack);
    ```
    <details>
      <summary>Output</summary>

      ```
      stack = [10, 0]

      Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 10
      	at java.base/java.util.Vector.elementData(Vector.java:731)
      	at java.base/java.util.Vector.set(Vector.java:770)
      	at stackExample.main(stackExample.java:11)
      ```
      ***ArrayIndexOutOfBoundsException 발생***
    </details>

### 초기화
> Stack을 비움. *(공백 Stack으로 만듦)*

- void **`clear()`**  

  ```java
  Stack<String> stack = new Stack<>();

  stack.push("10");
  stack.push("0");
  stack.push("5");
  
  System.out.println("stack = " + stack);
  stack.clear();
  System.out.println("Stack 초기화 후, stack = " + stack);
  ```
  <details>
    <summary>Output</summary>

    ```
    stack = [10, 0, 5]
    Stack 초기화 후, stack = []
    ```
  </details>

<br>

## Stack, Queue, Deque 메서드 비교

| **Stack** | **Queue** |  **Deque**  |
|:---------:|:---------:|:-----------:|
|   push()  |  offer()  | OfferLast() |
|   pop()   |           |  pollLast() |
|           |   poll()  | pollFirst() |
|           |   peek()  | peekFirst() |
|   peek()  |           |  peekLast() |
