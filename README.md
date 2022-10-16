# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 구현 목록
* `LottoController`
  * `lottoGame`: 로또 로직 처리 후 뷰에 값 전달
* `Lotto`
  * `issue`: 사용자 입력 값을 받아 로또 반환
  * `compareNumber`: 로또 번호 비교(일치하는 수 반환)
  * `lottoNumbers`: `LottoNumber` 타입의 로또 번호 반환
* `LottoNumber`: 로또 번호들을 관리하는 일급 컬렉션
  * `lottoNumber`: 특정 로또 번호를 `LottoNumber`타입으로 반환
  * `lottoNumbers`: 로또 번호 6자리를 `List<LottoNumber>`타입으로 반환
  * `lottoNumber`: 특정 로또 번호를 `int`타입으로 반환
* `LottoPrize`: 로또 경품을 관리하는 역할의 도메인
  * `matchCount`: 매칭된 숫자를 반환
  * `amount`: 경품 금액 반환
  * `matchBonus`: 보너스 번호 반환
  * `of`: 매칭된 로또 숫자의 갯수와 일치하는 경품 도메인 반환
* `Payment`: 사용자 지불 도메인
  * `amount`: 지불 금액 반환
  * `count`: 구매 가능 수량 반환
* `ResultStats`: 로또 결과를 통계내는 도메인
  * `countsOfPrizes`: `LottoPrize`에 관리되는 경품의 등수별 통계 숫자를 내는 기능
  * `returnOfInvestment`: 사용자가 입력한 금액 대비 투자 수익률을 내는 기능
* `winningLotto`: 당첨 번호 도메인
  * `winningLotto`: 당첨 번호를 `Lotto`타입으로 반환
  * `bonusNumber`: 보너스 번호 반환
