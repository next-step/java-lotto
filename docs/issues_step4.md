# Issues
## 3단계 리팩토링
### LottoGenerator 정렬 책임 분리
- LottoNumber 에 CompareTo 추가하고 LottoFormatter 에서 정렬
### LottoGenerator 필드 변경
- minNumber, maxNumber 제거하고 번호 생성용 리스트를 필드로 캐싱
### Lotto 정적 팩토리 메소드 추가
- 기존 코드에서 Lotto(LottoGenerator) 생성자에서 LottoNumbers 에 대한 검증을 하지 않음 
  - LottoNumbers 에 대한 새로운 생성자를 만들고 검증을 하도록 변경
## 로또 번호 수동 입력
### LottoContainer 합치기
- LottoContainer 는 이미 List<Lotto> 를 입력으로 받는 생성자를 보유
- Lotto 는 List<Integer> 를 입력으로 받는 생성자를 보유
- 수동 입력을 받아서 로또를 생성하고 자동/수동 LottoContainer 를 하나로 합침
### LottoCount 역할
- 구매 금액에 해당하는 로또 개수를 의미
- 수동 로또 개수를 추가로 받아 generateLottoContainer 는 수동 로또 개수를 제외한 수의 로또를 생성
### LottoCount 리팩터링
- purchasedAmount 필드는 getWinningRate 에서만 사용
- purchasedAmount 필드를 분리
  - getWinningRate 메소드 가져감
### 수동 로또 입력은 어떤 형태로 받아야 하는가?
- View
  - List<Integer> 형태의 입력을 받아서 Lotto 생성
  - List<Lotto> 를 이용하여 LottoContainer 생성
  - LottoContainer 크기가 manualLottoCount 와 같은지 검증 
    - 어디서? 반드시 필요한가? 테스트만 하면 되지 않을까?
  - manualLottoCount 가 전체 로또 개수보다 작거나 같은지 검증 
    - 입력값 검증은 View 에서 해도 됨