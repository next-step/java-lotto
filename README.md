# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step1. 문자열 덧셈 계산기
 - [x] 쉼표(,), 콜론(:)을 구분자로 분리한 숫자의 합을 반환한다.
 - [x] 커스텀 구분자를 지정할 수 있다.
   - [x] 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 - [x] 숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외를 던진다.
 - [x] 빈 문자열 혹은 null 값을 입력하는 경우 0을 반환해야한다.
 - [x] 숫자 하나를 문자열로 입력한 경우 해당 숫자를 반환한다.
