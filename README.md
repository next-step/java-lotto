# 문자열 덧셈 계산기

## 기능 요구사항

1. 쉼표(,), 콜론(:) 을 구분자로 가지는 문자열을 전달받으면, 구분자를 기준으로 숫자를 분리하여 합을 반환한다
2. 1번의 구분자 이외에 custom 구분자를 지정할 수 있다.
    - `\\`과 `\n` 사이에 위치하는 문자를 custom 구분자로 정의한다
    - `“//;\n1;2;3”`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

## 구현 힌트

1. 빈 문자열, 또는 `null` 을 입력하는 경우 0을 반환한다
2. 숫자 하나를 문자열로 입력한다면, 그 숫자를 반환한다
3. 숫자 두개를 `,` 구분자로 입력하면 두 숫자의 합을 반환한다
4. `,` 대신 `:` 도 가능하다
5. `\\`, `\n` 문자 사이에 custom 구분자 지정
6. 음수를 전달한다면 `RuntimeException` 발생

# 로또

## 객체

├── BonusLottoGameManager.java: Bonus 번호가 들어간 게임을 시작하고 종료하는 관리자 이다.
├── LottoGameManager.java: 로또 게임을 시작하고 종료하는 관리자이다.  
├── calculator  
│   └── StringCalculator.java: 앞선 step1, 2 의 계산기이다. 사용자가 입력한 당첨 번호에 사용한다  
├── interaction : user interface 를 맞는다  
│    ├── InputView.java  
│    └── OutputView.java  
└── lotto  
    ├── BonusLotto.java: 보너스 번호 lotto 이다  
    ├── LottoNumber.java: 로또 번호 하나  
    ├── LottoNumbers.java: 로또 한 세트이다  
    ├── generator  
    │   ├── AutoLottoNumberGenerator.java: 랜덤을 사용해 로또 번호를 생성한다. 가게에서 파는 로또 머신의 역항  
    │   ├── BonusLottoGenerator.java : 보너스 번호를 포함한 게임의 번호 생성기 이다.
    │   ├── Generator.java: 로또 번호 생성기의 interface 이다.  
    │   └── MessageLottoNumberGenerator.java: 사용자가 입력한 문자열을 로또 한벌로 만들어주는 역할을 한다  
    ├── statistics  
    │    ├── Earn.java: 로또 번호 매칭이 되었을 때 각 등급별 가격을 명시한다  
    │    ├── Profit.java: 이익을 계산하는데 사용한다  
    │    ├── Statistic.java: 로또 하나에 대해 얼마나 매칭되었는지, 그래서 얼마를 벌었는지 통계를 내어준다  
    │    └── StatisticsCalculator.java: 사용자가 구매한 금액의 모든 로또를 계산한다  
    └── store  
        ├── LottoStore.java: 로또를 판매한다, 또한 확장성을 고려해 로또의 가격을 정할 수 있다  
        └── Ticket.java: 유저가 한번 구매한 모든 로또는 티켓으로 발급된다  

## 고려한 내용

1. `List`, `Map` 에서 initialCapacity 를 명시했다. 사이즈가 늘어나고, re-hasing 을 하면서 발생되는 추가적인 연산을 막고 싶었다.


## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구사항

1. 로또 구매 가격을 입력받는다 (장당 1,000원)
   - input은 `int`
2. 사용자는 구매하고 싶은 만큼의 로또 가격을 입력한다. 구매 개수 = (입력 / 1000)
   - 구매 개수 출력
3. 구매 개수 만큼의 로또를 생성한다
   - 생성한 로또 출력
4. 로또 우승 번호 6자리를 입력받는다
5. 우승 번호와 일치하는 개수를 찾아 통계를 낸다 (3, 4, 5, 6개 일치)
6. 각 일치되는 개수별 우승상금의 합계를 반환한다
7. 1을 기준으로 백분율 표시 (얻은 상금 / 구매 가격)

## 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다.
    - if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.
- `input`, `output` 에 대한 객체 설계
    - `InputView`, `ResultView` 생성
- 함수는 한 가지 일만 해야한다

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
