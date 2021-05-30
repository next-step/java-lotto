#요구사항

-----

## 문자열 계산기
### 기능 요구 사항
 - [x] 구분자(쉼표,콜론)를 기준으로 분리한 값을 반환한다. #calculator#Word#makeNumbers(String)
 - [x] 입력된 문자의 시작값이 숫자인지 '/' 인지 판별한다. #calculator#Word#isCustomInput(String)
 - [x] 분리한 값의 합을 반환 할 수 있다. #calculator#Calculator#sumNumbers(List)
 - [x] 쉼표랑 콜론외에 커스텀 구분자를 지정 할 수 있다. #calculator#Word#CustomSeparate()
 - [x] 커스텀 구분자가 입력된 경우 커스텀 구분자를 찾을 수 있다. #calculator#Word#findCustomSeparator(String)
 - [x] 입력값이 음수인 경우 `RuntimeException` throw 한다. #calculator#Word#inputValidation(List)
 - [x] 입력값이 빈 문자열 또는 `NULL`인 경우 `0`을 반환 한다. #calculator#Word#emptyOrNullTest(String)

----------

## 로또
### 기능 요구사항

- [x] 금액 입력시 구입 가능한 `로또의 수`를 알 수 있다.
- [x] 로또 머신은 구입 가능한 로또의 수 만큼 로또를 발급한다.
- [x] 출력되는 `로또번호`는 6개의 서로다른 정수이다.
- [x] 구매된 로또들의 `로또번호를 각각 출력`한다.
- [x] `당첨번호`는 6개의 당첨번호와 1개의 보너스 볼이다.
- [x] 지난 주 `당첨 번호`와 보너스 볼을 동시에 `입력`받는다.
- [x] 당첨번호와 로또번호 `비교`시 총 몇개의 같은 숫자가 일치하는지 알 수있다.
- [x] 당첨 통계를 `출력`한다.
- [x] 일치된 숫자에 따라 수익률을 `알 수있다`.
- [x] `수익률`은 당첨금액 / 구매금액 이다.
- [x] `수익률`에 따른 손익 메세지를 `확인할 수`있다.
- [x] 입력된 금액에서 구매가능한 `로또의 수를` `출력`한다.