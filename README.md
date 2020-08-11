# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP01 문자열 덧셈 계산기
### 기능 요구사항
- [ ] ',' ':' 로 구분된 숫자 문자열을 받아 숫자들의 합을 구한다. ex) 1;2;3 -> 6
- [ ] 커스텀 구분자 사용 가능하다 '//'와 '\n' 사이에 커스텀 구분자 입력가능. ex) //$\n1$2$3 -> 6
- [ ] 빈문자열 or null이 들어오면 return 0
- [ ] 숫자가 들어와야하는 곳에 숫자 이외의 문자가 들어오면 Runtime Exception.
- [ ] 음수가 들어오면 Runtime Exception
- [ ] 숫자가 1개면 그 숫자 return

### 프로그램 구조 구상
- [ ] Main class - psvm이 (main메소드)포함된 전체적인 프로그램을 제어할 클래스
- [ ] StringAddCalculator class - 문자열 덧셈 계산 기능을 가진 클래스
- [ ] InputView & ResultView class - ui 입출력 관련 클래스
- [ ] CalculatorException class (extends RuntimeException) - 문자열 덧셈 계산기를 위한 custom exception 클래스
- [ ] CalculatorExceptionType enum - 에외 종류를 정리할 Enum class
- [ ] PositiveNumberTokens class - 덧셈 계산기의 token들이 담길 일급컬렉션 
 
### TDD - 기능검증이 필요한 메소드 구상
- **PositiveNumberExpr class**
- [ ] boolean isEmpty(String expression) -> 0 또는 Null 이면 false / 그 외 true
- [ ] boolean isContainCustomDelimiter(String expression)  -> 커스텀 delimiter가 포함된 식이면 true / 그 외 false
- [ ] void validatePositiveNumber(List<String> tokenList) -> list에 양수가 아닌 문자열이 포함되어 있으면 Throw RuntimeException
- **StringAddCalculator class**     
- [ ] int calculate(List<String> tokenList) -> list에 들어있는 숫자들의 합을 반환
- **InputView class**
- [ ] PositiveNumberTokens makeTokens(String input) -> 사용자 입력을 받아 PositiveNumberTokens를 만들어 반환

