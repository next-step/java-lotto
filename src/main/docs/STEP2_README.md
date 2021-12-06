2단계 - 로또(자동)
---

### 기능 요구사항
- 로또 구입 금액을 입력하면 구매된 갯수를 출력한다.
- 구입 금액에 해당하는 로또 묶음을 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 발급된 로또는 오른차순으로 정렬하여 출력한다.
- 지난 주 당첨 번호 6개를 입력한다. (, )
- 3, 4, 5, 6개에 해당하는 당첨 통계를 출력한다.
- 구매한 가격 대비 당첨된 금액을 계산하여 총 수익률을 출력한다.



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

### 1차 리뷰 
- if 띄어쓰기, for문 띄어쓰기
- 사용자 예외 클래스 세분화
- 좀 더 작은 단위부터 큰단위로 설계
- commit은 더 자주하기
- README.me 상세하게 작성하기
- 상수와 인스턴스 변수 간에 공백 추가하기
- 메서드명을 좀 더 적절하게 작성하기

