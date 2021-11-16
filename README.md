# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 1단계 - 문자열 덧셈 계산기
## 기능 요구사항
* 문자열 입력을 받아 숫자를 구분하고 합을 반환
* 숫자 구분은 쉼표(,) 또는 콜론(:)
* 커스텀 구분자를 지정. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw

## 프로그래밍 요구사항
* indent(들여쓰기) depth를  1단계
* 메소드의 크기가 최대 10라인
* method가 한 가지 일만 하도록 최대한 작게
* else 사용 금지