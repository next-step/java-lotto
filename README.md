# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 1단계 문자열 덧셈 계산기
#### 기능 요구사항

- [X] 기본 구분자로 문자열 분리
* 기본 구분자는 쉼표(,) 또는 콜론(:)

- [X] 커스텀 구분자로 문자열 분리
* 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자

- [X] 분리된 문자를 숫자로 변환 (숫자가 아니거나 음수인 경우 RuntimeException 예외를 throw)
- [X] 숫자의 합을 구함

- [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
- [X] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있음
