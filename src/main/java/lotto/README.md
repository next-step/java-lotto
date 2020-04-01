# 로또

## Domain public 기능 목록

1. PurchasedLottoNumbers LottoBuyer.buyLottoNumbers(long money, List<LottoNumbers> passiveNumbers)
2. LottoResult LottoChecker.getWinningResult(LottoNumbers... applyNumbers)

## DTO

### LottoNumbers.class

- 6개로 1회당 로또 번호들

### LottoRank.enum

- 로또 몇등 당첨 됐는지 확인.
- hasBonus 및 correctNumberCount, earnedMoney(상금) 을 갖고있다.

### LottoResult.class

- 당첨 통계
- LottoRank 를 map으로 몇개씩 당첨됐는지 갖고있음
- yield (수익률) 도 갖고있음

### PurchasedLottoNumbers.class

- 로또 구매 목록
- LottoNumbers 를 리스트로 들고있음

## Business

### LottoNo.class

- 로또 번호 vo
- 1~45 사이 값인지 valid 체크

#### 1. int getNumber()

### LottoNumber.class

- 로또 번호들의 비즈니스 레이어
- 숫자 6개의 distinct 된 값 인지 valid 체크

#### 1. boolean containsNumber(LottoNo bonusNumber)

- 해당 LottoNo 들고있는지 체크

#### 2. int countContainsNumbers(LottoNumber lottoNumber)

- 같은 번호들 끼리 비교하여 몇개나 일치하는지 확인

### LottoWinningNumber.class

- LottoNumber 와 bonus LottoNo를 들고 있는 비즈니스 레이어
- 보너스넘버 가 당첨번호랑 겹치지 않는지 valid 체크

#### 1.LottoRank matchLottoNumber(LottoNumber drawNumber)

- LottoNumber 를 받아 몇등인지 리턴

### LottoChecker.class

- 로또 당첨을 확인 하는 체킹 서비스 클래스

#### 1. Constructor(LottoNumbers wonNumbers, int wonBonusNumber, long spentMoney))

- 생성자 (당첨번호, 보너스번호, 사용한 돈)

#### 2. LottoResult getWinningResult(List<LottoNumbers> applyNumbers);

- 저장된 당첨 번호와 비교해서 LottoResult 라는 DTO 를 뽑아줌

### LottoMachineAuto.class

- 로또 발권 자동 기계

#### 1. List<LottoNumber> ticketingLottoNumber(int count)

- 자동으로 발권된 LottoNumber 리스트 뽑아줌.

### LottoMachineAuto.class

- 로또 발권 수동 기계

#### 1. List<LottoNumber> ticketingLottoNumber(List<LottoNumbers> passiveNumbers)

- 수동으로 발권해줌. (사실 유효성 검사만 진행하고 리턴하는 형식, LottoNumber 를 통해)

### LottoBuyer.class

- 로또를 구매하기 위해 돈을 계산하고 machine 들로부터 발권된 로또를 view 까지 주는 서비스 레이어

#### 1.PurchasedLottoNumbers buyLottoNumbers(long money, List<LottoNumbers> passiveNumbers);

- 돈, 수동 번호들을 입력받아 구매 한 로또들 dto 를 받음.