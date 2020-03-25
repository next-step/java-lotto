# 로또
## 문자열 덧셈 계산기
* 어플리케이션 흐름
    1. 사용자가 문자열을 입력한다.
    2. 입력값에 대한 Null&Empty 검증을 진행한다.
    3. 문자열을 구분자를 기준으로 분리한다.
    4. 문자열을 숫자로 변환한다.
    5. 숫자를 더한다.
    
* 기능 구현
    1. 입력받은 문자열을 출력하는 기능
    2. 입력값을 검증하는 기능
        * 예외처리_입력값이 null이면 0을 반환한다.
        * 예외처리_입력값이 Empty이면 0을 반환한다.
    3. 입력받은 문자열을 인자로 주면, 구분자로 구분된 문자열의 배열(또는 콜렉션)를 반환하는 기능
    4. 구분자로 구분된 문자열의 배열(또는 콜렉션)을 인자로 주면, 숫자로 반환하는 기능 
        * 기능_문자열 배열(또는콜렉션)을 숫자로 변환한다.
        * 예외처리_입력값이 숫자가 아니면 예외를 던진다.
        * 예외처리_입력값이 음수면 예외를 던진다.
    5. 숫자로 변환된 배열(또는 콜렉션)을 인자로 주면, 더하기 연산의 결과값을 반환하는 기능