# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### Step 1 문자열 계산기
* 사칙연산 구현
  * 덧셈
  * 뺄셈
  * 나눗셈
  * 곱셈

* 연산식 문자열 Array 나누기 (Splitter) 

### 로또 (자동/수동)
* View
  * InputView
    * 로또 구입 금액 입력
    * 수동 로또 구입 개수 입력
    * 수동 로또 입력
    * 지난 주 당첨 번호 입력
    * 보너스 볼 입력
  * ResultView
    * 구매한 로또(자동/수동) 출력
    * 구매한 로또 당첨 현황 출력
    * 로또 구입 금액 대비 효율 출력
    * Matched enum에 따른 보너스볼 일치 문구 출력
* Domain
  * Draw
    * Variables 
      * Lottos (Class)
      * Winnings (Class)
      * 구매한 로또 개수
    * Functions
      * 로또 생성(자동/수동) 요청
      * 로또 당첨 확인
  * Lottos
    * Variables
      * List<Lotto>
    * Functions
      * List에 Lotto 추가
      * Lottos getter
  * Lotto
    * Variables
      * 로또
    * Functions
      * 로또 자동 생성
      * 로또 수동 생성
      * 로또 번호 존재 확인
      * Lotto getter
      * parseStringArrayToLotto
      * parseIntegerArrayToLotto
  * Winnings
    * Variables
      * WinningNumbers (Class)
      * 당첨 금액(5가지)
      * 당첨된 번호 개수 현황(List)
      * 당첨 개수별 상금
    * Functions
      * 당첨된 번호 개수 Array에 저장
      * 총 당첨금액 계산
      * 당첨번호 파싱
  * WinningNumbers
    * Variables
      * 당첨 번호
      * 보너스 번호
    * Functions
      * parseStringArrayToLotto
      * parseIntegerListToLotto
  * Matched
    * Variables
      * 당첨된 번호 개수 enums
    * Functions
      * 당청된 번호 개수에 따른 enum 리턴
  * RecordMatched
    * Variables
      * 당첨된 번호 개수별 로또 현황(Array)
    * Functions
      * 당첨된 번호 개수별 로또 카운트
  * LottoNumbers
    * Variables
      * 로또 번호
* Exceptions
  * DuplicatedNumbersException: 중복 로또 번호 Exception
  * InvalidLottoByHandLengthException: 로또 번호 6개 아님 Exception
  * InvalidLottoNumberException: 로또 번호 1~45 사이 아님 Exception
* Util
  * Ratio
    * Functions
      * 로또 구입 금액 대비 효율 계산