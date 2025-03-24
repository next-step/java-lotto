# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## TODO
### 1단계 - 문자열 계산기
- [X] 사용자로부터 입력값 받기 
  - [X] 숫자와 사칙연산 사이에는 빈 공백 문자열
  - [X] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [ ] 덧셈
- [ ] 뺄셈
- [ ] 곱셈
- [ ] 나눗셈 (나눗셈의 경우 결과 값을 정수로 떨이지는 값을 한정)