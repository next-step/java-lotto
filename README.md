# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환  
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.  
(예: “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.)
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 요구사항

- `문자열 덧셈 계산기(StringAddCalculator)`
    - [X] 문자열을 판독하고 숫자의 합을 구할 수 있다.
     
- `패턴 판독기(PatternReader)`
    - [X] 패턴을 판독하여 `숫자들(Numbers)`을 반환한다.
    
- `넥스트스탭 패턴 판독기(NextStepPatternReader)`
    - 기본 구분자는 쉼표와 콜론으로 한다.
    - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - [X] 기본 구분자로 판독할 수 있다.
    - [X] 커스텀 구분자로 판독할 수 있다. 
    - [X] 숫자 이외의 값을 전달하는 경우 예외처리를 한다.
    - [X] 음수를 전달하는 경우 예외처리를 한다. 

- `숫자들(Numbers)`
    - [X] 숫자의 총 합을 구할 수 있다.
    
- `숫자(Number)`
    - [X] 0과 양수의 값만 허용한다.
    - [X] 음수로 생성하려는 경우 예외처리(RuntimeException)를 한다.
    - [X] 숫자끼리 더 할 수 있다.

## Step2 로또 (자동)

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
````text
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
````

## 요구사항

- `금액(Money)`
    - 0 이상의 범위를 가진 하나의 숫자를 의미한다.
    - [X] 금액을 더할 수 있다.
    - [X] 금액을 나눌 수 있다.
    - [X] 금액을 곱할 수 있다.
    - [X] 수익률을 구할 수 있다.

- `등수(Rank)`
    - 로또 티켓의 당첨 결과를 의미한다.
    - `FIRST`, `SECOND`, `THIRD`, `FORUTH`, `ÙNRANK`의 값을 가진다.
    - 각 등수 별 조건과 당첨 금액을 가진다.
    - [X] 조건에 맞는 등수를 구할 수 있다.
    - [X] 등수 별 당첨 금액을 구할 수 있다.
    
- `로또 번호(LottoNumber)`
    - 1 ~ 45 범위의 숫자 하나를 의미한다.
    - [X] 로또 번호는 1 ~ 45 범위를 가진다.
    - [X] 로또 번호가 1 ~ 45 이외일 경우 예외 처리를 한다.
    
- `로또 티켓(LottoTicket)`
    - 6개의 `로또 번호(LottoNumber)`들을 의미한다.
    - 가격은 1000원이다.
    - [X] 특정 로또 번호가 포함되는지 확인할 수 있다.
    - [X] 당첨 로또 번호와 비교해서 `등수(Rank)`를 구할 수 있다.
    
- `로또 티켓들(LottoTickets)`
    - [X] 당첨 로또와 비교해서 `등수(Rank)` 배열을 구할 수 있다.
    
- `로또 기계(LottoMachine)`
    - `금액(Money)`에 맞게 `로또 티켓들(LottoTickets)`을 생성하는 역할을 한다.
    - [X] 로또 티켓들을 생성할 수 있다.
    
- `로또 결과(LottoReport)`
    - `등수(Rank)`의 통계를 의미한다.
    - [ ] 각 등수 별 당첨 수를 확인할 수 있다.
    - [ ] 수익률을 구할 수 있다.
    
- `로또 분석기(LottoAnalyzer)`
    - `로또 티켓(LottoTicket)`의 결과를 분석하는 역할을 한다.
    - [ ] 판독한 `등수(Rank)`들로 `로또 결과(LottoReport)`로 만든다.
