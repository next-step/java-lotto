# 로또

## 1단계 - 문자열 계산기

### 기능 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 기능 구현 목록

- [X] 문자열을 입력받는다.
    - null이거나 빈 공백 문자열일 경우 예외 발생
- [X] 입력받은 문자열을 연산자와 피연산자로 구분한다.
  - 연산자 기호가 아닌 경우 예외 발생
  - 피연산자가 숫자가 아닌 경우 예외 발생
- [ ] 덧셈
- [ ] 뺼셈
- [ ] 곱셈
- [ ] 나눗셈
  - 0으로 나누는 경우 예외 발생
- [ ] 연산 결과를 출력한다.
