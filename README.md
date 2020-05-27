## 로또(2등)

- 리팩토링하다가 ..
-> BonusNumber가 LottoNumber와 다를게 없어서 제거했다.. 하지만 로또넘버인지, 보너ㅡㅅ넘버인지를 변수이름에 의존해야한다는게 찝찝


- https://github.com/next-step/java-lotto/pull/538#discussion_r430240107 감이안잡힌다 ㅠㅠ 
WinningTicket에 메시지를 던지면 의존순환이되는게 아ㅣㄹ낚?,,


- LottoTickets - LottoTicket - BonusNumber  이렇게 의존성이 순환되는 것 같은데, WinningTickets 가 그냥 LottoNumber를 가지고 있는게 나을까?
일급컬렉션에 대한 집착 착 , ,,



- 보너스번호, 2등 추가 - LottoPrize
- 보너스번호를 입력받는다.


리팩토링
- 상수의 중복해결 --> LottoNumberSetting enum 생성.... 흠

## 로또(자동)
1. 로또 구입 금액을 입력하면 로또를 발급한다 - o
- 한장당 가격은 1000원

2. 구매한 로또티켓 장수를 반환한다.
3. 로또티켓 숫자를 반환한다. - o


4. 지난주 당첨번호에 따른 당첨 통계를 반환한다.
- 3,4,5,6개 일치하는 총 장수 - o 
- 총 수익률 - o 


**로또 진행과정 중 질문사항**
1. 객체지향적 관점.. ?  
객체의 상태는 private으로 캡슐화하는 것을 권장. 하지만 LOTTO_TICKET의 price는 상수. 
private으로하면 getPRICE와 같은 뭔가 이상한 ,,? 메서드가 호출됨.
그렇다고 LottoStore가 LottoTicket의 가격을 가지고 있는 것은 객체지향적 관점에서 맞지 않은 것 같음.
그래서 일단 public ... 이지만 찝찝.
```java
public static final int PRICE = 1000;
```
LottoStore에서 아래처럼 쓰려다보니 ,, 
```java
private static final int LOTTO_TICKET_PRICE = LottoTicket.PRICE;
```



# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열덧셈계산기
0. null 또는 빈 문자열인 경우 0 을 반환한다. - o

1. 주어진 문자열에 커스텀 구분자가 있는지 판단한다 - o

2. 커스텀 구분자가 없다면 , 또는 : 로 문자열을 분리한다 - o 

3. 커스텀 구분자가 있다면 해당 커스텀구분자로 문자열을 분리한다 - o

4. 분리된 문자를 숫자로 치환한다. - o
- 이 과정에서 숫자가 아니거나 음수라면 Exception 을 던진다.
