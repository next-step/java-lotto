# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 학습 목표

### 경험해야할 학습 목표

- TDD 기반으로 프로그래밍하는 경험
- 메소드 분리 + 클래스를 분리하는 리팩토링 경험
- 점진적으로 리팩토링하는 경험

### 경험할 객체지향 생활 체조 원칙

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.

## 1단계

### 기능 요구사항 

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 구현할 기능

- [x] 지정된 구분자(',', ':') 를 가지는 문자열이 입력되면, 적절하게 분리한다.
- [x] 커스텀 구분자("//", "\n" 사이의 문자) 를 추출한다.
- [x] 빈 문자열, Null 이 입력되면 0을 반환한다.
- [x] 숫자 이외의 값, 음수는 예외 처리한다(`RuntimeException`).
- [x] 숫자를 분리한 후에는 합을 계산한 뒤 반환한다.

## 2단계

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- 이하 내용은 자동차 경주 미션과 유사

### 구현할 기능

- 입력
  - [x] 사용할 금액을 입력받는다.
  - [x] 당첨 번호를 입력받는다. 각 번호는 쉼표(',')로 구분한다.
  - [x] 대화형 입력
- 출력
  - [x] 발급된 로또를 한 줄 씩 출력한다.
    - [x] 형식은 대괄호 안에 번호를 쉼표로 구분하여 출력한다.
  - [x] 당첨 통계를 출력한다.
  - [x] 구입 금액 대비 당첨 금액을 비교하여 총 수익률을 출력한다.
- 로또
  - [x] 금액만큼 로또 번호를 임의로 생성한다.
  - [x] 입력된 당첨 번호를 발급된 로또 번호와 비교한다.
  - [x] 비교 후, 통계를 생성한다.

## 3단계

### 2단계에서 미비했던 점

- 로또 클래스의 검증 기능의 부재

### 기능 요구사항

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 구현할 기능

- 입력
  - [x] 보너스 번호를 입력받는다.
- 로또
  - [x] 보너스 번호를 포함한 수상 알고리즘 구현
  - [x] 로또 클래스 검증 기능 추가
- 출력
  - [x] 5개 + 보너스 볼이 일치하는 경우도 출력
  
