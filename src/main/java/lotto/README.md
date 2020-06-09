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
    
* LottoTicket (abstract class)
    * [x] LottoTicket 은 LottoNumber 를 가지고 있다.
    
* LottoNumber
    * [x] LottoNumber 는 숫자 타입이다.
    * [x] LottoNumber 는 1 ~ 45 까지의 숫자를 가질 수 있다.
        
* PurchasedLottoTicket
    * [x] PurchasedLottoTicket 은 Payment 를 통해 LottoStore 에서 구매가 가능하다. 

* PurchasedLottoTickets
    * [x] PurchasedLottoTickets 은 일급 컬렉션이다.
    * [x] PurchasedLottoTickets 입력 받은 WinningLottoTicket 과 LottoNumber 를 match 하는 기능을 가지고 있다.
    
* WinningLottoTicket
    * [x] WinningLottoTicket 는 지난 주 당첨 Number 를 가지고 있다.

* LottoMatchCount
    * [x] LottoMatchCount 는 Integer 를 Wrapping 한 클래스이다.
    
* LottoResult
    * [x] LottoResult 는 맞은 갯수별 상금 금액을 가지고 있다.
     
* LottoResults
    * [x] LottoResults 은 일급 컬렉션이다.

* LottoBonusResult
    * [x] LottoBonusResult 는 보너스 볼과의 Match 상태를 가지고 있다.

### Utils
* AutomaticLottoGenerator
    * [x] AutomaticLottoGenerator 은 1 ~ 45 까지 LottoNumber 를 만든다.
    * [x] Shuffling 하여 값을 준비한다.
    * [x] 6 개의 LottoNumber 를 만든다. 
    
* StringConverter
    * [x] Converter 은 문자열을 받아 List<Integer> 로 변환한다.

### View
* InputView
    * [x] InputView 는 구입 금액을 입력 받는 기능을 수행한다.
    * [x] 지난 주 당첨 번호를 입력받는 기능을 수행한다.
    
* OutputView
    * [x] OutputView 는 LottoNumber 를 출력하는 기능을 수행한다.
    * [x] 당첨 통계를 출력하는 기능을 수행한다.
    * [x] 수익률을 출력하는 기능을 수행한다.
    
## Step3

### 기능 요구 사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 힌트
* 일급 콜렉션을 쓴다.
* 6개의 숫자 값을 가지는 java collection 을 감싸는 객체를 추가해 구현해 본다.
* 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum 을 활용해 상수 값을 제거한다. 즉, enum 을 활용해 일치하는 수를 로또 등수로 변경해 본다.

## Step4

### 기능 요구 사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 힌트
* 규칙 3: 모든 원시값과 문자열을 포장한다.
    * 로또 숫자 하나는 int 타입이다. 이 숫자 하나를 추상화한 LottoNo 객체를 추가해 구현한다.
* 예외 처리를 통해 에러가 발생하지 않도록 한다.
    * 사용자가 잘못된 값을 입력했을 때 java exception 으로 에러 처리를 한다.
    * java8에 추가된 Optional 을 적용해 NullPointerException 이 발생하지 않도록 한다.