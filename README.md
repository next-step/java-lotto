# 문자열 계산기
### 기능요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 구현
- [x] 문자열을 전달하면 쉼표(,) 또는 콜론(:)을 기준으로 자른다
- [x] 기본 구분자 외의 "//", "\n"로 커스텀 구분자를 지정해서 문자열을 자른다
- [x] 숫자 이외의 값 또는 음수는 RuntimeException throw 한다
- [x] 빈 문자열의 경우 0을 리턴한다
- [x] 자른 문자열 배열을 받아 합한다

# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 기능 구현
- [x] 발급된 로또 번호는 1~45 사이의 값 중 6개 이다.
- [x] 카지노에서 로또를 살 수 있다.
- [x] 카지노에서 로또는 1장에 1000원이다.
- [x] 카지노에서 로또를 1000원 미만의 돈으로 사면 에러를 낸다.
- [x] 일등 이등 삼등 사등 오등을 확인한다
- [ ] 로또 번호가 유니크하게 발급되었는지 확인한다
- [ ] 보너스 번호가 우승 번호에 포함 되지 않았는지 확인한다
