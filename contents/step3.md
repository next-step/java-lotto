# 3단계 - 로또 (2등)
## 주어진 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- 일급 콜렉션을 쓴다.
    - 6개의 숫자 값을 가지는 java collection을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 
    - 자바의 enum을 활용해 상수 값을 제거한다. 즉, enum을 활용해 일치하는 수를 로또 등수로 변경해 본다.

## 기능 요구사항 목록 
### # M (Model)
#### Price
: 금액과 관련된 클래스

#### LottoNumber
: 로또 숫자 범위 내의 숫자 

#### LottoNumbers
: 로또 숫자에 대한 일급 컬렉션 
- [x] Set<LottoNumber>의 값을 List<Integer> 로 구할 수 있다. 

#### LottoTicket
: LottoNumbers 에 대한 Wrapping 클래스 
- [x] LottoNumbers 의 값을 List<Integer> 로 구할 수 있다. 
- [x] 당첨 번호와 보너스 볼에 맞는 Prize 를 반환한다.

#### LottoTickets
: LottoTicket 에 대한 일급 컬렉션

#### WinningLottoTicket
: 로또 당첨 번호 
- [x] 당첨 번호와 보너스 볼을 지정할 수 있다.
- [x] 보너스 볼은 기존의 당첨 번호와 중복될 수 없다.
    
#### Prize
: 일치하는 개수에 대한 상금액 (당첨 개수별 상)
- [x] 5개가 일치하고 보너스 볼이 포함되어 있으면 2등을 반환한다.

#### LottoPrizeResult
: 당첨 개수에 일치하는 티켓의 개수를 관리 

#### LottoSeller
: LottoTickets 를 금액만큼 구매하는 책임 

#### LottoNumberGenerator
: 로또 숫자를 랜덤으로 자동 생성하는 책임 

#### LottoGame (테스트 코드 어떻게?)
: 구매한 티켓과 로또 당첨 번호로 로또 결과 수행 

#### LottoTicketDTO
: 화면 출력에 필요한 정보에 대한 DTO

### # V (View)
#### InputView
- [x] 보너스 볼을 입력받는다.

#### ResultView
- [x] 당첨 통계에 2등도 추가한다. 

### # C (Controller)
#### LottoApplication
- input: 구매 금액 입력
- business logic: 티켓 구매  
- output: 구매 개수 출력
- output: 구매한 티켓 정보 출력 
- input: 지난 주 당첨 번호 입력
- business logic: 당첨 번호에 맞게 통계를 내는 게임 수행 
- output: 통계 결과 출력 

