# Static(정적)
> 사전적 의미: 고정된

> Static변수(→ 정적필드)와 Static메소드(→ 정적 메소드)를 만들 수 있음  
>> (둘이 합쳐 ⇒ 정적 멤버 = 클래스 멤버)

> 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버  
>> 클래스 로더가 클래스를 로딩해서 메소드 메모리 영역에 적재할 때, 클래스 별로 관리 됨.  
>> ∴ 클래스의 로딩이 끝나는 즉시 바로 사용 가능

## Static
-  주로 클래스들이 할당  
-  Garbage Collector 관여x  
  > Static 영역의 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재  
    ∴ Static 남발 시, 만들고자 하는 시스템 성능에 악영향을 줄 수 있음.  
    
-  모든 객체가 메모리를 공유
  > 하나의 멤버를 어디서든지 참조할 수 있음  
-  Static 키워드를 통해 생성된 정적 멤버들을 Static 영역에 할당 됨.(Heap영역x)  

## Heap
- 주로 객체들이 할당  
- Garbage Collector 관여 O  
- 메모리를 공유하지 않음  
  
## 정적(Static) 멤버 선언
> 필드나 메소드를 생성 시, **인스턴스** 또는 **정적**으로 생성의 판단 기준: 공용으로 사용 여부  
> 그냥 생성하면, **인스턴스**로 생성
> 필드와 메서드 선언 시, `Static` 키워드를 붙이면 **정적**으로 생성

```java
static int num = 0; //타입 필드 = 초기값
public static void static_method(){} //static 리턴 타입 메소드 {}
```

## 정적 필드 사용
```java
class Number{
    static int num = 0; //클래스 필드
    int num2 = 0; //인스턴스 필드
}

public class Static_ex {
	
    public static void main(String[] args) {
    	Number number1 = new Number();
    	Number number2 = new Number();
    	
    	number1.num += 10;
    	number1.num2++;
    	
    	System.out.println("Number number1의 정적 필드 num :" + number1.num);
    	System.out.println("Number number1의 인스턴스 필드 num2 :" + number1.num2);
    	System.out.println("Number number2의 정적 필드 num :" + number2.num);
    	System.out.println("Number number3의 인스턴스 필드 num2 :" + number2.num2);
    }
}
```
<details>
  <summary>Output</summary>

  ```
  Number number1의 정적 필드 num :10
  Number number1의 인스턴스 필드 num2 :1
  Number number2의 정적 필드 num :10
  Number number3의 인스턴스 필드 num2 :0
  ```
***인스턴스 변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각기 다른 값을 갖지만   
정적변수는 모든 인스턴스가 하나의 저장공간을 공유하기 때문에 항상 같은 값을 가진다.***
*number1 객체의 num에만 +10을 했는데 number2의 num도 10으로 출력되는 것을 확인할 수 있다.*
</details>
<br>

## 정적 메서드 사용 예시
> 정적 메소드는 클래스가 메모리에 올라갈 때 자동적으로 생성됨.  
> ∴ 정적 메소드는 인스턴스를 생성하지 않아도 호출 가능  
- 유틸리티 함수를 만드는데 유용하게 사용됨.  
```java
class Name{
    static void print() { //클래스 메소드
	System.out.println("I'm Super Junior!");
    }

    void print2() { //인스턴스 메소드
	System.out.println("오늘은 Static을 공부합니다.");
    }
}

public class Static_ex {
	
    public static void main(String[] args) {
        Name.print(); //인스턴스를 생성하지 않아도 호출이 가능
    	
        Name name = new Name(); //인스턴스 생성
        name.print2(); //인스턴스를 생성하여야만 호출이 가능
    }
}
```

<details>
  <summary>Output</summary>

  ```
  I'm Super Junior!
  오늘은 Static을 공부합니다.
  ```
  ***Static 메서드는 객체를 생성하지 않아도 `클래스.Static메서드()`로 호출 가능  
  인스턴스 메서드는 객체를 생성해야한 호출 가능***
</details>

---

##### References(참고 자료)
[[Java] 자바 static의 의미와 사용법](https://coding-factory.tistory.com/524)
