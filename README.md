# 로또
## 2단계 - 문자열 덧셈 계산기

### 기능 요구사항

* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.\
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.


### 기능 목록
* Number
  * 숫자를 나타내는 int primitive type을 포장하는 클래스
  * 숫자 정수형이 입력되었나 확인하는 기능을 갖는다
  * 숫자 양수값이 입력되었나 확인하는 기능을 갖는다.
  * 두 Number 객체를 더해서 더한 값을 갖는 새로운 Number 객체를 반환하는 기능을 갖는다.
  * 내부의 int 값을 노출하는 기능을 갖는다.

* Operator
  * 알맞은 연산자를 선택해서 계산값을 반환할 수 있는 enum
  * 문자열 형태에 따라 default delimiter operator인지 custom delimiter operator인지 선택할수 있다.
  * caculate method를 사용하면 계산값을 반환 할 수 있다.

* StringAdder
  * 계산할 때 사용할 클래스
  * input 값을 받으면 문자열의 합을 반환하는 static 메서드를 갖는다.

### 코드리뷰 사항 리팩토링
* Adder
  * sum이라는 메서드를 갖는 인터페이스
  * Operator enum에서 구현해서 sum이라는 기능을 각 구현체가 갖게 한다.
* Operator
  * static 메서드 였던 sum을 Adder 인터페이스의 추상 메서드를 구현한 메서드로 바꾼다.
