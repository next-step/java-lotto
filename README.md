# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 기능 요구사항
- 사칙연산 수행하는 계산기 구현
    - 덧셈
    - 뺄셈
    - 곱셈
    - 나눗셈
- 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 사칙 연산 기호가 아닌 경우 IllegalArgumentException throw

### 피드백 사항
- [x] 프로세스가 시작하는 클래스를 따로 만들기
- [x] DELIMITER를 상수로 빼기
- [x] tokenCount 사용하지 않고 operator / operand 나누기
- [x] 사용 가능한 기호를 Enum으로 Convert / 추상화하기

# 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.