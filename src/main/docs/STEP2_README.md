2단계 - 로또(자동)
---

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.


### 설계
- view
    - InputView
    - ResultView
- service
    - LottoService
- dto
    - RandomNumber
    - MyNumber
    - LottoTicket
    - LottoTicketGroup
- exception
    - InvalidNumberException
- main (Controller 처럼 사용)


### 확인 사항
- if 띄어쓰기
- 매직리터럴
- 복잡한 설계 X
- test code case 너무 적지않도록 작성
- 일급 컬렉션, 불변 객체
- 비즈니스 계층은 stateless하게 작성



