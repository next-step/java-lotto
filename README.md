# 로또

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 기능 구현 목록

### Todo
- WinnigNumber 객체를 생성
- price 객체를 생성
- 테스트 꼼꼼히 작성했는지 점검

### Done
- 로또 번호 생성기가 로또 생성을 하면
  - 6개의 숫자를 반환한다
  - 6개의 숫자는 중복이 되지 않는다
  - 6개의 숫자는 
    - 내가 지정한 숫자가 나온다(테스트 전략)
    - 6개의 숫자는 랜덤한 숫자가 나온다(프로덕션 전략)
- 개수를 입력하면 로또번호 6개가 그 개수만큼 나온다
- 당첨 번호를 입력하면
  - 3개 일치 하는 갯수를 반환 
  - 4개 일치 하는 갯수를 반환
  - 5개 일치 하는 갯수를 반환
  - 6개 일치 하는 갯수를 반환 
- matchTime을 enum 으로 처리(Prize)
- 각종 상수들을 enum 으로 처리(Rule)
- LottoNumber 생성
  - 원시값을 포장한다
  - 1~45 사이의 숫자를 가진다
  - 숫자를 입력하면 LottoNumber를 생성한다
- LottoNumber는 중복이 되지 않는다
