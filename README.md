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

## Step3

## Step4

## Step5

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)