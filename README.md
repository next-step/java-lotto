# 문자열 계산기

## 기능 요구사항

* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## 프로그래밍 요구사항

* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.

## 기능 분리 힌트

* 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
    * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    * 사칙 연산을 모두 포함하는 기능 구현
* 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
* 반복적인 패턴을 찾아 반복문으로 구현한다.

## 기능 구현 목록

### domain

- CalculationLogic : 계산 로직을 담는 클래스
- Calculator : 입력된 숫자와 연산자에 따라 계산을 수행
- Operator : 사칙연산자를 표현하는 열거형

### util

- StringUtils : 문자열 검증과 파싱 등의 기능을 제공하는 유틸

### view

- InputView : 사용자의 입력을 받는 기능을 제공
- ResultView : 결과를 출력하는 기능을 제공

## 테스트 케이스

- [x] 덧셈 테스트
- [x] 뺄셈 테스트
- [x] 곱셈 테스트
- [x] 나눗셈 테스트
- [x] 문자열 공백 분리 테스트
- [x] 문자열 파싱 테스트
- [x] 입력 문자열이 사칙연산 기호가 아닌 경우 IllegalArgumentException
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException
- [x] 사칙연산을 모두 포함하는 기능 테스트