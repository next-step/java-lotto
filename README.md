# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 문자열 계산기

### 흐름
1. 사용자가 문자열을 입력한다.
   1-a. 빈문자열, NULL, 숫자나 연산자가 아닌 값이 포함된 경우 예외가 발생한다.
   (0에서 9까지로 이루어진 숫자와 +, -, *, / 를 제외한 나머지 문자)
2. 해당 문자열을 우선순위 없이 순서대로 계산한다.
   2-b. 입력받은 문자열을 빈 공백을 기준으로 자른다.
        이 때, 숫자의 수가 문자열 수가 1개 더 많아야 계산이 가능한 수식이 되고, 아니 경우 예외가 발생한다.
3. 앞에서 부터 차례대로 계산하여 결과 값을 출력한다.
