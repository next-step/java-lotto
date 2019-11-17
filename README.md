# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

1. LottoService
- main 메서드 :
- start 메서드 : Lotto 실행을 총괄, 뷰 객체와 도메인 객체 간의 소통 창구

2. LottoTickets
- 생성자 : 티켓 구매 횟수만큼 티켓 객체를 생성해서 등록한다.
- getLottoTickets : LottoTicket 객체들이 저장된 멤버 변수 ArrayList를 반환한다.

3. LottoTicket
- 생성자 : 객체를 생성하고, 랜덤하게 6개의 숫자를 생성해서 ArrayList 멤버 변수에 저장한다.
- getTicketNumbers : 로또 번호가 등록된 ArrayList 멤버 변수를 반환한다.

4. WinningNumbers
- 생성자 : 인자로 들어온 로또 당첨 번호를 ArrayList 멤버 변수에 등록한다.
- getWinningNumbers : 로또 당첨 번호가 저장된 ArrayList 멤버 변수를 반환한다.

5. LottoResult
- makeResult : 결과를 만들기 위한 최상위 메서드
- compareTicket : 구매한 티켓의 모든 번호와 로또 당첨 번호를 비교해서 당첨 내역을 카운팅하는 메서드
- compareTicketNumber : 구매한 티켓의 번호 중 하나를 골라 로또 당첨 번호에 포함되었는지 여부를 확인하는 메서드
- calculateEarning : 로또 구매를 통해 얻은 금액을 계산하는 메서드
- calculateEarningRate : 로또 구매의 최종 수익률을 계산하는 메서드

6. InputView
- getPurchaseAmount : 구매 금액을 입력 받는 메서드
- getWinningNumbers : 로또 당첨 번호를 입력 받는 메서드

7. ResultView
- printTicketCount : 구매한 티켓 갯수를 출력하는 메서드
- printLottoTickets : 구매한 로또 티켓의 번호를 출력하는 메서드
- printWinningNumbers : 당첨 번호를 출력하는 메서드
- printResult : 최종 결과를 출력하는 메서드
