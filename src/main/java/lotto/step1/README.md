**step1. 문자열 덧셈 계산기**
-
**- 요구사항**
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다
2. 문자열을 쉼표(,) or 콜론(:) 구분자를 기준으로 분리
3. 분리한 숫자들의 합을 반환
4. 앞에 구분자 외에 커스텀 구분자를 지정 : "//;\n1;2;3" => ; 구분자로 분리하여 합 6 반환
5. 숫자 이외에 값 or 음수를 전달 할 경우 : RuntimeException 예외를 throw

**- TODO List**
1. ~~문자열을 받아서 구분자를 기준으로 분리해보자(테스트 코드부터 작성해볼까)~~
2. ~~분리한 숫자들을 합해보자~~
3. ~~커스텀 구분자를 지정해서 계산해보자~~
4. ~~빈 문자열 or null 이 들어올 경우 0을 반환(뒤늦게 추가)~~
5. ~~검증로직을 구현(number < 0 or number가 아닌것)~~

**- 기능 목록**
1. StringCalculator 클래스
    - addString : 입력값 받음
    - checkNullOrEmpty : 널이거나 0이 들어오면 0반환 아니면 로직시작
    - splitValue, isCustom : 커스텀구분자와 기본구분자로 나뉨
    - splitCustomPattern : 커스텀 구분자로 문자열 자름
    - splitBasicPattern : 기본구분자로 문자열 자름
    - checkDelimiter : 구분자 검증  
    - checkMinusOrNotNumber : 자른 값이 숫자값인지 마이너스 값인지 검증 -> RuntimeException
    - sum : 숫자값이면 합산하여 반환
2. StringCalculatorTest
    - 각 단계별 테스트 진행
