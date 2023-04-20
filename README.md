# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

## 구현 목록
- [ ] 문자열 입력
- [ ] 공백 기준으로 연산자와 피연산자를 구분한다
- [ ] 기능을 모두 포함한다
    - [ ] 덧셈
    - [ ] 뺄셈
    - [ ] 곱셈
    - [ ] 나눗셈
- [ ] 아래 유효하지 않은 경우들이 발생하지 않을 경우 예외를 던진다
    - [ ] 입력 값이 null이거나 빈 공백 문자일 경우
    - [ ] 사칙연산 기호가 아닌 경우
    - [ ] 연산자 자리에 피연산자가 들어가는 경우 
    - [ ] 피연산자 자리에 연산자가 들어가는 경우

## 구현 객체 및 책임

### domain 패키지
- OperatorGroup
  - InputView 로 부터 전달받은 컬렉션에서 연산자를 추출한다
  - StringCalculator 로 부터 연산자 요청이 오면 OperatorOffset 로 부터  Offset 위치에 해당하는 Operator를 반환한다.
- OperatorGroupOffset
  - Operator가 어디까지 연산자를 제공했는지 offset 위치를 기록한다
- Operand
  - InputView 로 부터 전달받은 컬렉션에서 피연산자를 추출한다
  - 피연산자가 정수가 아니면 예외를 던진다.
- Operator
  - 연산자 목록 관리 및 연산자 별로 수식을 관리한다
  - 연산 요청이 오면 계산한다
  - OperatorGroup로 부터 연산자를 가져오는 요청이 올 경우 관리하는 연산자가 아니면 예외를 던진다

### domain.extractor 패키지
- Extractor
  - 피연산자,연산자 분리 인터페이
- OperatorExtractor
  - 연산자를 추출한다
- OperandExtractor
  - 피연산자를 추출한다
## service 패키지
- StringCalculator
  - OperatorGroup과 Operand를 전달 받아 Operator의 메소드를 호출하여 연산한다
### view 패키지
- InputView
   - 사용자로 부터 값을 입력 받는다
   - 사용자로 부터 전달 받은 값을 리스트 불변 컬렉션으로 반환한다.
   - 입력 받은 값이 null or 공백 예외를 체크한다

- OutPutView
  - StringCalculator의 결과 값을 출력한다
  
### common.error 패키지
- ErrorMessage
  - 각종 예외를 관리한다

