# 요구사항 정리
## 요약
*사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현*

## InputView
- [ ] 입력 문자열의 숫자와 사칙 연산을 공백으로 구분
    - null값이 들어왔을 때 Exception
    - 잘못된 값이 들어왔을 때 Exception

## CalculationMethod
- [ ] sum, subtraction, multiplication, division의 인터페이스

## sum
- [ ] 덧셈 결과를 전달

## subtraction
- [ ] 뺄셈 결과를 전달

## multiplication
- [ ] 곱셈 결과를 전달

## division
- [ ] 나눗셈 결과를 전달
    - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
    - 0으로 나누면 Exception

## calculator
- [ ] 문자열 계산기 실행
  - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
  - (ex) 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력

## OutputView
- [ ] 계산 결과를 출력