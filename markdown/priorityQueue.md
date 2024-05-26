# PriorityQueue(우선순위 큐)
> 선입선출 구조인 Queue와 달리
> Queue에 들어있는 자료 중 우선순위를 설정하여 **우선순위가 높은 순서대로 데이터를 꺼내는 구조**
> 우선순위가 Queue가 정렬된 순서와 같을 경우는 선입선출 방식을 따름
> Heap(힙) 방식으로 구현

## 우선 순위 지정
> 생성할 때, 우선순위를 지정해 주어야 함.
> 자바에서 지원하는 기본 타입들에 대해 기본정렬방법(오름차순)을 따른다.
> 임의의 클래스로 구성된 PriorityQueue 또는 기본 타입의 경우이지만 우선순위 선정하는 방법을 변경하려는 경우에는 우선순위를 따로 지정해 주어야 한다.

## import 
```java
import java.util.PriorityQueue;
```
<br>

## 생성

- **기본 타입**에 대한 PrioriryQueue 생성하기
```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
```
> 매개변수에 아무것도 넣지 않으면 기본 정렬 방법(오름차순)을 따른다.

  - **클래스**에 대한 PirorityQueue를 생성하면 어떻게 될까?
  ```java
  PriorityQueue<Mymember> queue = new PriorityQueue<>();
  ```
  <details>
    <summary>Output</summary>

    ```
    MyClass.java:5: error: cannot find symbol
        PriorityQueue<MyMember> queue = new PriorityQueue<>();
                      ^
      symbol:   class MyMember
      location: class MyClass
    1 error
    ```
  </details>
<br>

## Comparable 구현
> 임의의 클래스로 구성된 PrioriryQueue의 경우에 해당 클래스에 Comparable Interface를 상속받아서  compareTo메서드를 구현해주면 우선순위를 지정해줄 수 있다.
>
> 

---

##### References(참고 자료)
[[JAVA/자료구조] 우선순위 큐(Priority Queue) (Heap)](https://innovation123.tistory.com/112)  
