# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 문자열 덧셈 계산기 기능 요구사항
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : "" => 0, null => 0)
- 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : "1")
- 구분자로 컴마를 사용할 수 있다.
- 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : "1,2:3" => 6)
    - 기본 구분자는 쉼표 또는 콜론이다.
- "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : "//;\n1;2;3" => 6)
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException throw
- 구분자를 기준으로 숫자를 나눌 수 있다.
- 나눈 숫자의 합을 반환한다.

## 로또 기능 요구사항
- 구입 금액을 입력받을 수 있다. 
- 입력의 단위는 1000원 단위여야 한다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- 로또의 숫자는 정렬해서 보여준다.
- 당첨번호를 입력할 수 있다. (6개여야 한다.)
- 당첨 갯수에 따라 통계를 보여준다.
- 총 수익률을 계산해서 보여준다.