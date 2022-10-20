# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 계산기 기능 목록
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 사칙 연산을 모두 포함하는 기능 구현
- [x] 입력 출력

## 로또(자동)
- [x] 로또 생성
  - [x] 1~45사이의 로또번호 생성
  - [x] 중복 없이 6개 번호를 가진 로또 생성
  - [x] 로또 번호 자동 생성기 생성
  - [x] 로또 구입 금액에 따라 로또 여러장 생성
- [x] 통계
  - [x] 일치하는 로또 개수
  - [x] 수익률
- [x] 입력
  - [x] 구입 금액 입력
  - [x] 지난 주 당첨 번호 입력
- [x] 출력
  - [x] 로또 구매 개수
  - [x] 로또 번호
  - [x] 당첨 통계

## 로또(2등)
- [x] 2등을 위해 추가 번호를 하나 더 추첨
- [x] 당첨 통계에 2등도 추가

## 로또(수동)
- [x] 구입 금액에서 수동로또 수만큼 금액 차감
- [] 사용자가 수동으로 추첨 번호를 입력
- [] 금액 차감 후 자동 로또 생성
- [] 수동 로또와 자동 로또 같이 Lottos 생성