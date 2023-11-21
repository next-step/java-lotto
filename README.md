# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

--- 
### 🚀 1단계 - 문자열 계산기

#### 기능 요구사항
* [x] 사용자가 입력한 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현한다.
  * [x] 덧셈
  * [x] 뺄셈
  * [x] 곱셈
  * [x] 나눗셈
* [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
* [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
* [x] 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
* [x] 입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
  * [x] Sign 클래스 생성 후 검증

#### 프로그래밍 요구사항
* [x] indent depth는 최대 1단계까지
* [x] 메소드 크기가 최대 10라인 이하(한가지 일만 하도록 한다.)
* [x] else 를 사용하지 않는다.

#### Feedback 23.11.19
* [x] Stack -> Queue 변경
* [x] while -> for 변경
* [x] Sign Enum 구현
* [x] 연산작업에 대한 위치 고민
  * [x] Sign Enum 에게 위임
* [x] Main 클래스 생성

#### Feedback 23.11.21
* 멤버 변수로 정의하면 객체는 상태를 갖게 됨, 멤버변수 선언 지양
* Calculator 내부 메서드 divide 의 이름 고민
* 멤버변수가 아닌 매개 변수로 넘기면서 자연스러운 표현 고민
  * [x] Calculator 클래스 전체 구조 수정
* [x] 사용자 입력 기능 추가
* [x] Sign의 validate 방식 변경
* [ ] 사칙연산 기호 input 시 정상반환 test 추가
* [ ] Sign의 of()와 calculate() 테스트 분리