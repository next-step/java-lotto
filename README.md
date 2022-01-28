
# 📌 문자열 덧셈 계산기

## 기능 요구 사항

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)

앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 구현 사항
- [ ] 사용자의 입력을 받음 - view.InputView
    - [ ] 구분자 입력 - getDelimeter
      - [ ] 입력 형식이 맞는지 (//*)
      - [ ] custom 구분자가 있는지
          - 없으면 : ',' , ':'
          - 있으면 : 숫자만 아니면 OK
    - [ ] 식 입력 - getExpression 
      - [ ] 입력은 공백이면 0을 반환("", " ")

- [ ] 식 파싱 - ExpressionParser()
  - parse(expression)
  - 식을 구분자로 파싱해서  Numbers 반환. (List<Number>) 
  - Number
    - [ ] 구분자가 아닌 숫자 이외의 문자가 포함되어 있으면 안된다.
    - [ ] 숫자는 양수.

- [ ] 계산기 - StringAccumulator
  - Numbers 순회하며 덧셈.
  
- [ ] 결과 출력 view.ResultView






