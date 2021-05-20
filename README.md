# 2단계 - 문자열 덧셈 계산기
## 기능 목록
* 문자열이 null이나 0이면 0 반환한다.
* 문자열에 커스텀구분자가 있으면 추출한다.
* 문자열에서 구분자로 분리된 숫자문자열을 추출한다.
* 숫자문자열에서 구분자로 숫자들을 분해한다.
* 분해한 숫자들을 합산한다.

## Process
1. 문자열를 입력받는다.
2. 문자열이 null이나 0인지 확인한다.
    * 해당되면 -> 0 반환한다.
3. 문자열의 커스텀구분자가 설정되어있는지 확인한다.
    * 있으면 -> 구분자로 지정한다.
4. 설정된 구분자로 숫자문자열을 분해한다.
    * 음수가 있으면 -> 런타임 예외처리한다.
5. 분해한 숫자들을 합산한다.
6. 합산 값을 반환한다.
-----------

## 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. </br>
  커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. </br>
  예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.</br>
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
## 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. </br>
  if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.  
