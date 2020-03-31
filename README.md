# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 구현 설계
- Lotto class
  - List<LottoGame> property
  - getRanks method
  
- LottoGame class
  - List<LottoNo> property
  - genarateRandomNumbers method
  
- LottoNo class 
  - Integer property

- WinningNumbers class 
  - LottoGame property
  - LottoNo property
  - getRank method
  
- Ranks class  
  - List<Rank> property
  
- Rank enum

- InputView class
  - getPurchaseAmount method
  - getWinningNumbers method
  
- ResultView class
  - printRanks method