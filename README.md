# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

***
# 1단계 - 문자열 덧셈 계산기

## 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다
* else를 사용하지 마라

## 기능 정의
- [x] 쉼표(,) 또는 클론(:)을 구분자로 가지는 문자열을 입력받아 문자열 배열 반환
  - [x] null 또는 빈 문자열인 경우 0 반환
- [ ] 입력된 문자열을 숫자로 치환하여 덧셈 결과 반환
- [ ] 문자열 입력 시 커스텀 구분자 입력 기능
    * 커스텀 구분자의 구분기호는 ```//``` 와 ```\n``` 사이의 문자열로 지정
    * ```//;\n1;2;3``` 입력시 세미콜론```;```을 구분자로 하여 문자열 배열 생성
- [ ] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다