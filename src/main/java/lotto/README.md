# 로또(자동)

## 로또 기능 요약
* 로또 구입 금액을 입력받아서 구입 금액 만큼 로또 번호를 출력한다.
* 지난주 당첨 번호를 입력 받아서 출력한 로또 번호의 당첨 통계를 보여준다.

## 상세 기능
### Lotto
* 범위가 1-45이고, 중복이 없는, 오름차순 정렬된 임의의 여섯 자리 숫자 리스트
    * List<Integer> numbers
    * numbers(): List<Integer>
    
### LottoStore
* 입력받은 구매금액만큼 로또를 발행한다
    * issue(String amount): List<Lotto>

### WinningType
* 당첨금액, 일치번호 개수 정보를 가지고 있는 이넘 클래스 
    * int matchedCount
    * int winnings

### WinningStatistics
* 발행한 로또 리스트와 당첨번호를 입력 받아 당첨 통계 생성한다
    * Map<WinningType, Integer> winningLogs
    * getWinningLogs(): Map<WinningType, Integer>
    * getReturnOnInvestment(): double
    
### InputView 
* 로또 구입 금액을 커맨드라인으로 입력 받는다
    * getLottoPurchaseAmount(): String
* 지난주 당첨 번호를 커맨드라인으로 입력받는다
    * getLastWeekWinningNumber: String
    
### ResultView
* 구매한 로또 개수와 로또 번호 출력한다
    * printLottoPurchased(List<Lotto>): void
* 당첨 통계를 출력한다
    * printWinningStatistics(WinningStatistics): void
    
  
