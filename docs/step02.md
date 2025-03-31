# step2 로또(자동)

https://edu.nextstep.camp/s/Ie5Dwep0/ls/KH5Q2XXD

## 기능 요구사항

로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다.

```text
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## TODO List

- [ ] LottoEvent 클래스와 LottoTicket 클래스가 있다.
- [ ] LottoTicket은 LottoTicketNumber를 가진다.
- [ ] 로또 상점에서 티켓을 구매 할 Me 클래스가 있다.
- [ ] LottoEvent는 LottoTicket을 발급한다.
- [x] LottoTicket을 발급할 때 마다 LottoTicketNumber를 생성한다.
- [x] LottoTicket을 발급할 때 마다 LottoTicketNumber를 생성할 때 중복이 되지 않아야 한다.
- [x] LottoEvent는 LottoTicket을 발급할 때 마다 LottoTicketNumber를 생성할 때 1~45 사이의 숫자여야 한다.
- [x] LottoTicket을 발급할 때 LottoTicketNumber를 6개씩 발급한다.
- [x] LottoEvent는 LottoTicket을 발급할 때 LottoTicketNumber를 오름차순으로 정렬한다.
- [ ] LottoEvent는 LottoTicket을 발급할 때 LottoTicketNumber를 1개씩 발급할 때 마다 Me의 금액을 1000원씩 차감한다.
- [ ] LottoEvent는 지난 주 당첨 번호를 입력 받을 수 있다.
- [ ] Me는 LottoEvent의 지난 주 당첨 번호를 입력 받을 수 있다.
- [ ] Me는 LottoTicket을 구매 할 수 있다.
- [ ] Me는 구매한 LottoTicket 목록을 출력 할 수 있다.
- [ ] Me는 LottoEvent 로 부터 당첨 금액을 받을 수 있다.
- [ ] Me는 당첨 통계 계산할 수 있다.