# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항
* 로또 구입 금액을 입력 받는다.
* 로또 구매 개수를 출력 한다.
  * 로또 가격은 1장에 1,000원 이다.
* 지난 주 당첨 번호를 입력 받는다.
  * 로또 번호는 1~45 사이의 번호만 입력 받을 수 있다.
* 로또 구입금액을 입력하면 구입 금액에 해당하는 로또 개수를 출력한다.
  * 로또는 자동생성은 Collection.suffle() 메서드를 사용한다.
* 구매한 로또들의 당첨 통계를 나타내야 한다.
  * 3~6개 일치에 해당하는 개수와 수익률을 나타내야 한다.
