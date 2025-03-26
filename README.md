# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do
### 1단계
- [x] 기본 기능 구현
  - [x] 덧셈 구현
  - [x] 뺄셈 구현
  - [x] 곱셈 구현
  - [x] 나눗셈 구현
- [x] 예외 처리 구현
  - [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 여러 개의 연산 처리 구현
- [x] 계산식 검증 구현
- [x] Views 구현
  - [x] InputView 구현
  - [x] ResultView 구현
### 2단계
- [ ] 핵심 기능 구현
  - [x] 로또 구입 금액에 해당하는 로또 발급
    - [x] 기능 구현
    - [x] 예외 처리 구현
      - [x] 로또 구입 금액이 1000원 단위가 아닌 경우 IllegalArgumentException throw
      - [x] 로또 구입 금액이 0원 이하인 경우 IllegalArgumentException throw
    - [x] 리팩토링
  - [ ] 로또 생성
    - [x] 예외 처리 구현
      - [x] 로또 번호가 6개가 아닌 경우 IllegalArgumentException throw
      - [x] 로또 번호가 1~45 사이의 숫자가 아닌 경우 IllegalArgumentException throw
      - [x] 로또 번호가 중복된 경우 IllegalArgumentException throw
    - [ ] 리팩토링
  - [ ] 지난 주 당첨 번호 입력
  - [ ] 당첨 통계 출력
  - [ ] 수익률 계산
- [ ] Views 구현
  - [ ] InputView 구현
  - [ ] ResultView 구현
- [ ] Controller 구현

