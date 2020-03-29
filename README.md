# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기

### 요구사항

> * 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하면 각 숫자의 합을 반환한다.   
> * 커스텀 구분자를 지정할 수 있다.  //와 \n 사이에 위치하는 문자를 통해 구분한다.  
> * 문자열 계산기에 숫자 이외 값 또는 음수를 전달하는 경우 RuntimeException을 throw한다.  

### 요구사항 분석  

> 도출 클래스  
> InputView, StringAddCalculator, 숫자도출Type(전략), DelimiterEnum(,/:)

1. 문자를 입력받는다.  
2. 숫자(쉼표/콜론)숫자(쉼표/콜론) 형태로 입력을 받은 경우 
    - 이 구분자를 기준으로 숫자를 분리한다.  
    - 숫자 이외의 값이 입력된 경우 runtimeException을 발생한다.  
    - 음수 값이 입력된 경우 runtimeException을 발생한다.  
    - null이거나 empty 값인 경우 0으로 계산한다.  
    - 합을 구하여 리턴한다. 
3. (//)(문자열)(\n)(숫자)(문자열)(숫자) 형태로 입력을 받은 경우 
    - 구분자를 기준으로 커스텀 문자를 도출한다. 
    - 해당 커스텀 문자를 기준으로 숫자를 분리한다.  
    - 숫자 이외의 값이 입력된 경우 runtimeException을 발생한다.  
    - 음수 값이 입력된 경우 runtimeException을 발생한다.
    - null이거나 empty 값인 경우 0으로 계산한다.    
    - 합을 구하여 리턴한다.  

### 고민 사항  

* 아예 다른 형식이 입력되었을 경우 (정규식?)  
* 2와 3을 정규식 말고 다른 방법으로 완벽하게 구분할 순 없을까?  

## 로또  

### 요구사항  

> 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.  
> 로또 1장의 가격은 1000원이다.

### 요구사항 분석  

1. 로또 구입 금액을 입력받는다.  
> Money(일급 컬렉션), LottoMachine(Controller)  
2. 로또 1장의 가격을 1000원이라고 하고, 해당 금액으로 살 수 있는 만큼의 로또 티켓을 생성한다.  
> Lotto(List<LottoNumber>, 당첨 숫자 정보(개수)를 가지고 있음), Lottos(List<Lotto>, Lotto 목록)  
3. 로또 티켓은 정렬된 숫자 6개를 가지고 있다.  
4. 이 숫자는 1~45의 정수이다. 중복될 수 없다.  
> LottoNumber(일급 컬렉션) 
5. 당첨 번호를 6개 입력한다.  
> ~~WinningLotto~~
> 기존의 Lotto을 이용한다. Lotto에 직접 Number 목록을 받아 Lotto를 create 하는 메소드를 생성한다.  
6. 각 로또 티켓별 당첨 숫자 개수를 도출하여 1,2,3,4등을 도출한다.  
> LottoTier (Enum??)  
> 당첨된 개수에 따라 1등, 2등... 잘 매겨지는 지 테스트  
7. 구매 금액 대비 당첨금으로 수익률을 계산한다.  
> LottoResult? (LottoTier와 총 금액 정보를 가지고 있음)  
> 수익률은 Money에서 책임지도록 한다.(Money의 validation 로직 실행 위치를 옮기기)  

### 테스트 케이스 도출  

1. 로또 금액이 0보다 작을 경우 Exception 처리를 한다. (0 이상의 금액을 입력해주세요.)
2. 로또 금액이 0보다 크지만 1000원보다 적을 경우, Exception 처리를 한다. (해당 금액으로는 로또를 구입할 수 없습니다.) 
3. 로또 금액을 입력받아 구매할 수 있는 개수만큼의 로또 티켓을 생성한다.  
4. 입력받은 당첨 번호가 1-45 사이인지, 중복되지는 않는지 체크한다.  
5. 로또 번호를 정렬한다. 
6. 입력한 로또 번호와 티켓 번호를 비교하여 1,2,3,4등을 도출한다. - 당첨 숫자가 몇 개인지 테스트
7. 구매 금액과 당첨 금액을 비교하여 수익률을 도출한다. (구매 금액은 입력받은 금액이 아닌, 실제 구매한 가격이다.)  

### 객체별 책임  

#### LottoMachine  
* 돈을 받는다.  
* 돈을 받아 Lotto를 생성해서 생성한 로또를 관리한다.  
* 보여질 내용을 정리하여 InputView, OutputView 에게 메시지를 보낸다.  

#### Lottos  
* 생성된 로또 목록 정보를 관리한다.  
* 입력받은 로또 중 당첨 Tier에 해당하는 로또가 무엇인지 정보를 준다.  

#### Lotto
* 로또 정보를 관리한다.  
* 

#### LottoNumber  
* 로또를 구성하는 숫자 정보를 관리한다.  
* 숫자에 대한 검증 로직을 수행한다.  

#### Money  
* 로또를 구입할 때 쓴 돈 정보를 관리한다.  
* 입력받은 돈에 대한 검증 로직을 수행한다.  

#### InputView  

#### OutputView  

#### ViewUtils  