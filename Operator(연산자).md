# Java Operator(자바 연산자)

## What is Operator?(연산자란?)
- **Operation**(연산) : 프로그램에서 데이터를 처리하여 결과를 산출하는 것
- **Operator**(연산자) : 연산에 사용되는 표시나 기호
- **Operand**(피연산자) : 연산되는 데이터

## 연산자의 종류
- **증감 연산자** : `++`, `--` *(1순위)*
- **산술 연산자** : `+`, `-`, `*`, `/`, `%` *(2순위)*
- **시프트 연산자** : `>>`, `<<`, `>>>` *(3순위)*
- **비교 연산자** : `>`, `<`, `>=`, `<=`, `==`, `!=` *(4순위)*
- **비트 연산자** : `&`, `|`, `^`, `~` *(~만 1순위, 나머지는 5순위)*
- **논리 연산자** : `&&`, `||`, `!` *(!만 1순위, 나머지는 6순위)*
- **조건(삼항) 연산자** : `?`, `:` *(7순위)*
- **대입 연산자** : `=`, `*=`, `/=`, `%=`, `+=`, `-=` *(8순위)*

## Increment and Decrement Operators(증감 연산자)
> 피연산자의 값을 1씩 증가 또는 감소시키는 연산자  
> `x++`, `++x`, `x--`, `--x`  
##### ※ 증감 연산자가 변수 앞에 위치하느냐 변수 뒤에 위치하느냐에 따라 결과 값이 달라진다.

- **후행(후위) 증가 연산자** (x++)
  > 먼저 해당 연산을 수행한 후 피연산자의 값을 1 증가 시킴.  

    ```java
    // 후행(후위) 증가 연산자
    int x = 10;
    int y = x++;
    // y = x;
    // x = x + 1;
    
    System.out.println("== 후행(후위) 증가 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    ```
    <details>
        <summary>Output(출력)</summary>
      
        == 후행(후위) 증가 연산자 ==
        x = 11
        y = 10
    </details>
    <br>

- **선행(전위) 증가 연산자** (++x)
  > 먼저 피연산자의 값을 1 증가 시킨 후 해당 연산을 수행 함.  
    
    ```java
    // 선행(전위) 증가 연산자
    int x = 10;
    int y = ++x;
    // x = x + 1;
    // y = x;
    
    System.out.println("== 선행(전위) 증가 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    ```
    <details>
        <summary>Output(출력)</summary>
        == 선행(전위) 증가 연산자 ==
        x = 11
        y = 11
    </details>
    <br>

