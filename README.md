# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

------
# STEP 1
## 기능 요구 사항
### TODO
* [X] 사용자 입력 받기
  * [X] 입력값이 비어있을 경우 IllegalArgumentException throw
  * [X] 사칙연산 기호가 아닌 기호가 있는 경우 IllegalArgumentException throw
  * [ ] 사칙연산 기호가 연속해서 있는 경우 IllegalArgumentException throw
  * [X] 사칙연산 기호가 식의 맨 앞이나 뒤에 위치하는 경우 IllegalArgumentException throw
* [X] 기호와 숫자 분리 (빈 공백으로 분리되어 입력됨)
* [X] 사칙연산 계산
  * [X] 덧셈
  * [X] 뺄셈
  * [X] 곱셈
  * [X] 나눗셈
  * [X] 하나의 항 계산
  * [ ] 주어진 식 전체 연산


### 프로그래밍 요구사항
- indent 1단계로 사용
- 메소드 길이 최대 10라인으로 제한
- else 사용 금지