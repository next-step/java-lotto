# 로또(자동)

## Entity 및 TODO 리스트

### JavaLotto(총괄 컨트롤러)
- UI 로직 포함이라 TDD X

### WinningNumbers (당첨 번호)
- String으로 당첨자 번호 입력 시 split() 시 중복 검증 - IllegalArgumentException

### Lotto(로또 1장)
- 로또 1장 정렬 검증
- 당첨자 번호와 매치 몇개 맞았는가? 검증

### LottoMachine(로또 기계 - 자동 번호 발급, 당첨 리스트 반환) 
- 금액이 입력되었을 때 1000원으로 나누었을 때 발급된 로또 갯수가 몇 장인가?
- 발급 리스트와 당첨 번호 리스트 입력 시 당첨 리스트 반환 

### Winners(당첨 리스트)
- 당첨 된 로또 리스트 합계 계산

### PrizeMoneyCalculator(상금 계산)
- 구매금액과 총 상금으로 수익률 검증

### Rank (Enum 클래스로 등수, 상금, 맞춰야 될 갯수)
- 갯수로 등수, 금액 검증

---

## DONE
