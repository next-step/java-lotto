# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

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
* 문자열 계산기에 숫자 이외의 값(null 과 빈문자열은 0으로 치환한다) 
  전달받는 경우 RuntimeException 예외를 throw gksek.
* 음수를 전달받는 경우 RuntimeException 예외를 throw 한다. 
  Assertions.assertThrows(RuntimeException.class, () -> {
              cal.add("-1,2,3");
          });
          
# step2. 로또(자동) 기능 요구 사항
* 로또 구입금액은 1000원 단위로 입력받는다.
* 입력한 구입금액이 0, 음수, 1000으로 나누어 나머지가 발생하는 수일 경우 
   IllegalArgumentException throw
* 입력금액/1000 수만큼 로또숫자를 발행한다
* 로또 번호는 1~45 까지 중 1회당 중복없이 6개의 랜덤 한 수가 나온다.
   Collections.shuffle() 메소드 활용
* 발생한 로또 번호 6개는 Collections.sort() 메소드로  오름차순 정렬 한다.
* 입력받는 당첨 번호는 쉼표(,) 로 구분하여 받으며  
  숫자형태 문자열이 아니거나 입력받는 문자열 개수가 6개가 아닌경우 
  IllegalArgumentException throw
* 입력받은 6개의 수 한개씩 자동으로 생성된 로또들을 
  ArrayList contains() 이용하여 일치하는 숫자 개수를 구한다.
* 일치하는 수 개수와 당첨금액을 가지는 등수 Enum 
  일치하는 숫자 2개 이하 꽝(none) 0원 리워드
   3개 일치는 5등(fifth) 5000원 리워드 받는 로또 개수 저장 
  4개 일치는 4등(fourth) 50000원 리워드  로또 개수 저장
   5개 일치는 3등(third) 1500000원 리워드  로또 개수 저장 
  6개 일치는 1등(first)  2000000000원 리워드  로또 개수 저장
* 총 수익률은 당첨금액/로또구입금액 소수점 두자리수 까지로 반환한다
* 수익률 Enum  
  1 미만은 손해 
   1 이면 본전 
  1 초과면 이익  








