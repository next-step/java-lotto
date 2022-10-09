## 로또 Step2 기능 요구사항
### Lotto
- [ ] 로또 번호를 저장하는 `List<Integer>`를 갖는 일급 콜렉션
- [ ] `generate(num)` 메소드를 통해 로또 자동 생성 가능
- [ ] 생성할 로또의 최대 번호인 `LOTTO_MAX_NUM` 상수를 갖는다
### LottoWallet
- [ ] `List<Lotto>`를 갖는 일급 콜렉션
- [ ] `generate(num)` 메소드를 통해 새로운 `Lotto`를 생성해 `List`에 추가 가능
### Customer
- [ ] `LottoWallet`를 인스턴스 변수로 보유
- [ ] `buy(cashAmount)` 메소드를 통해 로또 구매 가능
### LottoCompany
- [ ] 로또의 당첨 여부 확인 기능 제공
  - [ ] 지난주 당첨 번호를 입력받아 `Customer의 LottoWallet`과 비교하여 당첨 통계 제공
### InputView
- [ ] 로또 구매 금액 입력 받기
- [ ] 지난 주 당첨 번호 입력 받기
### ResultView
- [ ] 구매한 로또 번호 출력
- [ ] 당첨 통계 출력성
  - [ ] 출력 DTO?