# 1단계 - 문자열 계산기

# 기능 목록

---

## OperatorEnum
- 앞의 값에서 뒤의 값을 더한다.
- 앞의 값에서 뒤의 값을 뺀다.
- 앞의 값에서 뒤의 값을 곱한다.
- 앞의 값에서 뒤의 값을 나눈다.
- 계산기가 지원하는 연산자인지 확인한다.

## Parser
- 입력 문자열이 비어있으면 IllegalArgumentException 예외를 발생한다.
- 문자열을 구분자로 나눠서 list로 반환한다.
- 사칙연산 순서에 사칙연산 기호가 아닌경우 IllegalArgumentException 예외를 발생한다.
- 숫자 순서에 숫자가 아닌경우 IllegalArgumentException 예외를 발생한다.
- 숫자 순서에 모두 숫자일경우 숫자가 담긴 deque를 리턴한다.
- 연산자 순서에 모두 연산자일경우 연산자가 담긴 deque를 리턴한다.

## Calculator
- 식을 계산한 값을 리턴한다.