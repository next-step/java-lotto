# 로또
## 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다

## 힌트
* 일급 콜렉션을 쓴다.
    * 6개의 숫자 값을 가지는 java collection을 감싸는 객체를 추가해 구현해 본다.
* 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 자바의 enum을 활용해 상수 값을 제거한다. 즉, enum을 활용해 일치하는 수를 로또 등수로 변경해 본다.

## 구현해야 하는 기능
1. 보너스 넘버를 포함한 당첨번호 생성자
2. 당첨번호 유효성 검사 기능
    - 0보다 작거나 45보다 커서는 안된다.(기존 LottoNumber isValid 사용)
    - 체크한 넘버와 중복되서는 안된다. 
3. 보너스 당첨 번호 확인 기능
    - 5개가 일치하고 보너스 번호가 일치해야 한다. 

## 테스트 케이스
1.  2등 보너스 볼 당첨 테스트
    - 5개가 일치해도 보너스 번호가 일치하지 않으면 2등
    - 5개가 일치하고 보너스 번호가 일치하면 보너스 볼 당첨
    - 4개가 일치하고 보너스 번호가 일치하면 3등
2. 보너스 번호 중복 테스트
    - 보너스 번호는 마킹된 로또넘버와 중복되서는 안된다.
3. 2등 보너스 당첨 수익률 테스트


## 구조(tree)
```
├── main
|  └── java
|     └── step3
|        ├── Constant.java
|        ├── controller
|        |  └── LottoController.java
|        ├── domain
|        |  ├── lotto
|        |  |  ├── LottoNumber.java
|        |  |  ├── LottoTicket.java
|        |  |  ├── LottoTicketMachine.java
|        |  |  ├── LottoTickets.java
|        |  |  ├── MarkingNumbers.java
|        |  |  └── WinningNumbers.java
|        |  └── model
|        ├── Main.java
|        ├── README.md
|        ├── service
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
└── test
   └── java
      └── step3
         └── LottoBonusNumberTest.java
```

