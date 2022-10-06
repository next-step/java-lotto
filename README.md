# 로또

## 기능 요구사항

### Domain
- [x] 번호를 입력받아 로또 번호 하나를 생성할 수 있다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 로또 번호는 1 이상 45 이하의 수이다.
- [x] 하나의 로또는 6개의 로또 번호를 가진다.
- [x] 로또 끼리 비교가 가능하고 몇개가 일치하는지 알 수 있다.
- [x] 6개의 번호를 가진 로또를 여러개 생성할 수 있다.
- [x] 6개의 번호를 가진 로또 내 번호는 중복이 없다.
- [x] 6개의 번호를 가진 로또 번호는 오름차순 정렬이다.
- [x] 수익률 계산
  - `당첨금` / `생성한 로또 수` X `로또 1장의 가격(1000원)`
  - 소수 2자리 까지 출력
- [x] 5개가 일치하고 보너스 번호까지 같으면 2등이다.
  - 5개만 일치하는 경우 3등
- [x] 로또가 수동인지 자동인지 구분이 가능하다.

### View
- [x] 구입 금액 입력
- [x] 당첨 번호 입력
- [x] 보너스 번호를 입력한다.
- [x] 구매한 로또 출력
- [x] 당첨 통계 출력
  - [x] 몇개가 맞았는지 출력
  - [x] 수익률 출력
  - [x] 보너스(2등) 정보도 출력한다.
- [x] 수동 생성 숫자, 수동 생성 번호 입력
- [x] 수동, 자동 개수 출력
