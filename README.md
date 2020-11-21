# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항
StringUtils
1. 빈 문자열 또는 null을 입력하면, true을 반환한다.
2. 문자열을 구분자에 맞게 나눈다(, or : or //''\n)

IntegerUtils
3. 나뉜 문자를 숫자로 바꾼다.
    - 숫자가 음수이면 Excption을 throw한다.
        - junit4 expected exception

Calculator
4. 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
5. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
6. 나누어진 문자를 더한 결과를 출력한다.