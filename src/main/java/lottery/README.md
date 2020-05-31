## 구조

### Domain

* PurchasePrice
    * 로또 구매 금액과 관련된 클래스
    * 객체 생성시 입력받은 금액이 티켓 1장 가격(1000)보다 낮을 경우 예외 발생
    * 해당 금액으로 구매할 수 있는 로또 티켓의 개수를 반환함

* LotteryStore
    * PurchasePrice를 통해 얻은 구매 가능한 티켓 개수를 기반으로 로또 티켓을 발행

* LotteryNumber
    * 로또 티켓을 구성하는 번호의 객체
    * 1 ~ 45 범위만 유효함

* LotteryTicket
    * 로또 번호 6자리 List의 일급 컬렉션
    * String 배열의 매개변수도 처리하여 객체 생성 가능
    * LotteryNumbersGenerator를 활용하여 랜덤 6자리 번호의 로또 티켓 발행
    * 로또 번호가 6자리가 아니거나, 중복 번호가 있으면 예외 발생
    * 각 로또 티켓의 번호들만 추출하여 리스트로 제공

* LotteryTicketsGroup
    * Lottery Ticket의 List 일급 컬렉션
    * 매개변수로 가격을 받으면 해당 가격으로 살수있는 금액만큼 로또 티켓들을 생성
    * 각 로또 티켓들의 번호 리스트를 집계하여 제공

* LotteryNumbersGenerator
    * 로또 티켓 1장에 필요한 로또 숫자 6개를 랜덤으로 자동 생성해주는 유틸 클래스
 
* LotteryGame
    * 발행한 티켓 그룹과 당첨 번호 티켓을 받아 게임을 진행함.
    * winner ticket들의 정보를 반환함

* LotteryGameResult
    * 로또 당첨자 명단을 바탕으로 수익률 집계 및 각 순위별 당첨 티켓의 수 정보를 제공함.

* RateOfRetrun
    * 수익률을 바탕으로 적자인지 흑자인지를 판단함

* LotteryRank
    * 로또의 각 등수별 상금 정보와 필요한 당첨 숫자 개수를 정의
    * 당첨 갯수를 받아 해당 등수의 상금 합계를 제공함

### View

* InputView
* OutputView
* ViewMessages

### Main
