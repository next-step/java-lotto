## 이번 미션 목표
- 요구 사항 외에 과도한 확장 하지말기
- 피드백 2 발전시켜보기

## 피드백2
### 에러메세지 위치
LESS_THEN_1_EXCEPTION_MESSAGE는 LottoPriceException 클래스에서 관리해주는게 어떨까요?

추후에 에러 메세지가 많아 질 경우, Dictionary 처럼 관리하여 변수 이름으로 에러를 찾기 쉬워질 것 같아
ExceptionMessage 에 넣었습니다 준일님의 생각은 어떠신가용?~

반대로 에러 클래스의 이름을 잘 지어놓으면 굳이 변수명을 통해서 찾는 것 보다 더 명시적이지 않을까요?

- https://github.com/next-step/java-lotto/pull/908#discussion_r526006321

> 사람들한테 클래스 명을 보고 에러가 무슨 내용인지 알겠는지 물어보기

### Mock ClassName  
Mock 이라는 이름 보다 더 좋은 이름이 있지 않을까요?

Mock 은 test 에서 쓰는 이름에 더 적합하다고 하였다.

### 숫자를 3단위로 _ 로 구분하기

### static 멤버들만 있는 클래스 생성자 방어로직

### 로또 번호의 캐싱 기능
로또의 랜덤넘버를 생성해 6개를 묶어 로또 번호를 만들었었다. 이 때 랜덤번호를 매번마다 객체를 만들어 줬는데,
번호객체가 한번 만들어지면 캐시에 저장이 되어, 번호를 한번더 나왔을 때 했을 때, 이미 만들어진 넘버 객체를 가져와 사용하는 방식

### 생성자 테스트
- 모든 클래스의 생성자를 테스트를 해야 할 까?

### 사용자 로또 번호들의 조건
1. 정렬되어있어야 한다.
2. 중복값 예외
2. 범위에서 벗어난 로또 숫자 입력예외

### 당첨번호의 입력 조건
1. 6개로 갯수 제한. 6개는 전역처럼 static 상수로 정의해야 할까?

### 객체인 멤버 변수의 getter 메서드
만일 객체 멤버를 getter 를 해야되는 상황이 있으면, 불변성을 꼭 지켜주어야 한다.

## 저번 미션 회고
준일님이 피드백을 해주셨는데, 내 코드도 기억이 잘 안나서 무슨소리인가 어리둥절 했었지만.
이번 미션을 다시 정리하면서, 객체가 해야할 일이 잘 분리가 안되있는 것 같은게 느껴지면서 준일님의 말씀이 이해되었다.

## 기능 정의
- `LottoBall` 1 -45 LottoBall 의 숫자를 가지고 있는 클래스
    - public static LottoBall[] lottoNumbers
    - private LottoBall(int number)
    - public static LottoBall valueOf(int number)
    - private static void validate(int number) 
        - 1 ~ 45 사이 범위를 초과하면 에러를 던지는 기능
- `Lotto` 
    - public static Lotto of(List<LottoBall> lotto)
    - public int matchCount(Lotto targetLotto)
    - public boolean isContaining(LottoBall lottoBall)
    // - public List<LottoNumber> getLotto()
    
- `LottoGenerator` lotto 번호들을 생성하는 기능
    - public static Lotto generate()
    
- `WinningLotto`
    - public static WinningLotto of(Lotto winningLotto)
    - 보너스 볼이 당첨로또에 포함되지 않는지 검사
    
- `Lottos`
    - public static Lottos of(List<Lotto> lottos)
    - public Integer size()

    // - public NumberCountCollections statisticWinning(Lotto WinningLotto, LottoBall bonusBall)
 
- `LottoSeller` 로또 판매기 
    - static final int priceOfLotto;
    - public static Lottos generateLottos(int payment)
    - private static int calculateCountOfLotto(int payment)
    - private static void validatePayment(int payment);
    
        
- InputView
    - public static int payLotto() 로또 구입 금액을 지불하는 기능
    - public static String createWinningBalls() 금주의 당첨 번호를 입력하는 기능
    - public static String pickBonusBall() 보너스 볼을 입력하는 기능
    
- ResultView
    - public static void showLottoCount(int lottoCount) 사용자가 lotto 를 몇개 구매하였는지 보여주는 기능
    - public static void showLottos(List<Lotto> lottos) 사용자가 구매한 로또번호들을 보여주는 기능 
    - public static void showWinningStatistics(List<LottoReward> winningStatistics) 당첨 통계를 보여주는 기능
    - public static void showYield(double yield) 수익률을 보여주는 기능
    

- WinningStatistic 정산기
    - public static WinningStatistic of(Lotto winningNumbers, Lottos userLottos) {
    - public WinningStatistic execute()
    - public List<LottoReward> getLottoRewards()
    - public double calculateGainRate(int lottoPrice)

## 기능 요구사항
2등을 위해 추가 번호를 하나 더 추첨한다.
당첨 통계에 2등도 추가해야 한다.
```
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구사항
- 모든 기능을 TDD 로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
    - indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

## 힌트
- 6개의 숫자 값을 가지는 java collection 을 감싸는 객체를 추가해 구현해 본다.
- 하드 코딩을 하지 않기 위해 상수 값을 사용하면 많은 상수 값이 발생한다. 
- 자바의 enum 을 활용해 상수 값을 제거한다. 즉, enum 을 활용해 일치하는 수를 로또 등수로 변경해 본다.
```java
public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
		
    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return null;
    }
}
```
## 기능 목록 및 commit 로그 요구사항
기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
