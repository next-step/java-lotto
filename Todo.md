# Step1

## Todo
- [ ] CalculateHandler를 "문자열이 숫자인지 연산자인지 판단/왼쪽부터 순서대로 계산" 2가지 책임을 가진 클래스로 분리
- [ ] Operator의 toOperator를 stream 써서 리팩토링
- [ ] IntBinaryOperator를 Functional Interface를 사용해서 직접 구현하는 행태로 변경

- 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)

## Done
- [x] 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- [x] 덧셈("1 + 2" => 3)
- [x] 뺄셈("1 - 2" => -1)
- [x] 곱셈("1 * 3" => 3)
- [x] 나눗셈("4 / 2" => 2)x
- [x] 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)
- [x] 정의된 연산자 이외라면 예외("1 ( 2" => IllegalArgumentException)
- [x] 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)
- [x] 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)
- [x] intelliJ newLine 적용
- [x] Todo.md에 md 문법 적용

- 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- 덧셈("1 + 2" => 3)
- 뺄셈("1 - 2" => -1)
- 곱셈("1 * 3" => 3)
- 나눗셈("4 / 2" => 2)x
- 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)

## Done
- [x] 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- [x] 덧셈("1 + 2" => 3)
- [x] 뺄셈("1 - 2" => -1)
- [x] 곱셈("1 * 3" => 3)
- [x] 나눗셈("4 / 2" => 2)x
- [x] 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)
- [x] 정의된 연산자 이외라면 예외("1 ( 2" => IllegalArgumentException)
- [x] 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)
- [x] 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)
- [x] intelliJ newLine 적용
- [x] Todo.md에 md 문법 적용
- [x] Operator의 toOperator를 stream 써서 리팩토링
- [x] IntBinaryOperator를 Functional Interface를 사용해서 직접 구현하는 행태로 변경
- [x] CalculateHandler를 "문자열이 숫자인지 연산자인지 판단/왼쪽부터 순서대로 계산" 2가지 책임을 가진 클래스로 분리

- 정의된 연산자 이외라면 예외("1 ( 2" => IllegalArgumentException)
- 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)
- 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)
