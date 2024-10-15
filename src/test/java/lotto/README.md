# 로또(자동)

## Entity 및 TODO 리스트

---

## Entity 및 DONE

### JavaLotto(총괄 컨트롤러)

- UI 로직 포함이라 TDD X

### Lotto (로또 한장)
- 정렬 검증

### LottoNumbers (로또 한장의 번호 리스트)
- 번호 중복 예외 처리 (IllegalArgumentException)
- 범위 밖 번호 예외 처리 (IllegalArgumentException)
- 번호와 당첨 번호 매칭 시 몇 개 맞추었는 지 

### LottoMachine (로또 기계 - 금액 투입 시 로또 리스트 출력)
- 금액 입력 시 로또 리스트 사이즈 검증
- 로또 한 장의 번호 사이즈 검증 

### LottoRandomizer (로또 번호 생성기)
- 랜덤이라 사이즈만 검증

### LottoResult (로또 결과 - 수익률 및 결과 리스트 도메인)


### LottoAnalyzer (로또 결과 분석기 - 로또 리스트와 당첨 번호 매칭 시 각 당첨 별 갯수 반환)
- 등수별 몇개 맞췄는지 검증

### PrizeMoney (Enum 클래스 - 등수 별 몇 개 맞춰야 되고 상금은 얼마인지)
- 맞히지 못했을 시 LOSE 객체 반환
- 당첨 된 것들 검증

### PrizeMoneyCalculator (당첨된 로또 합계 및 수익률 계산 해주는 클래스)
- 등수별 당첨된 리스트의 합계 검증
- 수익률 검증

### Numbers(번호 관련 검증 로직이 있는 추상 클래스)
- 추상 클래스라 tdd 안함 - 상속 받은 객체에서 함

### WinningResult (각 등수 별 몇개 맞추었는지 결과 도메인)
- 등수 당첨 금액과 갯수 곱 금액 검증
- increase 검증
- 같은 PrizeMoney인지 메소드 검증

### WinningText(당첨 번호 String 입력 시 리스트 반환 클래스)
- 범위 초과된 값 입력 시 예외 처리 (IllegalArgumentException)
- 중복 숫자 입력 시 예외 처리 (IllegalArgumentException)
- 리스트 크기 넘어갈 시 예외 처리 (IllegalArgumentException)

### LottoWinningScanner (매칭 시 결과 반환 메소드 - 수익률 및 결과 도출)
- 전체 검증 계산