- **후행(후위) 감소 연산자** (x--)
  > 먼저 해당 연산을 수행한 후 피연산자의 값을 1 감소 시킴.  

    ```java
    // 후행(후위) 감소 연산자
    int x = 10;
    int y = x--;
    // y = x;
    // x = x - 1;
    
    System.out.println("== 후행(후위) 감소 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 후행(후위) 감소 연산자 ==
        x = 9
        y = 10
    </details>
    <br>

- **선행(전위) 감소 연산자** (--x)
  > 먼저 피연산자의 값을 1 감소 시킨 후 해당 연산을 수행 함.  

    ```java
    // 선행(전위) 감소 연산자
    int x = 10;
    int y = --x;
    // x = x - 1;
    // y = x;
    
    System.out.println("== 선행(전위) 감소 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 선행(전위) 감소 연산자 ==
        x = 9
        y = 9
    </details>
    <br>

## Arithmetic Operator(산술 연산자)
> 4칙 연산(`+`, `-`, `*`, `/`), 나머지 연산자(`%`)  

- **덧셈 연산자** (+)
  > 두 수에 대한 덧셈  

    ```java
    int x = 10;
    System.out.println("== 덧셈 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("x + 3 = " + (x + 3));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 덧셈 연산자 ==
        x = 10
        x + 3 = 13
    </details>
    <br>

- **뺄셈 연산자** (-)
  > 두 수에 대한 뺄셈  

    ```java
    int x = 10;
    System.out.println("== 뺄셈 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("x - 3 = " + (x - 3));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 뺄셈 연산자 ==
        x = 10
        x - 3 = 7
    </details>
    <br>

- **곱셈 연산자** (*)
  > 두 수에 대한 곱셈  

    ```java
    int x = 10;
    System.out.println("== 곱셈 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("x * 3 = " + (x * 3));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 곱셈 연산자 ==
        x = 10
        x * 3 = 30
    </details>
    <br>

- **나눗셈 연산자** (/)
  > 두 수에 대한 나눗셈  

    ```java
    int x = 10;
    System.out.println("== 나눗셈 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("x / 3 = " + (x / 3));
    System.out.println("x / 2 = " + (x / 2));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 나눗셈 연산자 ==
        x = 10
        x / 3 = 3
        x / 2 = 5
    </details>
    <br>

*변수 x의 자료형이 int type이기 때문에 나눗셈 결과값도 int type으로 반환.
∴ x ÷ 3 = 3.333...에서 소숫점 아랫부분을 버림하고 x / 3 = 3*

- **나머지 연산자** (%)
  > 왼쪽 피연산자의 값을 오른쪽 피연산자의 값으로 나눈 나머지 값을 반환  
  > ( x % n )의 경우 x의 값에 관계 없이 결과값의 범위가 0 ~ n-1 이 됨.  
  >> ex) ( x % 7 ) 연산의 값의 범위는 0 ~ 6  
  
  **결과값이 회귀하게 되어서 알고리즘 구현에 자주 사용되는 연산자**

    ```java
    int x = 1234;
    System.out.println("== 나머지 연산자 ==");
    System.out.println("x = " + x);
    System.out.println("x % 7 = " + (x % 7));
    // 0 ~ 6 사이의 값을 반환
    
    System.out.println("x % 2 = " + (x % 2));
    // 0 또는 1 값을 반환
    // x값이 홀수인지 짝수인지 구분에 유용
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 나머지 연산자 ==
        x = 1234
        x % 7 = 2
        x % 2 = 0
    </details>
    <br>

## Shift Operator(시프트 연산자)
> bit단위의 연산 처리를 함.  
> 자료의 가공을 위해 오른쪽 또는 왼쪽으로 이동하여 값에 대한 변화를 일으키는 연산자  
> `<<`, `>>`, `>>>`  

- **Left Shift Operator(왼쪽 쉬프트 연산)** (<<)
  > bit 값을 왼쪽으로 이동(빈 자리는 0으로 대입)  
  > ( x << n ) = x * 2^n  
  > Integer.MAX_VALUE's bit exp는 1111111111111111111111111111111 : 총 32자리 숫자  
  > 즉, n이 32 이상이면, ( x << n ) = x * 2^(n % 32)  

    ```java
    int x = 64;
    int n = 2;
    
    System.out.println("== 왼쪽 쉬프트 연산자 ==");
    System.out.println("x << n = " + (x << n));  // 곱셈,  (x * 2^n)
    System.out.println("x << 34 = " + (x << 34));  // x * 2^(n % 32)
    System.out.println("x's bit exp: " + Integer.toBinaryString(x));
    System.out.println("x << n: " + Integer.toBinaryString(x << n));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 왼쪽 쉬프트 연산자 ==
        x << n = 256
        x << 34 = 256
        x's bit exp: 1000000
        x << n: 100000000
    </details>
    <br>

- **Right Shift Operator(오른쪽 쉬프트 연산)** (>>)
  > bit 값을 오른쪽으로 이동  
  > 이동에 따른 빈공간은 음수의 경우엔 1, 양수인 경우엔 0으로 채움  
  > ( x >> n ) = x / 2^n  
  > n이 32이상이면, ( x >> n ) = x / 2^(n % 32)  

    ```java
    int x = 64;
    int n = 2;
    
    System.out.println("== 오른쪽 쉬프트 연산자(양수 피연산자) ==");
    System.out.println("x >> n = " + (x >> n));  // 나눗셈,  (x / 2^n)
    System.out.println("x >> 34 = " + (x >> 34));  // x / 2^(n % 32)
    System.out.println("x's bit exp: " + Integer.toBinaryString(x));
    System.out.println("x >> n: " + Integer.toBinaryString(x >> n));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 오른쪽 쉬프트 연산자 ==
        x >> n = 16
        x >> 34 = 16
        x's bit exp: 1000000
        x >> n: 10000
    </details>
    <br>

    ```java
    int x = -64;
    int n = 2;
    
    System.out.println("== 오른쪽 쉬프트 연산자(음수 피연산자) ==");
    System.out.println("x >> n = " + (x >> n));  // 나눗셈,  (x / 2^n)
    System.out.println("x >> 34 = " + (x >> 34));  // x / 2^(n % 32)
    System.out.println("x's bit exp: " + Integer.toBinaryString(x));
    System.out.println("x >> n: " + Integer.toBinaryString(x >> n));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == 오른쪽 쉬프트 연산자(음수 피연산자) ==
        x >> n = -16
        x >> 34 = -16
        x's bit exp: 11111111111111111111111111000000
        x >> n: 11111111111111111111111111110000
    </details>
    <br>

- **Unsigned Shift Operator** (>>>)
  > bit 값을 오른쪽으로 이동(밀어버린 부분을 전부 0으로 챙워줌.)  
  > 음수를 보장하지 않습니다.  

    ```java
    int x = 64;
    int n = 2;
    
    System.out.println("== Unsigned 쉬프트 연산자 ==");
    System.out.println("x >>> n = " + (x >>> n));
    System.out.println("x >>> 34 = " + (x >>> 34));
    System.out.println("x's bit exp: " + Integer.toBinaryString(x));
    System.out.println("x >>> n: " + Integer.toBinaryString(x >>> n));
    ```
    <details>
        <summary>Output(출력)</summary>
    
        == Unsigned 쉬프트 연산자 ==
        x >>> n = 16
        x >>> 34 = 16
        x's bit exp: 1000000
        x >>> n: 10000
    </details>
    <br>

## Relational Operator(비교 연산자)
> 변수나 상수의 값을 비교할 때 쓰이는 연산자  
> 결과가 항상 `true` 또는 `false`인 논리값(Boolean)  
> `>`, `<`, `>=`, `<=`, `==`, `!=`  

- **크다** (>)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x > 10 = " + (x > 10));
    System.out.println("x > 12 = " + (x > 12));
    System.out.println("x > 15 = " + (x > 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
    
        x = 12
        x > 10 = true
        x > 12 = false
        x > 15 = false
    </details>
    <br>
  
- **작다** (<)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x < 10 = " + (x < 10));
    System.out.println("x < 12 = " + (x < 12));
    System.out.println("x < 15 = " + (x < 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
    
        x = 12
        x < 10 = false
        x < 12 = false
        x < 15 = true
    </details>
    <br>

- **크거나 같다** (>=)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x >= 10 = " + (x >= 10));
    System.out.println("x >= 12 = " + (x >= 12));
    System.out.println("x >= 15 = " + (x >= 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
    
        x = 12
        x >= 10 = true
        x >= 12 = true
        x >= 15 = false
    </details>
    <br>

- **작거나 같다** (<=)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x <= 10 = " + (x <= 10));
    System.out.println("x <= 12 = " + (x <= 12));
    System.out.println("x <= 15 = " + (x <= 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
    
        x = 12
        x <= 10 = false
        x <= 12 = true
        x <= 15 = true
    </details>
    <br>

- **같다** (==)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x == 10 = " + (x == 10));
    System.out.println("x == 12 = " + (x == 12));
    System.out.println("x == 15 = " + (x == 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
      
        x = 12
        x == 10 = false
        x == 12 = true
        x == 15 = false
    </details>
    <br>

- **같지 않다** (!=)

    ```java
    int x = 12;
    
    System.out.println("x = " + x);
    System.out.println("x != 10 = " + (x != 10));
    System.out.println("x != 12 = " + (x != 12));
    System.out.println("x != 15 = " + (x != 15));
    ```
    
    <details>
        <summary>Output(출력)</summary>
    
        x = 12
        x != 10 = true
        x != 12 = false
        x != 15 = true
    </details>
    <br>

## Bitwise Operator(비트 연산자)
> 비트(bit) 단위로 논리 연산을 할 때 사용하는 연산자  
> 비트 단위로 왼쪽이나 오른쪽으로 전체 비트를 이동하거나,  
> 1의 보수를 만들 때 사용  
> `&`, `|`, `^`, `~`, 쉬프트 연산자(`>>`, `<<`, `>>>`)  
*쉬프트 연산자도 비트 연산자에 포함됨*

- **비트 AND 연산** (&)  
  > 대응되는 비트가 **모두 1이면 1**을 반환  

  | 0 |   0   |   0   |   0   |   1   |   1   |   1   |   1   |
  |:-:|:-----:|:-----:|:-----:|:-----:|:-----:|:-----:|:-----:|
  | & | &amp; | &amp; | &amp; | &amp; | &amp; | &amp; | &amp; |
  | 0 |   0   |   0   |   1   |   0   |   1   |   0   |   1   |
  | ↓ |   ↓   |   ↓   |   ↓   |   ↓   |   ↓   |   ↓   |   ↓   |
  | 0 |   0   |   0   |   0   |   0   |   1   |   0   |   1   |

  ```java
  int x = 0B00001111;
  int y = 0B00010101;

  System.out.printf("%-8s","x = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x)).replace(" ", "0"));
  System.out.printf("%-8s","y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(y)).replace(" ", "0"));
  System.out.printf("%-8s","x & y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x & y)).replace(" ", "0"));
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x =     00001111
      y =     00010101
      x & y = 00000101
  </details>
<br>

- **비트 OR 연산** (|)
  > 대응되는 비트 중에서 **하나라도 1이면 1**을 반환

  |  0 |  0 |  0 |  0 |  1 |  1 |  1 |  1 |
  |:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
  | \| | \| | \| | \| | \| | \| | \| | \| |
  |  0 |  0 |  0 |  1 |  0 |  1 |  0 |  1 |
  |  ↓ |  ↓ |  ↓ |  ↓ |  ↓ |  ↓ |  ↓ |  ↓ |
  |  0 |  0 |  0 |  1 |  1 |  1 |  1 |  1 |

  ```java
  int x = 0B00001111;
  int y = 0B00010101;

  System.out.printf("%-8s","x = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x)).replace(" ", "0"));
  System.out.printf("%-8s","y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(y)).replace(" ", "0"));
  System.out.printf("%-8s","x | y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x | y)).replace(" ", "0"));
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x =     00001111
      y =     00010101
      x | y = 00011111
  </details>
<br>

- **비트 XOR 연산** (^)
  > 대응되는 비트가 **서로 다르면 1**을 반환

  | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
  |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
  | ^ | ^ | ^ | ^ | ^ | ^ | ^ | ^ |
  | 0 | 0 | 0 | 1 | 0 | 1 | 0 | 1 |
  | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ |
  | 0 | 0 | 0 | 1 | 1 | 0 | 1 | 0 |

  ```java
  int x = 0B00001111;
  int y = 0B00010101;

  System.out.printf("%-8s","x = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x)).replace(" ", "0"));
  System.out.printf("%-8s","y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(y)).replace(" ", "0"));
  System.out.printf("%-8s","x ^ y = ");
  System.out.println(String.format("%8s",Integer.toBinaryString(x ^ y)).replace(" ", "0"));
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x =     00001111
      y =     00010101
      x ^ y = 00011010
  </details>
<br>
  
- **비트 NOT 연산** (~)
  > 비트가 **1이면 0**을 반환  
  > 비트가 **0이면 1**을 반환 (1의 보수)

  | ~ | ~ | ~ | ~ | ~ | ~ | ~ | ~ |
  |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
  | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
  | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ |
  | 1 | 1 | 1 | 1 | 0 | 0 | 0 | 0 |

  | ~ | ~ | ~ | ~ | ~ | ~ | ~ | ~ |
  |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
  | 0 | 0 | 0 | 1 | 0 | 1 | 0 | 1 |
  | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ | ↓ |
  | 1 | 1 | 1 | 0 | 1 | 0 | 1 | 0 |
  
  ```java
  int x = 0B00001111;
  String not_x = Integer.toBinaryString(~x);
  not_x = not_x.substring(not_x.length()-8, not_x.length());
  
  System.out.printf("%5s %s\n", "x = ", String.format("%8s",Integer.toBinaryString(x)).replace(" ","0"));
  System.out.printf("%5s %s\n", "~x = ", not_x);
  
  int y = 0B00010101;
  String not_y = Integer.toBinaryString(~y);
  not_y = not_y.substring(not_y.length()-8, not_y.length());
  
  System.out.printf("%5s %s\n", "y = ", String.format("%8s",Integer.toBinaryString(y)).replace(" ","0"));
  System.out.printf("%5s %s\n", "~y = ", not_y);
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
       x =  00001111
      ~x =  11110000
       y =  00010101
      ~y =  11101010
  </details>
  <br>

[*시프트 연산자는 앞부분 설명 참고*](#shift-operator시프트-연산자)


## Logical Operator(논리 연산자)
> 주어진 논리식을 판단하여 `true(참)`과 `false(거짓)`을 결정하는 연산자  
> `&&`, `||`, `!`  

### 논리 연산자의 종류(1)
- **논리 AND 연산**(논리곱; &&)
  > 논리식이 모두 참이면 참을 반환  

```java
boolean result1 = true, result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 && result2 = " + (result1 && result2) + "\n");

result1 = true;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 && result2 = " + (result1 && result2) + "\n");

result1 = false;
result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 && result2 = " + (result1 && result2) + "\n");

result1 = false;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 && result2 = " + (result1 && result2));
```

<details>
    <summary>Output(출력)</summary>

    result1 = true
    result2 = true
    results1 && result2 = true
    
    result1 = true
    result2 = false
    results1 && result2 = false
    
    result1 = false
    result2 = true
    results1 && result2 = false
    
    result1 = false
    result2 = false
    results1 && result2 = false
</details>
<br>

- **논리 OR 연산**(논리합; ||)
  > 논리식 중 하나라도 참이면 참을 반환  

```java
boolean result1 = true, result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 || result2 = " + (result1 || result2) + "\n");

result1 = true;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 || result2 = " + (result1 || result2) + "\n");

result1 = false;
result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 || result2 = " + (result1 || result2) + "\n");

result1 = false;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 || result2 = " + (result1 || result2));
```

<details>
    <summary>Output(출력)</summary>

    result1 = true
    result2 = true
    results1 || result2 = true
    
    result1 = true
    result2 = false
    results1 || result2 = true
    
    result1 = false
    result2 = true
    results1 || result2 = true
    
    result1 = false
    result2 = false
    results1 || result2 = false
</details>
<br>
- **논리 NOT 연산**(부정; !)
  > 논리식의 결과가 **참**이면 **거짓**을 반환  
  > 논리식의 결과가 **거짓**이면 **참**을 반환

```java
boolean result1 = true, result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 != result2 = " + (result1 != result2) + "\n");

result1 = true;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 != result2 = " + (result1 != result2) + "\n");

result1 = false;
result2 = true;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 != result2 = " + (result1 != result2) + "\n");

result1 = false;
result2 = false;
System.out.println("result1 = " + result1);
System.out.println("result2 = " + result2);
System.out.println("results1 != result2 = " + (result1 != result2));
```

<details>
    <summary>Output(출력)</summary>

    result1 = true
    result2 = true
    results1 != result2 = false
    
    result1 = true
    result2 = false
    results1 != result2 = true
    
    result1 = false
    result2 = true
    results1 != result2 = true
    
    result1 = false
    result2 = false
    results1 != result2 = false
</details>
<br>

### 논리연산자의 종류(2)
- **논리곱** (&&)
  > 선조건이 `true`일 때만 후조건을 실행  
  > 선조건이 `false`이면 후조건을 실행하지 않는다.

  ```java
  boolean result1 = true, result2 = true;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 && result2 = " + (result1 && result2) + "\n");
  
  result1 = true;
  result2 = false;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 && result2 = " + (result1 && result2) + "\n");
  
  result1 = false;
  result2 = true;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 && result2 = " + (result1 && result2) + "\n");
  
  result1 = false;
  result2 = false;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 && result2 = " + (result1 && result2));
  ```

  <details>
      <summary>Output(출력)</summary>
  
      result1 = true
      result2 = true
      results1 && result2 = true
      
      result1 = true
      result2 = false
      results1 && result2 = false
      
      result1 = false
      result2 = true
      results1 && result2 = false
      
      result1 = false
      result2 = false
      results1 && result2 = false
  </details>
  <br>

- **||**
  > 선조건이 `true`이면 후조건을 실행하지 않으며  
  > 선조건이 `false`일 때만 후조건을 실행한다.

  ```java
  boolean result1 = true, result2 = true;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 || result2 = " + (result1 || result2) + "\n");
  
  result1 = true;
  result2 = false;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 || result2 = " + (result1 || result2) + "\n");
  
  result1 = false;
  result2 = true;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 || result2 = " + (result1 || result2) + "\n");
  
  result1 = false;
  result2 = false;
  System.out.println("result1 = " + result1);
  System.out.println("result2 = " + result2);
  System.out.println("results1 || result2 = " + (result1 || result2));
  ```

  <details>
      <summary>Output(출력)</summary>
  
      result1 = true
      result2 = true
      results1 || result2 = true
      
      result1 = true
      result2 = false
      results1 || result2 = true
      
      result1 = false
      result2 = true
      results1 || result2 = true
      
      result1 = false
      result2 = false
      results1 || result2 = false
  </details>
  <br>
  
### 논리 연산자의 진리표(truth table)
|   A   |   B   | A && B | A \|\| B |   !A  |
|:-----:|:-----:|:------:|:--------:|:-----:|
|  true |  true |  true  |   true   | false |
|  true | false |  false |   true   | false |
| false |  true |  false |   true   |  true |
| false | false |  false |   false  |  true |

## Assignment Operator(대입 연산자)
> 변수에 값을 대입할 때 사용하는 이항 연산자  
> 피연산자들의 결합 방향은 오른쪽에서 왼쪽  
> `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `|=`, `^=`, `<<=`, `>>=`, `>>>=`  

- **=**
  > 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함.
  
  ```java
  int x = 120;
  System.out.println("x = " + x);
  int y = 0;
  System.out.println("y = " + y);
  y = x;
  System.out.println("y = " + y);
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x = 120
      y = 0
      y = 120
  </details>
<br>
    
- **+=**
  > 왼쪽의 피연산자에 오른쪽의 피연산자를 더하면서 대입함.
  
  ```java
  int x = 120;
  System.out.println("x = " + x);
  x += 1;
  System.out.println("x += 1 >> x = " + x);

  int y = 10;
  System.out.println("y = " + y);
  x += y;
  System.out.println("x += y >> y = " + x);
  ```
  
  <details>
      <summary>Output(출력)</summary>
      x = 120
      x += 1 >> x = 121
      y = 10
      x += y >> y = 131
  </details>
<br>

- **-=**
  > 왼쪽의 피연산자에 오른쪽의 피연산자를 빼면서 대입함.
  
  ```java
  int x = 120;
  System.out.println("x = " + x);
  x -= 1;
  System.out.println("x -= 1 >> x = " + x);
  
  int y = 10;
  System.out.println("y = " + y);
  x -= y;
  System.out.println("x -= y >> y = " + x);
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x = 120
      x -= 1 >> x = 119
      y = 10
      x -= y >> y = 109
  </details>
<br>

- ***=**
  > 왼쪽의 피연산자에 오른쪽의 피연산자를 곱하면서 대입함.
  
  ```java
  int x = 120;
  System.out.println("x = " + x);
  x *= 2;
  System.out.println("x *= 1 >> x = " + x);
  
  int y = 10;
  System.out.println("y = " + y);
  x *= y;
  System.out.println("x *= y >> y = " + x);
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x = 120
      x *= 1 >> x = 120
      y = 10
      x *= y >> y = 1200
  </details>
<br>

- **/=**
  > 왼쪽의 피연산자에 오른쪽의 피연산자를 나누면서 대입함.
  
  ```java
  int x = 120;
  System.out.println("x = " + x);
  x *= 1;
  System.out.println("x *= 1 >> x = " + x);
  
  int y = 10;
  System.out.println("y = " + y);
  x *= y;
  System.out.println("x *= y >> y = " + x);
  ```
  
  <details>
      <summary>Output(출력)</summary>
  
      x = 120
      x *= 1 >> x = 120
      y = 10
      x *= y >> y = 1200
  </details>
<br>


---

##### 참고 사이트
[[Java] 자바 연산자 (Java Operator)](https://phantom.tistory.com/19)  
[[Java] 쉬프트 연산자 <<, <<<](https://93jpark.tistory.com/132)  
[[JAVA] 비트 쉬프트(Shift)연산자 : << , >> , >>>](https://chans-note.tistory.com/3)  
[비트 연산자](https://www.tcpschool.com/java/java_operator_bitwise#google_vignette)  
[[Java/Short] 문자열/숫자의 왼쪽, 오른쪽에 값 채우는 방법 : String.format()](https://adjh54.tistory.com/134)  
[[Java] .printf() 사용법 익히기 - 콘솔창 출력 왼쪽정렬, 오른쪽정렬, 간격 맞추기](https://bibi6666667.tistory.com/136)  
[printf로 자리수 맞추기](https://freakintp.tistory.com/189)  
[[Java] 문자열 자르기(Substring, Split) 사용법 & 예제](https://byul91oh.tistory.com/309)  
[[JAVA]Java에서 타입 확인하는 완벽한 가이드](https://wyatti.tistory.com/entry/Java%EC%97%90%EC%84%9C-%ED%83%80%EC%9E%85-%ED%99%95%EC%9D%B8%ED%95%98%EB%8A%94-%EC%99%84%EB%B2%BD%ED%95%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)  
[[JAVA 자바 03] 자바(JAVA) 변수(Variable)와 2진수, 8진수, 16진수](https://appia.tistory.com/494)  
[[JAVA] Long 형 타입선언](https://velog.io/@jinjubae/JAVA-Long-%ED%98%95-%ED%83%80%EC%9E%85%EC%84%A0%EC%96%B8)  
