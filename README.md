# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능목록
### 뮨자열 계산기
- [] 입력값을 공백을 기준으로 토큰을 분리
- [] 분리된 토큰에서 '숫자'와 '사칙연산 부호'을 분리
- [] 순서대로 계산
  - [] 덧셈 계산기
  - [] 뺄셈 계산기
  - [] 곱셈 계산기
  - [] 나눗셈 계산기
- [] 입력값이 null or blank일 때 IllegalArgumentException throw
- [] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
