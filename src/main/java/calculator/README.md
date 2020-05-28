# 1단계 - 문자열 덧셈 계산기
> https://edu.nextstep.camp/s/KDgLkV1d/ls/ZdrmTmSC

## 요구사항

### 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.

### 기능 요구사항
* 구분자로 연결된 0, 자연수들을 입력했을때 그들의 합을 계산하는 기능을 구현한다.
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
  * public StringAddCalculator::sum(String input) String
  * private StringAddCalculator::split(String input, String delimiter) String[]
  * 쉼표만 있는 경우, 콜론만 있는 경우, 같이 있는 경우, 구분자가 없는 경우 테스트
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  * 구분자 파싱과 input에서 구분자를 제외하는 일을 동시에 진행해야함. 리팩토링 필요
  * 커스텀 구분자가 있는 경우, 없는 경우 테스트
  * 커스텀 구분가의 형식이 틀린 경우 테스트
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
  * private StringAddCalculator::convertInteger(String[] inputs) int[]
  * 숫자 이외의 값에 대한 테스트 추가
  * 음수에 대한 테스트 추가
