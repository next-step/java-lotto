# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 목록 (로또 1단계)
* LottoStore
    * LottoStore는 로또(LottoTicket)를 판매한다.
    * LottoStore는 구입금액 내에서 가능한 최대 갯수의 LottoTicket를 판매한다.
    * LottoStore가 판매하는 LottoTicket의 기본 가격은 1000원이다.
* LottoTicket
    * LottoTicket은 1부터 45 사이의 중복되지 않는 숫자 6개를 포함한다.
    * WinningLottoTicket과 비교해서 당첨 결과(LottoResult)를 반환한다.
* LottoTickets
    * LottoTickets은 구입한 LottoTicket 목록을 소유한다.
* RandomLottoTicketGenerator
    * 1 ~ 45 사이의 중복되지 않는 숫자 6개를 생성한다.
* WinningLottoTicket
    * Winning LottoTicket은 1부터 45 사이의 중복되지 않는 숫자 6개를 포함한다.
* LottoResult
    * LottoResult는 WinningLottoTicket과 LottoTicket간의 일치하는 숫자 결과를 포함한다.
    * LottoResult는 일치하는 숫자 갯수인 0 ~ 6 중의 하나와, 그에 따른 당첨금 내용을 포함한다.
    * 당첨 결과는 다음과 같다.
        * 0 ~ 2 일치 : 0
        * 3개 일치 : 5000원
        * 4개 일치 : 50000원
        * 5개 일치 : 1500000원
        * 6개 일치 : 2000000000원
* LottoResults
    * LottoResults는 LottoTickets이 포함한 LottoTicket의 개별 LottoResult 목록을 포함한다. 