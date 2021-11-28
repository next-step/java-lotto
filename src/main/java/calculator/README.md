# 문자열 덧셈 계산기

## 기능 구현 목록
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    - 빈 문자열 또는 null 값을 입력할 경우 0을 반환
    - 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
    - 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환
    - 구분자를 컴마(,) 이외에 콜론(:)을 사용 가능
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    - “//”와 “\n” 문자 사이에 커스텀 구분자를 지정
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
    - 음수를 전달할 경우 RuntimeException 예외가 발생

## 구현목록
- StringAddCalculator
  - splitAndSum() : 메인 method
  - addStringArray() : String 문자열 합계를 숫자로 반환

- NumberTokens
  - String[] tokens : String 문자열 
  - isNullOrEmpty() : 빈 문자열 체크
  - isPatternDelimiter() : 문자열 패턴 구분자가 있는지 체크
  - splitPatternDelimiter() : 문자열 패턴 구분자를 통한 String 문자열 반환 
  - isPositiveNumber() : 문자열 양수값인지 체크
  - getTokens() : String 문자열 반환