# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
[x] 구입금액 입력받는 InputView
[x] 구매한 로또들의 번호를 출력하는 OutputView
  [x] 로또생성전략 LotteryStrategy
    [x] 로또랜덤생성전략 RandomLotteryStrategy
    [x] 로또순차생성전략(1,2,3, ...) SequentialLotteryStrategy
  [x] 로또들을 구매하는 Lottery.buy
    [x] 로또를 구매하는 buyLottery
[x] 당첨 로또 번호를 입력받는 InputView
[] 보너스 볼을 입력받는 InputView
[x] 당첨 통계를 출력하는 OutputView
  [] 맞춘 개수별로 당첨금액 정보를 저장해 놓는 WinPrizes
  [x] n개 일치하는 로또의 수를 계산해주는 countWinLottery
  [x] 수익률 계산해주는 calculateRateOfReturn
