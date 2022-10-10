## 로또 Step2 기능 요구사항
### Lotto
- [x] 로또 번호를 저장하는 `List<Integer>`를 갖는 일급 콜렉션
- [x] `generate()` 메소드를 통해 로또 자동 생성 가능
  - 생성된 로또 번호는 오름차순 정렬해 보관
- [x] 로또의 최대 번호인 `LOTTO_NUM_MAX` 상수를 갖는다
- [x] 하나의 로또가 갖는 번호의 개수인 `LOTTO_NUM_COUNT` 를 갖는다
- [ ] 주어진 `List<Integer>` 과 가지고 있는 `List<Integer>`이 일치하는지 확인하는 메서드 `islottoNumbersEqual()` 메소드를 갖는다
- [x] 직접 리스트를 주입할 수 있는 생성자 지원
### LottoWallet
- [x] `List<Lotto>`를 갖는 일급 콜렉션
- [x] `generateLotto(count)` 메소드를 통해 새로운 `Lotto`를 생성해 `List`에 추가 가능
- [x] 직접 리스트를 주입할 수 있는 생성자 지원
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