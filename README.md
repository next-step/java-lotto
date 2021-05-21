# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## Lotto 기능 요구사항

- [ ] 사용자 입력 구현

  - [ ] 사용자 구매 금액 입력
  - [ ] 지난주 당첨 번호 입력

- [ ] 출력 View 구현

  - [ ] 로또 번호 자동생성 결과 출력
  - [ ] 당첨 통계 출력
  - [ ] 수익률 출력

- [x] 사용자 입력금액을 통해 로또 구매 장수를 결정

- [ ] 로또 번호 자동 생성기 구현

  - [ ] 로또번호 추출결과 오름차순 정렬(출력을 위해)

- [x] 사용자 입력인 지난주 당첨번호 입력값을 통해 로또 번호 객체생성

- [ ] 생성된 로또번호와 당첨번호 비교해 맞춘 갯수별로 결과 저장

- [ ] 최종 결과값 계산

- [ ] 수익률 계산

  (당첨금 / 구매금액) * 100

