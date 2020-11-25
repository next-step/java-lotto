# 로또

## 2단계 로또(자동)
### 도메인
* Application - 메인
* Controller
    * LottoController - 게임 컨트롤러
    * StatController - 통계 컨트롤러
* Domain
    * GameInfo - 금액을 입력받고 게임 횟수를 리턴한다.
    * GameRecord - 번호를 입력받고 게임 기록을 리턴한다.
    * Lotto - 게임 정보를 입력받고 게임 기록을 리턴한다.    
    * Machine - 번호를 생성하고 리턴한다.
    * StatInfo - 게임 기록과 당첨 번호를 입력받고 리턴한다.
    * Statistic - 게임 기록 정보를 입력받고 통계를 리턴한다.
    * StatRecord - 등수와 수익률을 관리한다.
    * Win - 기록과 당첨번호를 입력받고 등수를 리턴한다.
* View
    * InputView - UI
    * ResultView - UI
* Constants
    * Comments
    * Rule
* Messages
    * ExceptionMessages
* Utils
    * CollectionUtils
    * IntUtils
    * StringUtils