# 로또 기능
- 구매자는 로또를 구매할 총 금액을 입력할 수 있다.
- 구매자는 수동으로 구매할 로또 수를 입력할 수 있다.
- 구매자는 수동으로 구매할 로또 번호를 입력할 수 있다.
- 수동으로 구매한 로또를 생성한다.
- 전체 금액에서 수동으로 구매한 금액을 제외한 나머지 금액으로 자동 로또를 생성한다.
- 수동, 자동으로 구매한 로또를 출력한다.
- 보너스 볼을 입력할 수 있다.
- 3 ~ 6개가 일치하는 경우를 표시한다.
  - 1등 : 6개 일치
  - 2등 : 5개 + 보너스볼 일치
  - 3등 : 5개 일치
  - 4등 : 4개 일치
  - 5등 : 3개 일치
- 구매자의 당첨통계, 수익률과 손해/이득 여부를 출력한다.

## 문자열 계산기 기능
- 입력받은 문자열을 공백을 기준으로 분리해 숫자와 연산자로 나눈다.
  - 입력 값이 null이거나 빈 공백이면 예외를 발생시킨다.
- 숫자 사이에 있는 기호가 사칙연산 기호가 아닌 경우 예외를 발생시킨다.
- 나뉘어진 숫자와 연산자로 계산한다.
  - 두 수를 더할 수 있다.
  - 두 수를 뺄 수 있다.
  - 두 수를 곱할 수 있다.
  - 두 수를 나눌 수 있다.
    - 나누는 수가 0이면 예외를 발생시킨다.

## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)