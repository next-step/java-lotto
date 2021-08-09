# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


---
# 로또 요구사항 분석

#### Money (돈)

- 0 보다 작을 수 없다


#### LotteryNumber (로또 숫자)

- 1~45 사이의 숫자 1개를 가진다


#### Lottery (로또)

- 중복되지 않는 LotteryNumber (로또 숫자)를 6개를 가진다
- 다른 Lottery (로또)와 비교하여 당첨 여부를 판단해 WinningLottoCriteria (로또 당첨 기준) 정보를 반환한다
- 1개당 1000원


#### Lotteries (로또 리스트)

- 여러개의 Lottery (로또) 를 가진다
- LotteryStatistic (로또 통계) 를 제공한다


#### LotteryResult (로또 결과)

- 로또 당첨 기준 점수, 상금 정보를 제공한다


#### CreatingLotteryStrategy (로또 생성 전략) / RandomCreatingLotteryStrategy (랜덤 로또 생성 전략)

- Lottery (로또) 를 랜덤으로 생성한다


#### WinningLotteryStrategy (로또 당첨 전략) / MatchWinningLotteryStrategy (매칭 로또 당첨 전략)

- Lottery (로또)와 당첨번호를 비교하여 당첨 여부를 판단해 WinningLottoCriteria (로또 당첨 기준) 정보를 반환한다



