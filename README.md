# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기
### 요구사항
* 쉼표 또는 콜론 구분자가 존재한 문자열을 전달 시 구분자 기준으로 숫자의 합을 반환
    * "" -> 0
    * "1,2" -> 3
    * "1,2,3" -> 6
    * "1,2:3" -> 6
* 기본 구분자 외에 커스텀 구분자를 지정할 수 있다. (//와 \n사이의 문자를 커스텀 구분자로 사용)
* 숫자 이외의 값 또는 음수 전달 시 예외 발생 (RuntimeException)

## 로또
### 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* 로또번호는 1에서 45 사이이다.
* 로또번호가 1에서 45 범위가 아닐 경우 illegalArgumentException 이 발생한다.
* 로또 번호 개수는 6개다.
* 당첨 번호 입력 시 잘못된 입력이나 번호 개수가 6개가 아닌 경우 illegalArgumentException 이 발생한다.
* 로또 번호는 중복이 없어야 한다.
* 개수별 당첨 통계를 출력한다.
