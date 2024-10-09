# 로또

### TODO

1. [x] 사용자가 문자열을 입력할 수 있도록 한다
2. [x] 입력한 문자열 값에 따라 사칙연산을 수행한다
3. [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다
4. [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다
5. [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다
6. [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
7. [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw

### 기능 분리 힌트

* 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
    * 사칙 연산을 모두 포함하는 기능 구현
* 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
* 반복적인 패턴을 찾아 반복문으로 구현한다.

### 프로그래밍 요구사항

* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.
* 값을 입력 받는 API는 Scanner를 이용

### AngularJS Commit Message Conventions

* feat (feature)
* fix (bug fix)
* docs (documentation)
* style (formatting, missing semi colons, …)
* refactor
* test (when adding missing tests)
* chore (maintain)
