# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
---

## 구현사항

### Domains
- LottoNumber
    - 로또 숫자의 범위는 1~45 까지이다.
- Lotto
    - 자신이 몇 등인지 알 수 있다.
- LottoWinner
    - 당첨 번호와 보너스 번호를 가지고 있다.
- Prize
    - Enum 객체로 등수정보와 상금정보를 가지고 있다.
- LottoGenerator
    - 숫자 6개를 중복없이 오름차순으로 생성할 수 있다.
- LottoStatistics
    - 로또 숫자와 지난주 당첨번호를 가지고 통계를 낼 수 있다.
- LottoPurchasedAmount
  - 로또 구입 금액을 검증하고 관리한다.
### UI
- InputView
    - 구매금액과 지난 주 당첨 번호를 입력 받을 수 있다.
- ResultView
    - LottoStatistics 를 출력해준다.
