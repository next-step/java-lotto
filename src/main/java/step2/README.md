# 로또
## 기능 요구사항
* 로또 구입 금액을 입력하면 구입금액에 해당하는 로또를 발급해야 한다.
    * 로또 1장의 가격은 1000원이다.

## 힌트
* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 구현해야 하는 기능
1. 입력한 금액에 맞는 로또 구매 횟수 반환 메소드
2. 로또 발급 메소드
    * 번호는 중복되어서는 안된다.
3. 당첨 번호방급 메소드
4. 내 로또번호와 당첨번호 비교 메소드
5. 수익률 계산 메소드

## 구조(tree)
```
├── main
|  └── java
|     └── step2
|        ├── Constant.java //공통 매직넘버 모음 클래스
|        ├── controller
|        |  └── LottoController.java 
|        ├── domain
|        |  └── lotto
|        |     ├── LottoTicket.java //로또 티켓 일급 객체
|        |     ├── LottoTicketMachine.java //로또 발권기 클래스
|        |     ├── LottoTickets.java//로또 티켓 일급 콜렉션
|        |     ├── MarkingNumbers.java//티켓에서 마킹한 숫자 집합 일급 콜렉션
|        |     ├── WinningMatchCount.java //로또번호와 당첨번호 일치율 저장 객체
|        |     └── WinningNumber.java//당첨번호 일급 객체
|        ├── Main.java
|        ├── README.md
|        ├── strategy
|        |  ├── LottoNumberMakeStrategy.java //로또 번호 생성 전략
|        |  └── NumberMakeStrategy.java //번호 생성 전략 인터페이스
|        ├── type
|        |  └── WinningType.java //로또 당첨 순위 타입ENUM
|        ├── view
|        |  ├── InputView.java 
|        |  ├── LottoInputView.java
|        |  ├── LottoResultView.java
|        |  └── ResultView.java
|        └── WinningNumberGenerator.java // 당첨번호 랜덤 생성기
├── package-lock.json
└── test
   └── java
      └── step2
         ├── LottoIssueTest.java
         └── streategy
            └── TestNumberMakeStrategy.java //테스트용 로또 번호 생성기
```
