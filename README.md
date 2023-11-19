# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## 🚀 1단계 - 문자열 계산기

### 구현할 기능 목록
- [X] 덧셈 구현
- [X] 뺄셈 구현
- [X] 곱셈 구현
- [X] 나눗셈 구현
- [X] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [X] 사칙 연산을 모두 포함하는 기능 구현


## 🚀 2단계 - 로또(자동)

### 구현할 기능 목록
- [X] 로또 생성
  - [X] 1~45까지 랜덤 로또번호 생성
  - [X] 중복되지 않는 로또번호 6개를 갖는 로또 생성
- [X] 로또 당첨 확인
  - [X] 일치한 번호 개수 확인
  - [X] 일치한 번호 개수에 따른 당첨금 구하기
    - 3개 일치 : 5000원
    - 4개 일치 : 50000원
    - 5개 일치 : 1500000원
    - 6개 일치 : 2000000000원
- [ ] 수익률 구하기
  - 수익률 : 총 수익 / 로또 구매금액
- [ ] 사용자입력 구현
  - [ ] 구입금액 입력
  - [ ] 지난 주 당첨 번호 입력
- [ ] 결과출력 구현
  - [ ] 당첨 통계 출력
  - [ ] 수익률 출력