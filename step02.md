## 기능 정리
- InputView
    - public static int payLotto() 로또 구입 금액을 지불하는 기능
    - public static String createWinningNumber() 금주의 당첨 번호를 입력하는 기능
- ResultView
    - public static void showLottoCount(int lottoCount) 사용자가 lotto 를 몇개 구매하였는지 보여주는 기능
    - public static void showLottos(List<Lotto> lottos) 사용자가 구매한 로또번호들을 보여주는 기능 
    - public static void showWinningStatistics(List<WinningStatistic> WinningStatistics) 당첨 통계를 보여주는 기능
    - public static void showYield(float yield) 수익률을 보여주는 기능
- LottoPrice 로또 장당 가격
    - public static LottoPrice of(int price) 생성자
    - private static void validate(int price) 장당 가격이 1원 이하이면 예외처리
    - public int calculateLottoCount(int payment) 지불한 돈으로 로또를 몇 개 살 수 있는지 계산해 주는 기능
- LottoNumbers 로또에서 나올 수 있는 숫자들
    - private static Integer[] generate(Integer from, Integer to)
- Lotto 
    - public static Lotto of(List<Integer> lotto)
- Lottos
    - public static Lottos of(List<Lotto> lottos)
- LottoSeller 로또 판매기 
    - private LottoSeller(LottoPrice lottoPrice)
    - public static LottoSeller of(int lottoPrice)
    - public Lottos generateLottos(int payment, LottoNumbers lottoNumbers)
- WinningStatistic 정산기
    - 생성자 (금주의 당첨 번호)
    - 사용자의 로또 번호들과 금주의 당첨번호를 비교해주는 기능
    - 수익률을 계산해 주는 기능

## 진행 사항
- racing car 마지막 리팩토링에서는, 작은 단위에서 부터 큰단위로 발전해가며 Test code 를 작성하고 프로덕션 코드를 작성하였습니다
- 이번 계획은, input output view 를 먼저 작성하고, 사용자 시나리오흐름으로 test code 작성 -> production code 작성 할 예정입니다.
- 역시 작은 단계부터 설계한 다음에 코드를 작성하는 것이 효율적인 것 같아요
- Integer[] 보다, List<Integer> 그리고 int 보다 Integer 을 사용해야겠다고 느낀 것이, Collections 나 stream 에 메서드를 쓸때 매개변수의 형식호환때문

    
## 기능 요구사항
- 입력: ${로또 구입 금액} 
- 출력: ${구입 금액에 해당하는 로또들}

- 로또 ${1장의 가격}은 1000원

```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList 의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항
- 모든 기능을 TDD 로 구현해 단위 테스트가 존재해야 한다. 
    - 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView 와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    
## 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git 의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
