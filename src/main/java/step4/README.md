# 로또 (수동)
## 기능 요구사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## 힌트
* 규칙 3: 모든 원시값과 문자열을 포장한다.
    * 로또 숫자 하나는 int 타입이다. 이 숫자 하나를 추상화한 LottoNo 객체를 추가해 구현한다.
* 예외 처리를 통해 에러가 발생하지 않도록 한다.
    * 사용자가 잘못된 값을 입력했을 때 java exception 으로 에러 처리를 한다.
    * java8에 추가된 Optional 을 적용해 NullPointerException 이 발생하지 않도록 한다.

## 구현해야 하는 기능
1. 수동 구매 로또 수 입력 기능
2. 수동 구매 로또 수 만큼 번호 입력 기능
3. 로또의 수동/자동 구매 수를 계산하는 기능

## 테스트 케이스
1. 수동 구매 로또 수 입력 테스트
    - 구입금액 만큼만 로또 수를 살 수 있어야 한다.
    - 0보다 낮은 수는 구매할 수 없다.
2. 수동 구매 로또 번호 입력 테스트
    - 0개를 입력하면 번호입력은 생략되어야 한다.
    - 수동 구매 로또 수 만큼만 번호를 입력할 수 있어야 한다.
3. 로또의 수동/자동 구매 수 테스트
    - 금액전부를 수동으로 사면 자동구매는 생략되야 한다.
    - 수동 구매 장수만큼을 제외한 만큼만 자동으로 구매해야 한다.

## 구조(tree)
```
├── main
|  └── java
|     └── step4
|        ├── Constant.java
|        ├── controller
|        |  └── LottoController.java
|        ├── domain
|        |  └── lotto
|        |     ├── dto
|        |     |  └── LottoPurchaseInfoDTO.java //로또 구매 정보 DTO
|        |     ├── firstcollection
|        |     |  ├── LottoNumber.java
|        |     |  ├── LottoTickets.java
|        |     |  ├── MarkingNumbers.java
|        |     |  └── WinningResults.java
|        |     ├── LottoTicket.java
|        |     ├── LottoTicketMachine.java
|        |     └── WinningNumbers.java
|        ├── Main.java
|        ├── README.md
|        ├── strategy
|        |  ├── LottoNumberMakeStrategy.java
|        |  └── NumberMakeStrategy.java
|        ├── type
|        |  └── WinningType.java
|        └── view
|           ├── InputView.java
|           ├── LottoInputView.java
|           ├── LottoResultView.java
|           └── ResultView.java
├── package-lock.json
└── test
   └── java
      └── step4
         └── ManualLottoTest.java

```

