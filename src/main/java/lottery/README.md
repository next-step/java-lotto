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
    * 발행한 티켓 그룹과 당첨 번호 티켓을 받아 당첨된 티켓들의 리스트를 반환

* LotteryGameResult
    * 로또 당첨자 명단을 바탕으로 상금 집계, 수익률 등 통계를 제공함
    
    
    * LotteryMachine
    * LotteryNumber
    * LotteryTicket
    * LotteryTicketsGroup
    * LotteryRank (enum)
    * StringParser
    * StatisticsBoard
    * RateOfReturn
    * ErrorMessages

* View
    * InputView
    * OutputView
    * ViewMessages

* Main

## 로또 기능 구현 목록

* 로또 구매 금액 입력 (System.in)
    * PurchasePrice(DTO)
    * 양의 정수가 아닐 경우 예외 처리
    
* 입력 로또 구매 금액 / 로또 가격(1000) 으로 로또 티켓 개수 산출
    * 산출된 로또 티켓 개수 및 각 티켓의 번호들 출력 (System.out)
    * LotteryMachine 객체를 PurchasePrice를 받아 생성
        * 로또 티켓 가격보다 낮은 경우 예외 처리
        
* 산출된 개수만큼 로또 생성
    * LottoTicket은 중복없는 1~45 랜덤 숫자 6개로 이루어짐
    * 해당 숫자들도 LottoNumber로 wrapping
    
* 요청에 따라 View에서 요구하는 데이터를 getter
    * LotteryTicketsGroup에 포함된 티켓들의 번호 리스트
    
* 지난 주 당첨 번호 입력 String을 Parsing하여 LotteryTicket으로 변환

* LotteryMachine에서 당첨 티켓 목록 반환

* Lottery의 랭킹 관련 상수 정의한 Enum 기능

* WinnerTicket 목록을 검사하여 각 등수별 당첨 티켓 개수 Map 정의

* 해당 Map을 래핑하는 StatisticsBoard 일급 컬렉션 출력

* 수익률을 관장하는 RateOfReturn 객체 생성
