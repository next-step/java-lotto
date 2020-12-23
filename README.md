# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

---
### 모델링
##### InputView
* 구입금액 입력
* 구매할 수동 로또 장 수 입력
* 수동 로또 번호 입력(구매한 장 수 만큼)
* 지난주 당첨번호 입력
* 보너스 볼 입력

##### AutoLottoTicketFactory
* 랜덤으로 LottoNumber 6개 뽑는다
    * Collections.shuffle() 사용

##### LottoNumber
* 값은 1부터 45까지 중 하나이다.

##### LottoTicket
* 로또 1장 -> LottoNumber 6개
* 당첨 번호와 비교하며 맞춘 갯수 반환.
* 보너스 볼과 일치하는 숫자가 있으면 true 반환.
* 당첨 번호와 보너스 볼을 비교한 값에 따라 해당 Rank 반환.

##### LottoTickets
* LottoTicket 여러 장을 리스트 형식으로 가지고 있는다.

##### WinningLottoNumbers
* 당첨 번호와 보너스 볼을 가지고 있는다.
* 숫자가 당첨 번호에 포함되어 있으면 true 반환.
* 보너스 볼과 숫자가 일치하면 true 반환.

##### LottoMachine
* 지급한 금액만큼 LottoTicket 여러 장 발급

##### LottoGame
* 지난주 당첨번호(보너스 볼도 포함)와 발급한 로또 번호(수동, 자동)들 모두 비교

##### Money
* 발급할 LottoTicket 갯수 계산
    * LottoTicket 1장(숫자 6개)당 1000원
* 수익률 계산
    * (총 당첨 금액) / (지급한 금액) -> 소수 둘째자리까지

##### Rank
* 3개 일치하면 5000원
* 4개 일치하면 50000원
* 5개 일치하면 1500000원
* 5개 일치하고 보너스 볼도 일치하면 30000000원
* 6개 일치하면 2000000000원
* 5개 일치 & 보너스 볼 일치 여부에 따라 2등,3등 판단.

##### LottoResult
* 모든 LottoTicket 비교한 결과값 저장

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
