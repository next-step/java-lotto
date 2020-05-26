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

* 해당 Map을 래핑하는 Statistics 일급 컬렉션 출력

* 수익률을 관장하는 객체 생성
