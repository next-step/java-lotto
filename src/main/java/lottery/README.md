## 로또 기능 구현 목록

* 로또 구매 금액 입력 (System.in)
    * PurchasePrice(DTO)
    * 양의 정수가 아닐 경우 예외 처리
    
* 입력 로또 구매 금액 / 로또 가격(1000) 으로 로또 티켓 개수 산출
    * 산출된 로또 티켓 개수 및 각 티켓의 번호들 출력 (System.out)
    * LotteryMachine 객체를 PurchasePrice를 받아 생성
        * 로또 티켓 가격보다 낮은 경우 예외 처리
    * 객체 내부에서 로또 티켓 개수 산출, 해당 개수만큼 로또 생성
    * 요청에 따라 View에서 요구하는 데이터를 getter
