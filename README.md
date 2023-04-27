# 로또 미션

---
## Step4 - 로또(수동)
### Step3 2차 피드백 수정
- [ ] 정적 팩토리 메서드명 init으로 변경

### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 구현 목록
- [ ] 수동 구매 로또 수 입력 기능
- [ ] 수동 로또 구매 번호 입력 기능
- [ ] 자동 로또 수 계산 기능
- [ ] 로또 구매 장수 출력 기능(수동/자동)

---
## Step3 - 로또(2등)
### Step3 1차 피드백 수정
- [X] WinningLotto 객체 추가
- [X] Statistics 객체 생성 시 3등을 구하는 로직을 제거
- [X] LottoNumber 객체끼리 비교

### Step2 2차 피드백 수정
- [X] 사용하지 않는 상수 private 변경
- [X] LottoNumbers 메서드 추출
- [X] 로또 1장도 구매 가능하도록 수정
- [X] 메서드에 불필요한 throws 삭제

### Step3 구현 목록
- [X] 보너스 볼 입력 기능 추가
  - [X] 이미 입력한 당첨 번호에 포함된 번호면 에러 리턴
- [X] 당첨 통계에 보너스볼 추가
- [X] 결과 출력에 2등 보너스볼 추가

---
## Step2 - 로또(자동)

### 1차 피드백 수정
- [X] LottoNumber 원시값 포장
- [X] 개행을 통한 가독성 높임
- [X] Lottos 클래스 생성자 접근제어자 변경
- [X] 테스트 케이스에서 assertAll 활용
- [X] 주 생성자에서 유효성 검증
- [X] 소수점 계산 View로 책임 이동
- [X] Lotto 리스트로 뷰 출력
- X 셔플 테스트 수정
  - LottoNumber 원시값 포장으로 관련 로직 수정하여 관련 테스트 하지 않음
- [X] CustomException 활용
- [X] 당첨 번호 자료구조로 EnumMap 활용
- [X] 수익률 계산 방식 수정 - 기능 결함

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
