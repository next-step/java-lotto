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

### Step 2 로또 (자동)
* View
  * InputView
    * 로또 구입 금액 입력
    * 지난 주 당첨 번호 입력
  * ResultView
    * 구매한 로또 출력
* Domain
  * Draw
    * Variables 
      * 구매한 로또 개수
      * 구입한 로또 
      * 구입한 로또의 당첨 현황
    * Functions
      * 로또 생성 요청
  * Lotto
    * Variables
      * 로또
    * Functions
      * 로또 생성
  * Winnings
    * Variables
      * 당첨 번호
      * 당첨된 번호 개수 현황(List)
      * 당첨 개수별 상금
    * Functions
      * 당첨된 번호 개수 확인
      * 당첨된 번호 개수별 로또 개수