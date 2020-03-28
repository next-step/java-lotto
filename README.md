# 로또
## STEP 1 - 문자열 덧셈 계산기
* 구조 설계
  1. StringAddCalculator
  2. CustomNumber
  3. CustomNumbers
  
* 기능 구현 플로우
  1. 입력 값 검증
       * null 일때 return 0
       * empty 일때 return 0
  1. 입력받은 문자열에서 커스텀 구분자를 확인
     * 있을 시 커스텀 문자열로 split
     * 없을 시 기본 구분자로 split
  3. 문자열 배열(컬렉션)을 0을 포함한 자연수로 파싱
     * 숫자 이외의 값일때 RuntimeException
     * 음수 일때 RuntimeException
  4. 합산

## STEP 2 - 로또 (자동)
* 기능 구현 요구사항
  * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  * 로또 1장의 가격은 1000원이다.

* 기능 구현 플로우
  0. 금액을 입력 받음
  1. 구매자는 로또 발급기에 금액을 지불
  2. 로또 발급기는 로또 금액에 맞게 티켓 수를 계산
  3. 로또 발급기는 티켓 수만큼 생성
  4. 티켓들을 반환
  5. 지난 주 당첨 번호를 입력 받음
  6. 구매자는 당첨 번호에 맞게 당첨 통계를 반환

* 구조 설계
  * Buyer(static)
     * 로또를 사라.
     * 로또 티켓을 보여라.
     * 로또 통계를 계산해라.
  * LottoMachine(static)
     * 로또 티켓을 만들어라
  * LottoTicket
  * LottoNumber
  * LottoPrice(static)
     * 로또 가격을 보여라.