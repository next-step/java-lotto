# 로또

## VO

### LottoNumber.class

 - 6개의 로또 번호로 이루어진 일급 컬렉션

## Business

### LottoNumberBuyer.class

1. List<LottoNumber> buyLottoNumbers(int money);

### LottoCheckerClass

1. Constructor(LottoNumber winningNumber);

2. LottoResult checkWinningStatistics(LottoNumber... lottoNumbers);

## DTO

### LottoResult.class

1. Map<Rank,Integer> getWinningMap();

2. double getYield();

