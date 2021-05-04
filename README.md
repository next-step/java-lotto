### 요구사항 
-----
##### 기능 요구 사항
 - [x] 구분자(쉼표,콜론)를 기준으로 분리한 값을 반환한다. #Word#makeNumbers(String)
 - [x] 입력된 문자의 시작값이 숫자인지 '/' 인지 판별한다. #Word#isCustomInput(String)
 - [x] 분리한 값의 합을 반환 할 수 있다. #Calculator#sumNumbers(List)
 - [x] 쉼표랑 콜론외에 커스텀 구분자를 지정 할 수 있다. #Word#CustomSeparate()
 - [x] 커스텀 구분자가 입력된 경우 커스텀 구분자를 찾을 수 있다. #Word#findCustomSeparator(String)
 - [x] 입력값이 음수인 경우 `RuntimeException` throw 한다. #Word#inputValidation(List)
 - [x] 입력값이 빈 문자열 또는 `NULL`인 경우 `0`을 반환 한다. #Word#inputValidation(List)