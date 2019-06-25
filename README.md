# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

로또 요구 사항 정리

* 1 ~ 45 숫자를 가지고 있는 로또 리스트 생성(로또 기계) 기능 구현
* 6개 번호를 랜덤으로 추출하는 기능 구현
  - Collections.shuffle()를 이용 랜덤으로 섞은 후 앞에서 6개 숫자 추출
* 입력한 지난 주 당첨번호에 따른 당첨 결과 기능 구현
  - ArrayList의 contains()를 사용하여 당첨을 확인 한다.
* 입력한 지난 주 보너스 번호에 대한 2등 당첨 결과 기능 구현
* 당첨에 따른 결과를 반환하는 기능 구현
  - 3개 일치 5000
  - 4개 일치 50000
  - 5개 일치 150000
  - 5개 + 보너스번호 일치 30000000
  - 6개 일치 200000000
* 총 수익률 계산 기능 구현
* 게임 구매 금액 입력 구현
* 당첨 통계 출력 구현