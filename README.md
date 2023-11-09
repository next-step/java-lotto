## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

```plaintext
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



## 기능 목록

- [ ] 로또 번호 생성기
  - [x] 1 부터 45까지의 번호가 생성 가능하다
  - [x] 생성된 번호를 기준으로 무작위로 6개 추출이 가능하다
  - [ ] 추출된 번호를 오름차순으로 정렬해 리턴한다
- [ ] 로또 번호
  - [ ] 6개의 숫자 형식이다
  - [ ] 중복된 번호가 없어야 한다
- [ ] 등수
  - [ ] 일치하는 갯수에 따라 등수가 정해진다
  - [ ] 등수에 따라 상금이 정해진다
- [ ] 당첨 로또 번호
  - [ ] 생성된 로또 번호들로 당첨 랭크를 받을 수 있다
- [ ] 로또 판매기
  - [ ] 1000단위로 금액을 넣을 수 있다
  - [ ] 1000단위로 로또를 구매 할 수 있다
- [ ] 로또 결과
  - [ ] 당첨번호와 생성된 번호로 결과를 낼 수 있다
  - [ ] 수익률을 알 수 있다
- [ ] 수익률
  - [ ] 수익률을 알 수 있다
  - [ ] 이득 여부를 알 수 있다
