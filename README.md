# 문자열 덧셈 계산기
## 요구 사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환   
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.   
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.   
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
* 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)

## 기능 구현내용
* 문자를 입력받는 기능
* 결과를 출력하는 기능
* 입력받은 문자를 분리하는 기능
    * 구분자가 기본인지 커스텀인지 확인
    * 해당 구분자로 분리
* 입력받은 문자를 더하는 기능
    * 입력받은 문자가 숫자이외의 이거나 음수를 전달하는 경우 RuntimeException 발생
    * 입력받은 문자를 더하는 기능

# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 기능 구현 내용
### 입력
* 로또 금액을 입력받는다.
* 지난주 당첨번호를 입력받는다.
    * 콤마(,)로 구분됨.

### 출력
* 생성한 로또의 개수를 출력한다,
* 생성된 로또를 출력한다.
* 당첨 통계를 출력한다.
    * 3개, 4개, 5개, 6개 일 개수
    * 총수익률

### 로또
* 6개의 수로 구성되어 있음
* 1 ~ 45의 수
* 중복된 수가 있으면 안됨.

### 로또 구입처
* 로또 금액에 해당하는 로또 구입개수를 계산한다.
    * 로또 1장 : 1,000원
* 로또 번호 생성을 로또 생성기에 요청한다.

### 로또 생성기
* 로또를 생성한다.

### 당첨번호 확인기
* 생성된 로또에서 당첨번호가 있는 지 확인한다.
* 당첨번호와 몇개가 일치하는 지 확인한다.
* 당첨 개수를 파악한다.
* 당첨 개수에 따라 당첨금을 계산한다.
* 당첨금 / 구매금액 으로 수익률을 계산한다.