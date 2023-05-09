# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


### Step 1
- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
  - [x] 덧셈 구현
  - [x] 뺄셈 구현
  - [x] 곱셈 구현
  - [x] 나눗셈 구현
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
  - [x] 입력 값이 null이거나 빈 공백일 경우 IllegalArgumentException 발생
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
  - [x] 나눗셈은 연산수로 0이 오면 IllegalArgumentException 발생
- [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- [x] 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### Step 2
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 로또 클래스
  - [x] 한장당 구입 금액 설정
  - [x] 입력받은 액수로 살 수 있는 로또 갯수
    - [x] 입력받은 액수만큼 로또 구매
  - [x] 로또 발행
    - [x] 로또에서 뽑을 수 있는 숫자 범위
    - [x] 로또에서 뽑히는 숫자 갯수
  - [x] 당첨번호 입력
    - [x] 당첨 통계 계산
      - [x] 등수별 갯수
      - [x] 수익률 계산
  - [x] 당첨 통계 출력

### Step 2
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 로또 클래스

### Step 3
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다.
- [x] 당첨 통계에 2등도 추가해야 한다.
  
