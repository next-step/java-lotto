# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## Step1 기능 목록

- 입력된 문자열에 따라 사칙연산을 할 수 있어야 한다.
  - 숫자와 사칙 연산 사이에는 반시드 빈 공백 문자열이 있다.
  - 사친연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결졍된다.
  - 나눗셈은 정수로 떨어지는 값을 결과로 한다.
- 빈 문자열이나 null 이 입력되면 예외가 발생해야 한다.
- 사칙연산 기호 이외의 문자가 들어가 있으면 예외가 발생해야 한다.

<br>

## Step2 기능 목록

### domain 분석

- 로또는 숫자 6개를 가지고 있어야 한다.
- 숫자 6개를 만들 수 있어야 한다.
  - 이 때 랜덤으로 만들고, 서로 중복이 되면 안된다.
- 당첨번호와 비교해서 등수와 가격을 반환할 수 있어야 한다.
- 유저가 원하는 만큼의 로또를 구입할 수 있어야 한다.
- 유저의 수익률을 구할 수 있어야 한다.
- 로또 숫자 범위를 벗어난 경우 예외가 발생해야 한다.

<br>

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)