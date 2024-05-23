# Queue(큐)
  > 최근 사용 문서, 인쇄 작업 대기 목록, 버퍼(buffer) 등의 기능을 구현할 때 활용
- 선입선출(**FIFO**; First In First Out)구조 : 먼저 들어간 데이터를 먼저 꺼내는 구조
<br>

## Queue의 구현체
> Queue는 Queue인터페이스만 있고 별도의 클래스가 없다.  
> Queue인터페이스를 구현한 클래스들을 사용해야 한다.  

- **LinkedList**  
- **PriorityQueue**  
  > 저장한 순서에 관계없이 우선순위(priority)가 높은 것부터 꺼내게 됨.  

  - `null`을 저장하면 **NullPointerException** 발생  
  - 저장공간으로 배열을 사용  
  - 각 요소를 힙(heap)이라는 자료구조의 형태로 저장  
    *(← 저장된 순서와 실제 우선순위가 다른 이유)*  
    *※ 자료구조의 heap과 JVM의 heap은 이름만 같고 다른 것들이다.*  
  - 우선순위는 숫자가 작을수록 높다.  
  - 숫자가 아닌 객체를 저장하려면 각 객체의 크기를 비교할 수 있는 방법을 제공해야 한다.  

  ```java
  import java.util.PriorityQueue;
  import java.util.Queue;
  
  public class priorityQueueExample {
    public static void main(String args[]) {
    
    Queue pq = new PriorityQueue();
    
    pq.offer(3);
    pq.offer(1);
    pq.offer(10);
    pq.offer(4);
    pq.offer(0);
    System.out.println(pq);
    
    Object obj = null;
    
    //PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
    while((obj = pq.poll()) != null) {
        System.out.println(obj);
    }}
  }
  ```
  <details>
    <summary>Output</summary>

    ```
    [0, 1, 10, 4, 3]
    0
    1
    3
    4
    10
    ```
    ***저장 순서가 [0, 1, 10, 4, 3]인데도 출력 결과가 0, 1, 3, 4, 10인 것을 확인할 수 있다.***
   
  </details>

### Queue의 변형
- **Deque**(Double-Ended Queue)
  > 양쪽 끝에서 추가/삭제가 가능  
  > Deque의 조상은 Queue
  
  - 구현체 : ArrayDequeue, LinkedList
  - Stack과 Queue를 하나로 합쳐놓은 것과 같아서 **Stack**으로 사용할 수도 있고, **Queue**로 사용할 수도 있다.

