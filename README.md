# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

<br>

## 🚀 1단계 - 문자열 덧셈 계산기

### 요구 사항
 - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 - 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### Todo 기능
 - 문자를 잘라주는 메소드(Default : ,|: or pattern을 기준)
 - pattern find 메소드(문자를 잘라내기전에 커스텀 구분자를 확인하는 메소드)
 - 음수 Validation 메소드(음수가 들어왔을 때 RuntimeException 발생) 
 - Null Check 메소드(입력값이 Null이거나 공백인 경우 확인하는 메소드)
 
 
### 객체
 - `StringAddCalculator` : 문자를 더하는 클래스
 - `Numbers` : Numbers를 관리하는 클래스 -> 입력받은 문자를 Split하여 Number 객체를 만드는 클래스
 - `Number` : Number를 관리하는 클래스 -> 음수 체크
 - `NumberPattern` : 구분자를 관리하는 클래스 -> 구분자가 없을때, 상수로 지정된 Default 반환
 - `Constant` : 상수 목록
 - `StringUtils` : 입력받은 문자열을 split하여 반환하는 클래스
 - `ValidationNumber` : 유효성 검사를 위한 클래스 


## 🚀 2단계 - 로또(자동)

### 요구 사항
 - 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 - 로또 1장의 가격은 1000원이다.
 
### Todo 기능
  - 구입금액을 입력받는 InterView 메소드
    - 구입 금액이 1000원 이상인지 체크하는 Validation 메소드
    - 구입 금액이 null 체크하는 Validation 메소드
    - 구입 금액이 정수인지 체크하는 Validation 메소드
  - lotto 번호를 생성하는 메소드
    - lotto 번호가 45를 안넘는지 체크하는 Validation 메소드
  - lotto 번호를 랜덤으로 섞어주는 메소드
    - 섞인 lotto번호를 정렬 (오름차순)
  - 지난주 당첨번호를 입력받는 InterView 메소드
    - lotto 번호가 45를 안넘는지 체크하는 Validation 메소드
    - lotto 번호가 정수인지 체크하는 Validation 메소드
  - 당첨 통계 계산하는 메소드
    - enum class로 당첨 금액 저장
    - 몇개 일치하는지 확인하는 메소드
    - 수익률 계산하는 메소드
    
### 객체
   - `Lotto`
   - `Number`
   - `Role`
   - `LottoGame`
   - `InterView`
   - `ResultView`
