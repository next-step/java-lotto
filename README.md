# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능목록
* 로또 구입금액 입력
  * 로또 한장 발급
  * 로또 한장의 가격은 1000원
  * 구입금액만큼 발급
* 로또 생성
  * 6개의 랜덤숫자 생성
* 당첨번호 입력
  * 컴마로 구분하여 6자리 입력
  * 보너스 번호 추가 입력
* 당첨 찾기
  * 당첨번호와 일치하는 번호 개수 찾기
  * 3,4,5,6개 일치 찾기
  * 수익률 계산
  * 2등(보너스볼) 일치 찾기
* 출력
  * 생성한 로또 출력
  * 당첨 통계 출력