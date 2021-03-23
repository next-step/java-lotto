## 문자열 덧셈 계산기

구분자로 문자열을 분리하고 숫자로 변환하여 합을 구한다.

### StringAdditionExpression 
* 연산요청을 생성자 파라미터로 받는다
* 생성자에서 구분자를 결정한다.
* 기본구분자는 따로 명시하지 않는다. 쉼표','와 콜론':'이 있다.
* 커스텀 구분자는 '//'와 '\n' 사이에 위치하는 문자이다.
* 구분자를 활용하여 문자열을 어레이로 변환한다.

### Calculator
* 인스턴스를 싱글턴으로 관리한다.
* 문자열을 int 로 변환하는 toNumber 메서드
    * 숫자 이외의 값을 입력할 경우 RuntimeException 을 던진다
* 음수인지 체크하는 assurePositive 메서드
    * 음수를 입력할 경우 RuntimeException 을 던진다
* 문자열 input 을 계산하는 calculate 메서드
  * "" 또는 null 입력시 '0' 으로 변환한다.
  * input 을 StringAdditionExpression 으로 변환하여 덧셈 연산한다.


### InputView
* 덧셈식을 수행할 문자열을 입력 받는다.

### PrintView
* 합을 출력한다. 
