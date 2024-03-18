# Step1

## Todo
- 연산자가 양끝에 있으면 예외("1 +" =>외IllegalArgumentException, "+ 1" => IllegalArgumentException)

## Done
- 입력값이 null 또는 빈문자열이면 예외("" => IllegalArgumentException, null => IllegalArgumentException)
- 덧셈("1 + 2" => 3)
- 뺄셈("1 - 2" => -1)
- 곱셈("1 * 3" => 3)
- 나눗셈("4 / 2" => 2)x
- 2개 이상의 사칙연산("2 + 2 / 2" => 2, "2 + 2 - 1 * 5" => 15)
- 정의된 연산자 이외라면 예외("1 ( 2" => IllegalArgumentException)
- 숫자나 연산자가 연속으로 들어오면 예외("1 2" => IllegalArgumentException)