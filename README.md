# 로또
## 관심사 별로 분리
### 로또 input
- 1장의 가격 1000원
- 전체 금액 input parameter
- input 금액 / parameter ⇒ ticket수 output
- String으로 받아서 숫자가 아니면 exception

### 로또 한장
- random한 숫자 6개를 생성
- List로 random한 숫자들을 가지고 있음
- random한 숫자를 생성하는건 randoomGenerator에서 6개를 받게끔 구성

### 로또 번호 생성기
- 겹치지않은 6개의 lotto번호 추출

### 로또 리스트
- 로또 한장 리스트

### 당첨 번호
- input 6자리

### 당첨 기준을 가지는 객체
- 3개 일치 , 5000
- 4개 일치 , 50000
- 5개 일치 , 1500000
- 6개 일치 , 2000000000

### 당첨 통계를 담당하는 score board
- Lotto 여러장과 WinningLotto
- Lotto 여러장과 WinningLotto를 당첨 기준을 가지는 객체를 통해 비교
- 총 수익률 계산 (Winning Lotto와 Lotto 여러장을 가지고 비교)

