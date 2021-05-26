### 기능 명세서
- [X] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다. 
    - [X] 사용자에게 쉼표이 포함된 숫자를 입력받아 숫자를 더한다.
    - [X] 사용자에게 클론이 포함된 숫자를 입력받아 숫자를 더한다.
    - [X] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
        - [X] 음수가 전달되는 경우 예외처리한다.
        - [X] 문자열 계산기를 제외한 값이 숫자가 아닌 경우 예외처리한다. 
- [X] 각 숫자의 합을 반환한다.
    - [X] 입력받은 숫자들의 합을 구한다.
- [X] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
        커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
        예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    - [X] 기본 구분자외에 커스텀 구분자를 입력받을 수 있다.

### 로또
- [ ] 로또를 구매한다.
    - [ ] 입력한 금액에 따른 개수만큼 로또를 구매한다.
    - [ ] 금액에 따라 로또 생성 개수를 정해진다.
    - [ ] 개당 금액이 1000원 이하인 경우 생성을 실패한다.
- [ ] 로또들을 발급한다.
    - [ ] 6개의 1부터 45이하의 중복되지 않는 랜덤 값을 생성한다
    - [ ] 입력 개수만큼 로또를 생성한다.
    - [ ] 입력 개수가 0보다 작은경우 생성되지 않는다.
- [ ] 로또를 발급한다.
    - [ ] 로또의 한장 가격은 1000원이다.
    - [ ] 로또는 로또번호들을 가진다.
- [ ] 로또번호를 생성한다. 
    - [ ] 로또번호는 1 ~ 45 사이의 숫자이다.
- [ ] 로또번호들을 생성한다.
    - [ ] 6개의 로또번호를 가진다.
    - [ ] 로또번호의 개수가 6개가 아니면 생성되지 않는다. 
    - [ ] 로또번호는 중복되면 안된다.
- [ ] 당첨 번호를 입력받는다.
    - [ ] 당첨 번호는 6자리를 입력받아 당첨 로또번호를 생성한다.
    - [ ] 로또번호와 당첨번호의 일치하는 개수를 구한다.
    - [ ] 로또번호들 중에 당첨번호와 일치하는 개수들을 전달한다.
- [ ] 당첨금액과 구매금액을 비교하여 수익율을 계산한다.
