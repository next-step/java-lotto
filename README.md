# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# STEP1 TODO
# STEP1 DONE
- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행하는 계산기 구현하기
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정하고 처리하기
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값
- [x] 사칙연산 우선순위가 아닌 입력 값 순서에 따라 계산하기
- [x] 들여쓰기는 1단계 유지하기 (중복문 안 조건문 사용 금지)
- [x] 메소드 크기 10라인 이하로 유지하기
- [x] 테스트할 수 있는 단위로 나누어 구현하기
  - [x] 덧셈, 뺼셈, 곱셈, 나눗셈, 입력값이 null이거나 빈 공백문자일 경우 IllegalArgumentException throw -> OperandParse에서 처리
  - [x] 사칙연산 기호가 아닌 경우  IllegalArgumentException throw -> Operator Factory에서 처리 
