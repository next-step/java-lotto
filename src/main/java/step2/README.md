# Step2 
### 기능 요구 사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 힌트
* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### Model
* Payment
    * [x] Payment 는 외부에서 받는 금액을 가지고 있다.
    
* LottoStore
    * [x] LottoStore 는 LottoTicket 를 판매한다.
    
* LottoTicket
    * [x] LottoTicket 은 LottoNumber 를 가지고 있다.
    
* LottoNumber
    * [x] LottoNumber 는 숫자 타입이다.
    * [] LottoNumber 는 1 ~ 45 까지의 숫자를 가질 수 있다.
        
* PurchasedLottoTicket
    * [x] PurchasedLottoTicket 은 Payment 를 통해 LottoStore 에서 구매가 가능하다. 

* PurchasedLottoTickets
    * [x] PurchasedLottoTickets 은 일급 컬렉션이다.
    
* WinningLottoTicket

* LottoResult

* LottoResults

### Utils
* AutomaticLottoGenerator
    * [x] AutomaticLottoGenerator 은 1 ~ 45 까지 LottoNumber 를 만든다.
    * [x] Shuffling 하여 값을 준비한다.
    * [x] 6 개의 LottoNumber 를 만든다. 

### View
* InputView

* OutputView