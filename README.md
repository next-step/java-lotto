# 로또 미션

---
## Step2 - 로또(자동)
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 지난 주 당첨 번호를 입력하여 통계를 낸다.

### 구현 목록
- [X] 입력 기능 
  - [X] 로또 구입 금액 입력 기능
  - [X] 당첨 번호 입력 기능 
- [X] 금액 만큼 로또 발급 기능
- [X] 통계 계산 기능
- [X] 출력 기능
  - [X] 발급한 로또 출력 기능
  - [X] 결과 출력 기능

---
## Step1 - 문자열 계산기
### 2차 피드백 구현 내용
- [X] 상수 정의 방식 변경
- [X] @EnumSource 활용 X
  - 현재 테스트 케이스에서는 다소 사용하기 어려운 부분이 있어서 향후 사용 예정
- [X] calculate 메서드 구현 방식 변경

---
### 1차 피드백 구현 내용
- [X] 매직넘버 및 상수 처리
- [X] Queue 타입으로 연산자 기호 활용
- [X] 테스트 케이스 수정
- [X] 메서드 순서 정리

---
### 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

---
### 구현 목록
- [X] 문자열 입력 
- [X] 공백 기준으로 분리
- [X] 계산 기능
  - [X] 덧셈 기능
  - [X] 뺄셈 기능
  - [X] 덧셈 기능
  - [X] 나눗셈 기능
- [X] 결과 출력

---

## 학습 내용 정리

---
### @EnumSource 
- Enum에 정의된 상수들을 테스트하기 위한 어노테이션
- [참고 링크](https://www.baeldung.com/parameterized-tests-junit-5#3-enum)
