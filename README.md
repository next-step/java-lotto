# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# 문자열 사칙 연산 계산기

### 기능 요구사항
[x] 사용자가 문자열을 입력합니다.
[x] 입력 문자열의 숫자와 사칙연산 사이에는 반드시 빈 공백 문자열이 있습니다.
[x] 나눗셈의 경우 결과 값을 정수입니다.
[x] 연산자 우선순위는 무시합니다.

### 기술 요구사항
[x] depth 1 단계
[x] `if() { while(){}; }` <- 불가
[x] 메소드는 최대 10라인
[x] 예상외의 값 입력시 예외처리
[x] 사칙연산 기호가 아닐경우 예외처리
[x] 반복적인 패턴을 찾아 반복문으로 구현

### 산출 클래스
- controller
  Main.java
  CalculatorController.java
- **domain** (테스트 필수)
  [x] AddExpression.java
  [x] Calculator.java
  [] CalculatorExpression.java (인터페이스)
  [x] Expression.java (ENUM 테스트)
  [x] DivideExpression.java
  [x] MinusExpression.java
  [x] MultiplicationExpression.java
  [x] VariableExpression.java
- view
  InputView.java
  ResultView.java
 끝.

---

# 로또

### 기술 요구사항
[x] else 금물, switch 금물
[] depth 1 단계
[x] 메소드는 최대 15라인
[x] 예상외의 값 입력시 예외처리
[x] 도메인은 무조건 테스트

### 기능 요구사항
[x] 로또 구입 금액을 입력
[x] 구입 금액에 해당하는 로또 발급
[x] 로또 1장의 가격은 1000원
[x] 지난주 당첨 번호 입력
[x] 통계 (3개 일치 - 5000)
[x] 통계 (4개 일치 - 50000)
[x] 통계 (5개 일치 - 1500000)
[x] 통계 (6개 일치 - 2000000000)
[x] 수익율 계산

### 산출 클래스 예상
- controller
  Main.java
  LottoController.java
- **domain (유동적, 테스트 필수)**
  Lotto.java (List<LottoNumber> 로또 한장)
  LottoNumber.java (Integer로 로또 번호 하나)
  LottoWallet.java (List<Lotto> 로또 여러장)
  WinningLotto.java (Lotto 지난주 로또 한장)
  MoneyWallet.java (사용자가 입력한 값)
  StatisticsReport.java (로또 통계레포트) 🤔
  IncomeReport.java (로또 손익레포트)
- util
  LottoGenerator.java
- view
  InputView.java
  ResultView.java

### 산출 클래스 진행중
- controller
  Main.java
  LottoController.java
- **domain**
  [x]Lotto.java (List<LottoNumber> 로또 한장)
  [x]LottoNumber.java (Integer로 로또 번호 하나)
  [x]LottoShop.java (로또 생성 팩토리)
  [x]LottoNumberFactory.java (로또 넘버 자동 생성 팩토리)
  [x]LottoWallet.java (List<Lotto> 로또 여러장)
  [x]WinningLotto.java (Lotto 지난주 로또 한장)
  [x]MoneyWallet.java (사용자가 입력한 값)
  [x]Prize.java (로또 등수 상금)
  [x]StatisticsReport.java (로또 통계레포트) 🤔
  [x]IncomeReport.java (로또 손익레포트)
- view
  InputView.java
  ResultView.java

### 리팩토링 사항
- StatisticsReport
  1. totalPrize() [2 depth 위배]
