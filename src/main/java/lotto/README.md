## 구현사항

---

### Domains
- LottoNumber
  - 로또 숫자의 범위는 1~45 까지이다.
- Lotto
  - 자신이 몇 등인지 알 수 있다.
- Prize
  - Enum 객체로 등수정보와 상금정보를 가지고 있다.
- LottoGenerator
  - 숫자 6개를 중복없이 오름차순으로 생성할 수 있다.
- LottoStatistics
  - 로또 숫자와 지난주 당첨번호를 가지고 통계를 낼 수 있다.
### UI
- InputView
  - 구매금액과 지난 주 당첨 번호를 입력 받을 수 있다.
- ResultView
  - LottoStatistics 를 출력해준다.. 
