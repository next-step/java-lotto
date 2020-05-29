# 4단계 - 로또(수동)
## 주어진 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 프로그래밍 요구사항
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
    - 사용자가 잘못된 값을 입력했을 때 java exception으로 에러 처리를 한다.
    - java8에 추가된 Optional을 적용해 NullPointerException이 발생하지 않도록 한다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

## 기능 요구사항 목록 
### # M (Model)
#### Price
: 금액과 관련된 클래스
- [x] 구매 가능한 개수인지 확인할 수 있다. 

#### LottoNumber
: 로또 숫자 범위 내의 숫자 

#### LottoNumbers
: 로또 숫자에 대한 일급 컬렉션 

#### LottoTicket
: LottoNumbers 에 대한 Wrapping 클래스 

#### LottoTickets
: LottoTicket 에 대한 일급 컬렉션
- [x] LottoTicket 의 개수는 반환할 수 있다.
- [x] 인자로 입력받은 LottoTickets를 이어 붙인 LottoTickets를 반환할 수 있다.

#### WinningLottoTicket
: 로또 당첨 번호 
    
#### Prize
: 일치하는 개수에 대한 상금액 (당첨 개수별 상)

#### LottoPrizeResult
: 당첨 개수에 일치하는 티켓의 개수를 관리 

#### LottoSeller
: LottoTickets 를 금액만큼 구매하는 책임 
- [x] PayInfo 가 null 이면 예외를 반환한다.
- [x] 수동으로 입력한 로또 티켓이 구매할 수 있는 티켓의 수보다 많으면 예외 반환
- [x] 지불 정보(PayInfo)가 null 이면 예외를 반환한다.
- [x] 지불 정보에 따라 수동, 자동 티켓을 생성하여 구매 정보(PurchaseInfo) 를 반환한다.

#### LottoNumberGenerator
: 로또 숫자를 랜덤으로 자동 생성하는 책임 

#### LottoGame 
: 구매한 티켓과 로또 당첨 번호로 로또 결과 수행 

#### LottoTicketDTO
: 화면 출력에 필요한 정보에 대한 DTO

#### PayInfo
: 사용자가 입력한 금액과 수동 로또 번호를 관리하는 클래스
- [x] Price 와 수동 로또 번호를 인자로 입력받아 객체를 생성한다. 
- [x] Price 가 null 이면 예외가 발생한다.
- [x] 구입 금액보다 수동으로 구매한 티켓 수가 더 많으면 예외가 발생한다.
- [x] 남은 금액으로 구매할 수 있는 autoTickets 개수를 반환한다.
- [x] 수동 로또 번호 (LottoTickets)를 반환한다.

#### PurchaseInfo
: 사용자가 구매한 수동, 자동 티켓을 관리하는 클래스 
- [x] 사용자가 구매한 수동, 자동 티켓이 null 이면 예외가 발생한다.
- [x] 구매한 manualTickets 개수를 반환한다.
- [x] 구매한 autoTickets 개수를 반환한다.
- [x] 구매한 모든 로또 티켓을 반환한다. 

### # V (View)
#### InputView
- [x] 수동으로 구매할 로또 수를 입력받는다.
- [x] 수동으로 구매할 로또 수 만큼 로또 번호를 입력받는다.

#### ResultView
- [x] 수동, 자동으로 구매한 개수를 출력한다. 
- [x] PurchaseInfo 로 부터 정보를 가져와 출력한다.

### # C (Controller)
#### LottoApplication
- input: 구매 금액 입력
- business logic: 티켓 구매  
- output: 구매 개수 출력
- output: 구매한 티켓 정보 출력 
- input: 지난 주 당첨 번호 입력
- business logic: 당첨 번호에 맞게 통계를 내는 게임 수행 
- output: 통계 결과 출력 

