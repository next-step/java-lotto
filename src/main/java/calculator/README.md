## 문자열 덧셈 계산기 구현 기능들

* 사용자의 문자열 입력
* 문자열 해석
  * 커스텀 구분자가 없을 경우 : ",:" 구분자가 default
  * 커스텀 구분자가 있을 경우 : "//*\n" 사이의 구분자를 사용함
  * 숫자 이외의 값 & 음수 값 : RuntimeException
* 문자열을 구분자로 분리하여 값을 구함
* 결과물 출력

* Domain
    * StringAddCalculator
    * StringParser
    * StringSplitter
    * Numbers
    * InvalidNumberException
 * View
    * InputView
    * ResultView
 * Main
