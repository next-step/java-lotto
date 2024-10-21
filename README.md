# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 사칙 연산 계산기 기능 요구사항
- InputView
  - 사용자가 입력한 문자열 값 받아 Tokens 리턴 (ex. 2 + 3 * 4 / 2)
- Tokens
  - 입력값이 없을 경우 IllegalArgumentException throw
  - 연산자가 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
  - 피연산자가 숫자가 아닌 경우 IllegalArgumentException throw
- Token
  - 토큰이 피연산자인지 확인
  - 토큰이 연산자인지 확인
- ResultView
  - 계산 결과를 출력
- CalculatorApp
  - 전체 계산기 실행 수행
- Calculator
  - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행
    - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
    - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정 
    - 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 테스트할 수 있는 단위로 분리하여 구현 
      - ➡️ Calculation 인터페이스를 정의하여 기본 연산 메서드 제공 
      - ➡️ Calculation 인터페이스의 구현체로 Addition, Subtraction, Multiplication, Division 클래스를 작성
        - 나눗셈의 경우 0으로 나눌 경우 IllegalArgumentException throw 
- Operators
  - 사칙연산 기호에 해당하는 Calculation 인터페이스 구현체를 반환

## 로또 기능 요구사항
- InputView
  - 구매금액 입력 받아 LottoTickets 리턴
  - 당첨 번호 입력 받아 당첨 LottoTicket 리턴
  - 보너스 번호 입력 받아 LottoNumber 리턴
- ResultView
  - 구매한 로또 출력
  - 당첨 통계 출력
  - 수익률 출력
- LottoApp
  - 전체 로또 실행 수행
- LottoNumber
  - 로또 번호 생성
    - 1~45 사이의 숫자인지 검증
  - 로또 번호 비교
  - 로또 번호 정렬
- LottoWinningNumbers
  - 당첨 번호 생성
  - 보너스 볼 생성
    - 보너스 볼이 당첨 번호에 포함되는지 확인
  - LottoTicket이 보너스볼 당첨여부 확인
  - LottoTicket이 당첨 번호와 몇개 일치 하는지 확인
- LottoTicket
  - 로또 자동 생성 (Collections.shuffle() 생성, Collections.sort() 정렬)
  - 로또 숫자 리스트 입력 받아 생성
    - 서로 다른 6개의 숫자가 아닐 경우 IllegalArgumentException throw
  - 다른 LottoTicket과 몇개 일치하는지 확인 (ArrayList의 contains() 확인)
  - 일치 개수에 따라 Winning 객체 리턴
    - 보너스볼 당첨여부에 따라 2등/3등 구분
- LottoTickets
  - 구입 금액에 해당하는 로또 발급 (로또 1장의 가격은 1000원)
  - Winning 객체 리스트 WinningCalculator에 전달
- WinningCalculator
  - Winning 객체를 받아 당첨 통계 저장
  - 당첨 금액 저장
  - 수익률 계산
    - 당첨금액 / 구입금액
- Winning
  - 당첨 관련 Enum
    - 3개 일치 5000원
    - 4개 일치 50000원
    - 5개 일치 1500000원
    - 5개 일치, 보너스 볼 일치 30000000원
    - 6개 일치 2000000000원
