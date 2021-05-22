# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항 정리
* 랜덤 번호 자동 생성기 기능
  1. 테스트 생략
  2. 오름차순으로 정렬
* 로또 생성 기능
  1. 입력한 가격에 맞게 로또 개수가 생성되는지 확인
  2. 입력한 가격이 음수나 문자인 경우 예외 발생하는지 확인
* 담청 통계 기능
  1. 로또 번호와 담청 번호 비교 및 보상금 확인
  2. 담청 번호에 맞는 로또의 개수, 총 수익금 확인.
  3. 수익률이 맞는지 확인.(수익금/투자금), 수익률은 소수점 2번째까지 나타낸다.
* UI 기능
  1. 테스트 생략