# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 목록 (TODO)

- [  ] 문자열 입력 받기
- [ v ] 파싱 이전 입력값 유효성 검사
  - [ v ] 빈 문자열, 공백으로 구성된 문자열 여부 검사
  - [ v ] 입력된 문자열 숫자와 사칙 연산자, 공백 문자 이외의 문자 여부 검사
- [  ] 입력값 파싱 및 유효성 검사
  - [  ] 입력값 공백 문자 기준으로 분리
  - [ v ] (숫자 연산자 숫자) 피연산자, 연산자 순서 검사
    - [ v ] 맨 처음 항목이 숫자인지 검사
    - [ v ] 숫자나 사칙연산자가 연속되어 입력되지 않았는지 검사 (1 + + or 1 1 +)
  - [ v ] 각 문자열 숫자와 사칙 연산자 사이 빈 공백 검사
- [ v ] 대상 연산 결정
- [  ] 단일 연산
  - [  ] 덧셈
  - [  ] 뺄셈
  - [  ] 곱셈
  - [  ] 나눗셈 - 결과 값을 정수로 한정, 나누는 수 0인 경우 처리
- [  ] 복수 연산 - 입력 순서에 따라 계산 (사칙연산 계산 우선순위 무시)
