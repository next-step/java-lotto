# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 3단계 이후 리팩토링 필요 사항
* 사용자가 입력하는 로또 넘버 캐싱
* 당첨번호, 보너스 번호를 당첨번호를 표현하는 클래스로 분리
* 매직넘버 상수화

## 기능 목록
- 로또 구매 금액 입력
  - 1000원 단위 입력 가능
- 수동으로 구매할 로또 수 입력
  - 로또 장수 입력
  - 수동으로 구매할 번호 입력
- 로또 번호 발급
  - 수동 포함 천원당 1장 발급
  - 1 ~ 45 중 랜덤하게 6개 숫자 정렬
- 지난주 당첨 번호 입력
  - 1 ~ 45의 숫자중 중복되지않는 6개 입력
- 보너스 번호 입력
  - 당첨 번호와 중복되지 않는 2등 보너스 번호 입력
- 당첨 통계 출력
  - 3개일치,4개일치,5개일치,5개일치 + 보너스 볼 일치, 6개 일치된 개수 출력
  - 투자금액 대비 당첨된 금액으로 총 수익률 출력

## 구조(구현 전)
- constants
  - Constants
  
- controller
  - LottoController
  
- domain
  - Lotto
  - Lottos
  - LottoStatistics
  - Money
  - Number
  - Rank
  
- generator
  - LottoNumberGenerator
  - NumberGenerator
  
- view
  - InputView
  - ResultView
  
## 구조(구현 후)
- constants
  - Constants

- controller
  - LottoController

- domain
  - Lotto
  - Lottos
  - LottoStatistics
  - Money
  - Number
  - Rank
  - WinningLotto

- factory
  - LottoFactory

- generator
  - LottoNumberGenerator
  - NumberGenerator

- view
  - InputView
  - ResultView