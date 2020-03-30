# 로또

## DTO

### LottoNumber.class

- 6개의 숫자를 가진 일급 컬렉션

#### 1. List<Intger> getNumbers 

- 로또넘버 getter

### LottoWinningNumber.class

- LottoNumber 를 상속하고 보너스 넘버를 추가로 갖고 있는 dto
 
### LottoResult.class

#### 1. Map<LottoRank,Integer> getWinningMap();

- 로또Rank 라는 당첨 확인인 맵으로 된 통계를 보내줌.

#### 2. double getYield(); 

- 수익률 리턴.
 

## Business

### LottoNumberBuyer.class

#### 1. List<LottoNumber> buyLottoNumbers(int money);

- 돈을 입력받아 로또 넘버를 받음.

### LottoCheckerClass

#### 1. Constructor(LottoWinningNumber winningNumber);

- 생성자 (당첨번호 입력 받음)

#### 2. LottoResult checkWinningStatistics(LottoNumber... lottoNumbers);

- 저장된 당첨 번호와 비교해서 LottoResult 라는 DTO 를 뽑아줌
