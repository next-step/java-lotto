# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항

### 문자열 계산기

- [X] **문자열을 입력**받는다. --> `Calculator#calculate`
- [X] **식을 검증하다**. --> 검증 : `Calculator#validateExpression`
  - [X] **`,`, `:`은 기본 구분자**이다.
  - [X] 기본 구분자 이외에 `//`와 `\n` 사이에 사용자 임의의 구분자를 설정할 수 있다.
    - [X] 이 때 숫자는 들어올 수 없다.
  - [X] 구분자를 기준으로 *Operand*를 파싱한다.
  - [X] `빈 문자열` 같은 경우에는 `0`이 반환한다.
  - [X] `0, 양수` 이외에는 `RuntimeException`을 throw 한다.
- [X] **구분자로 나눈다**. --> 분할 : `Tokenizer#splitExpression`
- [X] 계산 결과를 출력한다.
  - [X] **합**을 계산 --> `Calculator#getSum`

### 로또

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)