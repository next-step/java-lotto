# Java Lotto

## Step1: String Calculator

### Requirements

#### 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.

- [ ] 문자값 입력
- [ ] 문자값 유효성 검증: Integer(숫자) 와 Operator(사칙연산) 만 입력받는다. 그렇지 않은 경우 에러

#### 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.

- [ ] 문자값 유효성 검증: 각 Value(Integer, Operator) 는 빈 공백으로 구분된다.
- [ ] 빈 공백으로 구분한 사이즈가 0 인경우 에러

#### 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

- [ ] 나눗셈의 결과값이 Integer가 아닌 경우 예외 처리
- [ ] 0 으로 나눌 경우 예외 처리

#### 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.

- [ ] 입력 순서대로 계산 수행

#### 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

- [ ] equation 입력에 대한 결과 출력 테스트

### Todo

- [x] create classes Arithmetic, Value(Integer, Operator)
- [x] InputView, InputView
- [x] parse equation to Value, evaluateOperator, evaluateInteger
- [x] compute operators

### Result

```
Put your equation.
1 + 2 * 4 / 2 % 5
Result: 1
```
