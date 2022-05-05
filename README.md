# 로또

## TDD 원칙

- 원칙 1 - 실패하는 단위 테스트를 작성할 때까지 프로덕션 코드(production code)를 작성하지 않는다.
- 원칙 2 - 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
- 원칙 3 - 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

# 문자열 사칙 연산 계산기

## 기능 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 `10`을 출력해야 한다.

## 기능 목록

테스트할 수 있는 단위로 나누어 구현 목록을 만든다.

**숫자 객체**

- [x] 정수(양의 정수, 0, 음의 정수)로 구성이 된다.
- [x] 문자형태의 숫자를 전달받아 숫자 객체를 생성한다.
- [x] 숫자 객체의 값을 반환한다.
- [x] 숫자 형식이 아니면 NumberFormat 예외를 던진다.
- [x] null 또는 빈 문자열을 IllegalArgument 예외를 던진다.
- [x] 숫자 객체를 0으로 나누는 경우 Arithmetic 예외를 던진다.

**문자열 분할 객체**

- [x] 기본 구분자가 없는 문자열은 값을 그대로 반환한다.
- [x] 기본 구분자가 포함된 문자열은 구분자로 나누어진 배열을 반환한다.
- [x] 매개변수에 전달된 인자가 null 또는 빈 문자열인 경우 IllegalArgument 예외를 던진다.

**연산자 객체**

- [x] 연산자 객체는 +, -, *, / 로 구성된다.
- [x] 덧셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 더한 결과를 반환한다.
- [x] 뺄셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 뺀 결과를 반환한다.
- [x] 곱셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 곱한 결과를 반환한다.
- [x] 나눗셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 나눈 결과를 반환한다.
- [x] 사칙연산 기호가 아닌 경우 IllegalArgument 예외를 던진다.
- [x] 매개변수로 받은 숫자 객체 값이 null 이거나 빈 공백 문자일 경우 IllegalArgument 예외를 던진다.

**문자열 계산기 객체**

- [x] 입력받은 문자열이 null 또는 빈 값인 경우 IllegalArgument 예외를 던진다.

## v2 기능 목록

**Token**

- [ ] `<digit> := 0|1|2|3|4|5|6|7|8|9` : 숫자는 0,1,2,3,4,5,6,7,8,9 이다.
- [ ] `<operator> := +|-|*|/` : 연산자는 사칙 연산자여야 한다.
- [ ] `<operand> := <digit>+` : 피연산자는 숫자 1개 이상이어야한다.

**Lexer**

입력을 의미있는 최소 단위인 Token 으로 만든다.

- [ ] 입력이 `1*2-3`이면 `1`, `*`, `2`, `-`, `3` 토큰으로 만든다
- [ ] 입력이 `1-2@3`이면 수식에 사용할 수 없는 토큰인 `@`가 포함되어 토큰 형식 예외를 던진다

**SyntaxAnalyzer**

- [ ] `<expr> := <operand><mid expr>*` : 피연산자가 먼저오고 중간 표현이 없거나 반복해서 올 수 있다.
- [ ] `<mid expr> := <operator><operand>` : 중간 표현은 연산자와 피연산자가 순서대로 와야한다.
- [ ] `1+2*3/4` 와 같은 표현식 입력 시 예외 없이 성공한다.
- [ ] `1+2*3#`, `1*2/-2`, `*45` 와 같은 표현식은 구분 문석 형식 예외를 던진다.

**Parser**

- [ ] Token 컬렉션을 받아 트리를 생성하고 트리의 루트를 반환한다.

**Calculator**

- [ ] 트리로 계산 수행 후 결과를 출력한다.


