## 구조

### Domain

* PurchasePrice
    * 로또 구매 금액과 관련된 클래스
    * 객체 생성시 입력받은 금액과 수동 구매 희망 티켓 개수를 계산하여 금액 부족시 예외 발생
    * 해당 금액으로 구매할 수 있는 로또 티켓의 개수를 반환함

* ManualTicketsNumbersDto
    * 수동 입력한 로또 티켓 번호 문자열들의 리스트(List<String[]>)를 가지고 있는 객체.
   
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
    * 당첨 티켓과 비교해서 그에 맞는 LotteryRank Enum 반환

* LotteryTicketsGroup
    * Lottery Ticket의 List 일급 컬렉션
    * 매개변수로 가격을 받으면 해당 가격으로 살수있는 금액만큼 로또 티켓들을 생성
    * 각 로또 티켓들의 번호 리스트를 집계하여 제공
    * 구매 금액에 맞는 자동 LotteryTicket들을 List에 담아 래핑

* LotteryNumbersGenerator
    * 로또 티켓 1장에 필요한 로또 숫자 6개를 랜덤으로 자동 생성해주는 유틸 클래스
 
* LotteryGame
    * 발행한 티켓 그룹과 당첨 번호 티켓을 받아 게임을 진행함.
    * winner ticket들의 정보를 반환함

* LotteryGameResult
    * 로또 당첨자 명단을 바탕으로 수익률 집계 및 각 순위별 당첨 티켓의 수 정보를 제공함.

* BonusBall
    * 보너스 볼 번호 래핑
    * 보너스 볼 번호와 기존 당첨 번호와의 중복 체크.
    
* RateOfRetrun
    * 수익률을 바탕으로 적자인지 흑자인지를 판단함

* LotteryRank
    * 로또의 각 등수별 상금 정보와 필요한 당첨 숫자 개수를 정의
    * 당첨 갯수를 받아 해당 등수의 상금 합계를 제공함
        * 보너스 볼 포함 여부도 매개변수로 받아 5개 일치할 때 2등 3등 구분

### View

* InputView
    * 구매 금액 입력 기능
    * 지난 주 당첨 번호 입력 기능
    * 보너스 볼 입력 기능
    * 수동 구매 희망 티켓 개수 입력
    * 수동 구매 티켓 번호 입력
* OutputView
* ViewMessages

### Main
