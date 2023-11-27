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
* [x] Sign의 of()와 calculate() 테스트 분리

#### Feedback 23.11.22
* [x] Sign 구조 개선

---
### 🚀 2단계 - 로또(자동)

#### 기능 요구사항
* [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* [x] 로또 한 장의 가격은 1000원이다.
* [x] 금액을 입력받아 로또를 구매한다.
* [x] 로또 번호는 1부터 45까지이며, 로또 한 세트의 번호는 중복되지 않는다.
* [ ] 지난 주 당첨 번호를 입력받아 당첨 통계

#### Todo
* [x] 6개로 이루어진 로또 set를 로또 갯수만큼 생성한다.
  * [x] 로또 1개를 생성한다.
  * [x] Colletions.sort() 메소드로 정렬
* [ ] 당첨 통계
  * [x] 지난 당첨 로또 생성 
  * [x] 당첨 로또 중 3, 5, 6개 일치 시 당첨으로 간주
  * [x] 등수별 당첨 갯수 반환
  * [x] 총 수익률
    * [x] Lotto 순위 enum 추가
      * [x] 몇 개일 때 당첨인지
      * [x] 당첨금은 얼마인지
    * [x] LottosResult 가 관리하는 것
      * [x] 전체 수익률
      * [x] 등수당 당첨 갯수

#### 프로그래밍 요구사항
* [x] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. (UI 로직 제외)
* [x] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* [x] indent depth는 1까지 허용
* [x] 함수(메소드) 길이가 15라인을 넘어가지 않도록 구현한다.
* [x] else 예약어를 사용하지 않는다.

#### Feedback 23.11.24
* [x] LottoGenerator 테스트를 위한 동작 분리
* [x] Lotto 내 변수의 재사용성 고민
  * [x] 외부에서 주입받은 변수 외 멤버변수 삭제
* [x] Lotto의 생성자 2개 중 테스트를 위한 생성자를 없애기
  * [x] 생성자 방식 변경
* [x] Lotto의 멤버변수 ranking의 위치 고민
  * [x] 삭제
* [x] Lotto의 멤버변수 matchingCount를 쓰지 않기
  * [x] 삭제, 메서드 이용하여 return
* [x] Stream의 generate와 limit 활용
* [x] 수익률 계산 역할의 위치 고민
* [ ] Map.of() 활용
  * [x] Ranking 내 Map 삭제

#### Feedback 23.11.27
* [x] increaseMatchingCount() 구조 변경
* [x] LottoGenerator 의 lottos() 구조 변경
* [x] Stream 표현식을 가독성있게 변경