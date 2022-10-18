# 문자열 사칙 연산 계산기 구현

## 1. 인풋

- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 입력 값을 분리하여 배열 리스트로 만든다.

## 2. 덧셈

## 3. 뺄셈

## 4. 곱셈

## 5. 나눗셈

- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

## 6. 계산

- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- for 문에서 홀수번째 입력 값이 숫자인지 확인한다.
- for 문에서 짝수번째 입력 값이 연산자 인지 확인한다.
- 연산자 입력 값에 따라 연산자 앞 뒤의 값을 연산하고 연산 값을 리턴한다.
- 연산한 리턴 값은 첫번째 연산 값이 된다.

---

# 로또

## 교환기(Exchanger)
- 인풋으로 금액을 받는다.
- 금액은 1000 단위로 나눈다.
- 금액이 1000 단위가 아니라면 에러 메시지를 보낸다. -> 인풋 로직 인풋으로 옮기기

## 추첨기(Lottery)
- 수량을 받는다.
- 수량 만큼 로또를 생성한다. (List<Lotto> -> Lottos)

## 로또 번호 생성기(LottoNumber)
- 1 ~ 45 번 리스트를 가지고 있다.
- 셔플을 하고 6개의 숫자로 나누고 소팅한다.

