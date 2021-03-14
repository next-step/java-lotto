# 문자역 덧셈 계산기
## 기능 요구 사항
* 구분자로 숫자를 분리하여 더한다.
    * 빈문자("") 또는 null은 0으로 취급
    * 기본 구분자는 쉼표와 콜론이다. 커스컴 구분자는  “//”와 “\n” 사이에 위치하는 문자이다.
    * 구분자가 없을시 한숫자로 취급  
    * 숫자이외의 값또는 음수는  RuntimeException 예외를 throw한다.
## 지난 피드백 반영
* if문 convention 규칙

#로또
##기능 요구사항
* 돈가치 만큼 로또티켓을 생성한다.
* 1-45사이에 숫자중 랜덤으로 로또티켓을 생성 또는 입려받은 숫자로 로또 티켓 생성
* 당첨로또티켓과 비교하여 당첨 통계생성(3,4,5,6,개 일치 갯수 및 총 수익률(당첨수익/구입한 모든 로또티켓 금액))
* 당첨로또 객체에 보너스 로또번호 추가  
* 2등은 보너스볼로 판단하는 로직 추가
* LotteryNumber 캐시