![Queue와 Deque](https://github.com/MinjuKang727/Java/assets/108849480/edc1550e-99eb-421d-bfa7-b8d4a7bfea2c)

  
## import
```java
import java.util.Queue;
import java.util.LinkedList;
```
<br>

## 선언

- **방법1**
```java
Queue 변수명 = new LinkedList();
```
> 어떤 자료형이든 삽입, 삭제 가능  

  - **Queue에 Integer값과 String값을 모두 넣을 수 있을까?**
    ```java
    Queue q = new LinkedList();
            
    System.out.println(q.add(0));
    System.out.println(q.add("0"));
    ```
    <details>
      <summary>Output</summary>
    
      ```
      true
      true
      ```
      ***이전에 int형을 넣었어도 String형 삽입 가능***
    </details>

<br>

- **방법2**
```java
Queue<자료형>변수명 = new LinkedList<>();
```
> 자료형에 넣은 자료형만 삽입, 삭제 가능

  - **Queue\<Integer\>로 생성한 Queue에 Integer값과 String 값을 넣을 수 있을까?**
    ```java
    Queue<Integer> q = new LinkedList<>();
            
    System.out.println(q.add(0));
    System.out.println(q.add("0"));
    ```
    
    <details>
      <summary>Output</summary>
    
      ```
      queueExample.java:10: error: incompatible types: String cannot be converted to Integer
          System.out.println(q.add("0"));
                                   ^
      Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
      1 error
      ```
      ***Integer타입으로 생성한 Queue에 String타입을 넣으려고 하면 에러 발생***
      
    </details>

  - **Queue<Integer>로 생성한 Queue에 Integer값만 넣으면 코드 실행이 잘 될까?**
    ```java
    Queue<Integer> q = new LinkedList<>();
            
    System.out.println(q.add(0));
    ```
    
    <details>
      <summary>Output</summary>
    
      ```
      true
      ```
      ***생성한 자료형만 추가할 때는 에러 없이 코드가 잘 실행된다.***
    </details>
    
    <br>

## 삽입
- boolean **`add(Object o)`**
  > **Queue**에 객체를 저장   
  - **성공**하면 `true`를 반환, 저장 공간이 부족하면 **IllegalStateException** 발생
    
  <br>
  
  - **Queue\<Integer\>로 생성한 Queue에 `add()`메서드로 Integer값을 넣어보자**
    ```java
    Queue<Integer> q = new LinkedList<>();
        
    System.out.println("큐에 값 삽입 성공 : " + q.add(0));
    ```
    
    <details>
      <summary>Output</summary>
    
      ```
      큐에 값 삽입 성공 : true
      ```
    </details>
    
  - **Queue\<Integer\>로 생성한 Queue에 String값을 넣어보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
        
    System.out.println("큐에 값 삽입 성공 : " + q.add("0"));
    ```
    
    <details>
      <summary>Output</summary>
    
      ```
      queueExample.java:9: error: incompatible types: String cannot be converted to Integer
        System.out.println("큐에 값 삽입 성공 : " + q.add("0"));
                                                   ^
      Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
      1 error
      ```
      ***에러가 발생하는 것을 알 수 있다.***
    </details>
    
<br>

- boolean **`offer(Object o)`**  
  > **Queue**에 객체를 저장  
  - **성공**하면 `true`, **실패**하면 `false`를 반환

  <br>

  - **Queue\<Integer\>로 생성한 Queue에 `add()`메서드와 `offer()`메서드로 Integer값을 넣으면 뭐가다를까?**
    ```java
    Queue<Integer> q = new LinkedList<>();
            
    System.out.println(q.add(0));
    System.out.println(q.offer(0));
    ```
    <details>
      <summary>Output</summary>
    
      ```
      true
      true
      ```
      ***`add()`메서드와 `offer()`메서드 모두 차이 없이 `true`를 반환***
    </details>
    
  - **Queue\<Integer\>로 생성한 Queue에 `add()`메서드와 `offer()`메서드로 String값을 넣으면 뭐가다를까?**
    ```java
    Queue<Integer> q = new LinkedList<>();
            
    System.out.println(q.add("0"));
    System.out.println(q.offer("0"));
    ```
    <details>
      <summary>Output</summary>
    
      ```
      queueExample.java:9: error: incompatible types: String cannot be converted to Integer
        System.out.println(q.add("0"));
                               ^
      queueExample.java:10: error: incompatible types: String cannot be converted to Integer
        System.out.println(q.offer("0"));
                                 ^
      Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
      2 errors
      ```
      ***`add()`메서드와 `offer()`메서드 모두 차이 없이 에러 발생***  
    *`offer()`메서드에서는 `false`를 반환할 줄 알았는데 아니었다.  
    자료형으로 인한 삽입 실패를 말하는 것이 아니었나보다.  
    저장공간 부족으로 인한 삽입 실패에서만 `false`를 반환하는 건가?  
    그것을 확인할 수 있는 코드는 어떻게 써야할까?*  
    </details>

<br>

## 삭제
- Object **`remove()`**  
  > **Queue**에서 삭제한 값 반환  
  ※ **Queue**가 비어있으면 **NoSuchElementException** 발생

  - **비어있지 않은 Queue에서 `remove()`메서드로 값을 삭제하고 반환되는 값을 출력해 보자**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(0);
    q.add(10);
    
    System.out.println(q.remove());
    System.out.println(q.remove());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      0
      10
      ```
      ***삭제된 값이 출력된다.****(삭제된 값을 반환하는 것을 확인)*  
      ***이를 통해 먼저 삽입한 값이 먼저 삭제되는 것을 확인할 수 있다.***   
    </details>

  - **비어있는 Queue에서 `remove()`메서드로 값을 삭제하고 반환되는 값을 출력해 보자**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    System.out.println(q.remove());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      Exception in thread "main" java.util.NoSuchElementException
    	at java.base/java.util.LinkedList.removeFirst(LinkedList.java:281)
    	at java.base/java.util.LinkedList.remove(LinkedList.java:696)
    	at queueExample.main(queueExample.java:10)
      ```
      ***NoSuchElementException 발생***  
      *에러랑 Exception은 서로 뜨는 모양이 다르구나❕*   
    </details>

<br>

- Object **`remove(Object o)`**  
  > 삭제 결과를 `boolean`타입으로 반환  
  > 삭제 **성공**시, `true` 반환, 삭제 **실패**시, `false` 반환

  - **Queue에 들어있는 값과 들어있지 않는 값을 `remove(Object o)`로 삭제해 보고 그 반환 값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    
    System.out.println("Queue에 들어있는 10 삭제 : " + q.remove(10));
    System.out.println("Queue에 들어있지 않은 0 삭제 : " + q.remove(0));
    ```
    <details>
      <summary>Output</summary>
    
      ```
      Queue에 들어있는 10 삭제 : true
      Queue에 들어있지 않은 0 삭제 : false
      ```
      ***Queue에 들어있는 값은 `true`를 반환, 들어있지 않은 값은 `false`를 반환***   
    </details>

<br>

- Object **`poll()`**  
  > **Queue**에서 삭제한 값 반환  
  - 비어있으면 **null**을 반환

  - **Queue에 여러 값을 삽입 후, `poll()`로 값들을 삭제하면서 반환하는 값들을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(0);
    q.add(32);
    
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      10
      0
      32
      null
      ```
      ***먼저 들어간 값이 먼저 삭제 됨.  
     Queue가 비어있을 때, 삭제를 하면 null을 반환***   
    </details>

<br>

## Front에 있는 원소 읽기
- Object **`element()`**
  > Queue의 맨 앞(front)에 위치한 값(Value) 반환  
  > **삭제 없이** 요소를 읽어 옴.  
  ※ **Queue**가 비어있을 때 **NoSuchElementException** 발생  

  - **비어있지 않은 Queue에 `element()`메서드의 반환값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(0);
    q.add(32);
    
    System.out.println(q.element());
    System.out.println(q.element());
    System.out.println(q.element());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      10
      10
      10
      ```
      ***값이 삭제되지 않고 제일 먼저 넣은 값(head의 값)이 계속 출력되어 나온다.***
    </details>

  - **비어있는 Queue에 `element()`메서드의 반환값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    System.out.println(q.element());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.LinkedList.getFirst(LinkedList.java:255)
        at java.base/java.util.LinkedList.element(LinkedList.java:674)
        at queueExample.main(queueExample.java:9)
      ```
      ***NoSuchElementException 발생***
    </details>

<br>

- Object **`peek()`**  
  > 삭제 없이 요소를 읽어 옴.  
  - **Queue**가 비어있으면 `null`을 반환

  - **비어있지 않은 Queue에 `peek()`메서드의 반환값을 출력해보고, `element()`메서드의 반환값과 비교해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(0);
    q.add(32);
    
    System.out.println("q.peek() = " + q.peek());
    System.out.println("q.peek() = " + q.peek());
    System.out.println("q.element() = " + q.element());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      q.peek() = 10
      q.peek() = 10
      q.element() = 10
      ```
  
      ***`peek()`메서드도 `element()`메서드와 반환값에 차이가 없이  
      값이 삭제되지 않고 제일 먼저 넣은 값(head의 값)이 출력되어 나온다.***  
  
    </details>

  - **비어있는 Queue에 `peek()`메서드의 반환값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    System.out.println(q.peek());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      null
      ```
      ***`element()`메서드와 달리 `null`을 반환***
    </details>
    
## 초기화
> 공백 Queue 만들기

- void **`clear()`**
  > 반환값 없음

  - **비어있지 않은 Queue에 `clear()`메서드의 반환값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
      
    q.add(10);
    q.add(0);
    q.add(32);
    
    System.out.println(q.clear());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      queueExample.java:13: error: 'void' type not allowed here
          System.out.println(q.clear());
                                    ^
      1 error
      ```
      *void 타입은 출력이 안되는구나❕*
    </details>

    <br>
    
  - **비어있지 않은 Queue에 `clear()`메서드를 사용 후, `peek()`메서드의 반환값을 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
      
    q.add(10);
    q.add(0);
    q.add(32);
    
    q.clear();
    System.out.println(q.peek());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      null
      ```
      ***Queue가 초기화되어 null이 반환***
    </details>

## 크기
- int **`size()`**  
  > 현재 Queue에 저장된 객체의 개수를 반환  
  
  - **비어있지 않은 Queue의 크기를 알기 위해 `size()`메서드를 사용해보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(0);
    q.add(32);
    
    System.out.println(q.size());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      3
      ```
    </details>
  - **비어있지 않은 Queue를 `clear()`메서드로 초기화 후, `size()`메서드를 사용해보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(0);
    q.add(32);

    q.clear();
    System.out.println(q.size());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      0
      ```
      ***초기화 된 Queue의 크기는 0***
    </details>
  <br>

## 존재 여부 확인
- boolean **`contains(Object o)`**
  > 찾는 객체가 존재하면 `true` 반환
  > 찾는 객체가 없으면 `false` 반환
  
  - **Queue에 원소를 추가하고 `contains()`메서드를 사용하여 해당 원소의 존재 여부를 출력해 보고, `remove()`메서드로 해당 원소를 삭제 후, 다시 `contains()`메서드를 사용하여 해당 원소의 존재 여부를 출력해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);

    System.out.println("q.contains(10) = " + q.contains(10));
    System.out.println("(10 삭제) q.remove(10) = " + q.remove(10));
    System.out.println("q.contains(10) = " + q.contains(10));
    ```
    <details>
      <summary>Output</summary>
    
      ```
      q.contains(10) = true
      (10 삭제) q.remove(10) = true
      q.contains(10) = false
      ```
    </details>

    <br>

## 공백 Queue 여부 확인
- boolean **`isEmpty()`**
  > 공백 Queue이면, `true` 반환
  > 공백 Queue 아니면, `false` 반환

  - **비어있지 않은 Queue에서 `isEmpty()`메서드의 반환값을 출력해 보고, Queue를 초기화 후, `isEmpty()`메서드로 출력된 반환값과 비교해 보자.**
    ```java
    Queue<Integer> q = new LinkedList<>();
    
    q.add(10);
    q.add(1);
    q.add(-20);

    System.out.println("q.isEmpty() = " + q.isEmpty());
    q.clear();
    System.out.println("Queue 초기화 후, q.isEmpty() = " + q.isEmpty());
    ```
    <details>
      <summary>Output</summary>
    
      ```
      q.isEmpty() = false
      Queue 초기화 후, q.isEmpty() = true
      ```
    </details>

    <br>

### Queue 메서드 정리
|         | **Throws exception** | **Returns special value** |
|---------|----------------------|---------------------------|
| Insert  | add(e)               | offer(e)                  |
| Remove  | remove()             | poll()                    |
| Examine | element()            | peek()                    |

---
##### References(참고 자료)
[[JAVA / 자바] Queue(큐) 클래스 사용법 및 함수(Method) 정리](https://kwin0825.tistory.com/157)  
[[Java] 스택(Stack)과 큐(Queue)](https://pridiot.tistory.com/68)  
[[Java] Queue offer vs add](https://iamkdh.tistory.com/96)  
