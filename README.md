# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기

### 객체 도출  

* InputView / OutputView  
* Numbers: 입력받은 숫자 목록: 숫자 배열을 입력받아 생성됨
  * 생성자에서 음수가 포함되어 있을 경우 Exception 처리
* InputParser: Input을 입력받아 Numbers 객체 생성    
  * 커스텀 Pattern에 맞을 경우 해당 기호를 기준으로 Numbers 객체 생성  
  * ','와 ':'을 기준으로 Numbers 객체 생성
  * Input이 Null이 거나 Empty일 경우 0만이 포함된 Numbers를 생성한다.
* StringAddCalculator: Numbers 객체를 입력받아 합을 계산한다.
    * calculate 함수 제공  
    * Numbers를 입력받아 해당 수들의 합을 제공한다.  