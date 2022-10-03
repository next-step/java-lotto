# 문자열 계산기
## 기능 요구 사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.

## 기능목록
- [x] 사칙연산 동작 구현
- [x] InputParser
- [x] StringCalculator
- [x] Input, Output 출력을 위한 View 구현

# 로또
## 기능 요구 사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 기능목록
- [x] 구입금액 입력
- [x] 로또번호 및 로또티켓 제한 조건
  - [x] 로또번호: (1 <= 숫자 <= 45)
  - [x] 로또티켓: 로또 번호들이 같아도 다른 티켓 
- [x] 로또티켓 판매 로직
- [x] 지난 주 당첨 번호 입력
- [x] 티켓 당첨 등수 확인
- [ ] 추첨 결과 출력
- [ ] 수익률 출력
