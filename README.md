# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# TDD 원칙
* 원칙 1 - 실패하는 단위 테스트를 작성할 때까지 프로덕션 코드(production code)를 작성하지 않는다.
* 원칙 2 - 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
* 원칙 3 - 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

# step1. 문자열 덧셈 계산기 기능 요구사항
* 입력문자가 빈 문자열을 입력할 경우 0 을 반환한다.
   구분자로 분리해서 얻은 문자열이 빈 문자열일 경우도 0 을 반환한다.
   if (text.isEmpty()) {}
* 입력문자가 null 값을 입력한 경우 0 을 반환한다.
  if (text == null) {}
* 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. 
  int number = Integer.parseInt(text);
* 쉼표(,), 또는 콜론(:) 을 구분자로 가지는 문자열 전달하는 경우 구분자를 기준으로 분리 
  String[] tokens= text.split(",|:");
* 커스텀 구분자는 문자열 앞부분의 “//“ 와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
      // java.util.regex 패키지의 Matcher, Pattern import
      Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
      if (m.find()) { // 커스텀구분자라는 것을 나타내는 문자열이 있다면 	  
           // m.group(0) 은 커스텀구분자로 시작하는 문자열 전체
           String customDelimiter = m.group(1); //커스텀구분자 문자열 구하기
           String[] tokens= m.group(2).split(customDelimiter); // 커스텀 구분자 문자열로 문자열 split
           // tokens 들로 덧셈 구현
      }
* 특정 양수의 숫자를 전달받아 기존에 있던 숫자에 덧셈을 한다.
* 문자열 계산기에 숫자 이외의 값
  전달받는 경우 RuntimeException 예외를 throw.
* 음수를 전달받는 경우 RuntimeException 예외를 throw 한다. 
  @Test(expected=RuntimeException.class) // 특정 예외가 발생하면 테스트 성공

