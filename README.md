# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODO
* Input
  * 지난 주 당첨 번호를 입력한다.
* Domain
  * 구입금액으로 로또 진행횟수를 구할 수 있다.
  * 로또 진행횟수를 받아서 2차원 배열(혹은 리스트)를 생성해낼 수 있다.
    * 생성해내는 로직과 데이터에 담는 로직을 분리할 수 있다. => 테스트의 어려움을 해결(?)
  * 3 ~ 6개의 일치하는 갯수를 뽑아낼 수 있다.
  * 총 수익률을 구해낼 수 있다.
* Output
  * 셔플을 돌리고 나온 로또 결과를 출력한다.
  * 당첨 통계를 출력한다.
  * 총 수익률을 출력한다.

## DONE

* Input
  * 구입금액을 입력한다.
* Domain
* Output
  * 구매갯수를 출력한다.