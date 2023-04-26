# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 요구사항
- [ ] 사용자로부터 식을 입력받는다
- [ ] 주어진 문자열을 공백 단위로 파싱한다
- [ ] 주어진 문자열에 대한 사칙연산을 수행한다
  - [ ] 나눗셈 결과는 정수로 떨어진다
  - [ ] 입력값의 순서에 따라 결정된 순서로 사칙연산을 수행한다( 사칙연산 우선순위를 무시한다 )

## 프로그래밍 요구사항
- indent 의 depth 를 1단계로 줄일 것 (while + if -> 2단계)
- 메서드 크기가 최대 10라인을 넘지 않을 것 
- else 사용하지 말 것

## AssertJ 힌트
- 자주 발생하는 Exception 의 경우 별도의 Exception 메서드를 제공하고 있다. 
  - IllegalArgument
  - IllegalState
  - IO
  - NPE
- 앞에서 사용했던 ParameterizedTest 와 ValueSource 사용 고려
