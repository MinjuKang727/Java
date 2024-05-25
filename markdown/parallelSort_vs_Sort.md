# Arrays.ParallelSort() vs Arrays.Sort() 

```java
import java.util.Arrays;

public class MyClass {
    public static void main(String args[]) {
        int[] intArr1 = {1, 3, -1, 1023, 0};
        
        System.out.println("intArr1 = " + Arrays.toString(intArr1));
        Arrays.sort(intArr1);
        System.out.println("sort() 정렬 후, intArr1 = " + Arrays.toString(intArr1));
        
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
  intArr1 = [1, 3, -1, 1023, 0]  
  sort() 정렬 후, intArr1 = [-1, 0, 1, 3, 1023]  
  intArr2 = [1, 3, -1, 1023, 0]  
  parallelSort() 정렬 후, intArr2 = [-1, 0, 1, 3, 1023]  
  ```
  ***`sort()`메서드와 `paralleleSort()`메서드의 정렬 결과는 다르지 않음.***
</details>

<br>

- **`parallelSort()`**
  - Fork-Join이라는 프레임워크가 내부적으로 적용된 형태의 메소드
 

#### Fork-Join이란?
>> Fork : 작업을 여러개로 나누어 처리한다. / Join : 합친다.

> Java7에서 새로 추가된 기능  
CPU를 더 쉽고 효율적으로 사용하기 위해 만들어진 기능  
**Work Stealing**이라는 개념이 포함되어 있음  

##### Work Stealing
> 여러개의 Dequeue에 작업이 나뉘어져 어떤 일을 진행할 때,  
하나의 Dequeue는 매우 바쁘고, 다른 Dequeue는 매우 한가할 때가 있다.  
이 때, 한가한 Dequeue가 바쁜 Dequeue의 대기하고 있는 일을 대신 가져가서 처리해 주는 것

<br>

| **`sort()`** | **`parallelSort()`** |
|:------------:|:--------------------:|
|  단일 쓰레드 |      멀티 쓰레드     |

<br>

`parallelSort()`메서드는 필요에 따라 여러 개의 쓰레드로 나뉘어 작업이 수행되기 때문에 **정렬되는 속도가 빠름.**  
멀티 쓰레드는 그만큼 **CPU를 더 많이 사용**  
약 5000개 정도부터 `parallelSort()`의 성능이 더 빨라짐.  
**즉, 데이터 개수가 많지 않은 배열에서는 그냥 `sort()`를 사용하자!**  

<br>

---

##### References(참고 자료)
[Arrays.ParallelSort() 와 Arrays.Sort()의 차이점은 무엇일까?](https://1-7171771.tistory.com/118)

