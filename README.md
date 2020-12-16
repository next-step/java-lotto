# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## Step1
### 기능 요구사항
+ 쉼표(,) or 콜론(:)을 기준으로 분리한 후 각 숫자의 합을 반환
+ 쉼표, 콜론 외에 커스텀 구분자를 지정할 수 있다
    + //와 \n 사이에 커스텀 구분자를 지정하면 된다
        + ex) 세미콜론(;)을 지정 "//;\n1;2;3" -> 결과 값은 6이다
+ 문자열 계산기에 숫자 이외에 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다

### 구현할 기능 정의
+ 입력값을 체크
+ 문자열을 구분자로 잘라주는 기능
+ 잘라진 문자열을 숫자로 바꿔 더해주는 기능
+ 입력,출력을 하는 기능 
+ 입력과 출력이 이루어지는 메인 클래스 기능

### 구현한 클래스 설명
+ InputString : 입력값 Wrapping (validation, split 등) input 문자열 처리 담당
+ StringAddCalculator : StringCalculator의 구현체로 문자열 덧셈 계산 담당
+ InputView, OutputView : Input, Ouput View를 담당
+ StringAddCalculatorMain : 프로그램 실행을 담당 

## Step2
### 기능 요구사항
+ 로또 구입 금액을 입력한다
+ 금액에 해당하는 로또를 발급한다
    + 1장 가격은 1000원이다
+ 지난 주 당첨 번호 6개를 입력한다
+ 구입한 로또의 일치하는 개수를 찾는다
+ 수익률을 계산한다
+ 당첨 통계와 수익률을 보여준다

### 구현할 기능 정의
+ 로또 구입 금액을 입력하는 기능
+ 금액만큼 로또 자동 생성을 해주는 기능
+ 지난 주 당첨 번호를 입력하는 기능
+ 구매한 로또 번호들과 당첨 번호를 비교하는 기능
    + 일치하는 개수를 찾아주는 기능
    + 일치하는 개수를 묶어주는 기능
+ 수익률을 계산해주는 기능

### 구현한 클래스 설명
+ Number : 로또번호 Wrapping 클래스
    + 생성한 숫자 validation 체크 (0<num<46)
+ LottoNumber : Number 리스트의 일급컬렉션 (로또번호 6개를 가지고 있음)
    + 가지고 있는 로또번호가 당첨인지 체크
+ LottoNumbers : LottoNumber 리스트의 일급컬렉션 (구입한 로또번호를 모두 가지고 있음)
    + 가지고 있는 로또번호들이 당첨인지 체크
    + 로또번호의 당첨개수를 key로 하여 groupBy
+ LottoNumberGenerator : 로또번호를 생성해주는 기능 담당
+ LottoGame : 로또를 구매하고 당첨결과를 알려주는 기능을 담당
+ InputView : 뷰 입력을 담당
+ OutputView : 뷰 출력을 담당
+ LottoGameMain : 실행을 위한 메인클래스 

## Step3
### Step2에 이어 추가 기능 요구사항
+ 2등을 위한 추가 번호 하나를 더 추첨 (보너스볼)
+ 당첨 통계에 2등을 추가

### Step3에서 추가되거나 수정된 클래스 설명
+ LottoGenerator : 로또 생성을 위한 인터페이스
    + LottoManualGenerator : 수동으로 로또를 생성해주는 클래스 
    + LottoAutoGenerator : 자동으로 로또를 생성해주는 클래스
+ Lotto : matchBonus 필드 추가
+ Lottos : LottoNumbers -> Lotts 네이밍 변경
    + groupBy 수정 
        + before(step2) : (일치개수:당첨된로또개수)
        + after(step3) : (일치개수:당첨된 로또 리스트) - matchBonus가 필요하여 수정함
+ LottoMatchStatus : 로또당첨 상태를 관리하는 클래스
+ LottoResult : EnumMap으로 결과를 리턴하도록 수정
+ Rank : 당첨 랭킹을 이넘으로 관리하도록 수정

## Step4

## Step5

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)