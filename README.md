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

# 문자열 사칙 연산 계산기

### 기능 요구사항
[✔] 사용자가 문자열을 입력합니다.
[✔] 입력 문자열의 숫자와 사칙연산 사이에는 반드시 빈 공백 문자열이 있습니다.
[✔] 나눗셈의 경우 결과 값을 정수입니다.
[✔] 연산자 우선순위는 무시합니다.

### 기술 요구사항
[✔] depth 1 단계
[✔] `if() { while(){}; }` <- 불가
[✔] 메소드는 최대 10라인
[] 예상외의 값 입력시 예외처리
[] 사칙연산 기호가 아닐경우 예외처리
[✔] 반복적인 패턴을 찾아 반복문으로 구현

### 산출 클래스
- controller
  Main.java
  CalculatorController.java
- **domain** (테스트 필수)
  [✔] AddExpression.java
  [✔] Calculator.java
  [✔] CalculatorExpression.java
  [✔] CalculatorService.java
  [✔] DivideExpression.java
  [✔] MinusExpression.java
  [✔] MultiplicationExpression.java
  [✔] VariableExpression.java
- view
  InputView.java
  ResultView.java
 끝.