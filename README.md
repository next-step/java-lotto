# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step2
1. 게임 생성 : 구입금액에 따라 게임수 생성, 게임수 만큼 게임 생성
 1) 1개 게임 생성
 2) 1개 게임을 입력한 게임수만큼 반복

2. 당첨 : 생성된 게임과 당첨번호 비교
 1) 당첨번호와 구매한 로또 번호 비교하여 당첨 개수 출력
 2) 결과 값으로 Map 생성

3. 당첨 결과 및 수익률 출력

## step3
1. 게임 생성 : 구입금액에 따라 게임수 생성, 게임수 만큼 게임 생성
 1) 1개 게임 생성
 2) 1개 게임을 입력한 게임수만큼 반복

2. 당첨 : 생성된 게임과 당첨번호 비교
 1) 당첨번호와 구매한 로또 번호 비교하여 당첨 개수 출력
 2) 결과 값으로 Map 생성

3. 당첨 결과 및 수익률 출력

## step 4
1. 랜덤하게 로또 번호를 생성한다. / 숫자를 입력 받아 수동으로 로또 번호도 생성한다.
2. 로또 구입금액을 입력하면 금액에 따라 로또 구매할 수 있는 장수를 반환한다.
3. 구매할 수 있는 장수만큼 로또를 구매한다. (자동)
4. 지난주 당첨번호를 입력한다.
5. 지닌주 보너스 번호를 입력한다 -> 지난주 당첨번호와 같은 클래스로 묶어 사용한다.
6. 지난주 당첨번호와 구매한 로또 번호를 비교하여 등수를 표시한다.  (보너스 번호 추가)
7. 당첨 결과들을 입력하면 당첨금 총액을 반환한다.
8. 당첨결과를 입력하면 수익률을 계산한다.