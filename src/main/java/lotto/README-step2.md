## 2단계 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다

### 예시
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

#### 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### TODO LIST
- [x] InputView 입력 항목
  - [x] 구입금액
  - [x] 지난 주 당첨 번호 6개 split(",")
- [x] ResultView 출력 항목
  - [x] 로또 6자리 추첨 번호 (장수만큼 반복)
  - [x] 당첨 통계
  - [x] 총 수익률 = (sum(당첨 등수 당 금액 * 당첨 장수) / 로또 구매 금액)
- [x] 로또 장수 : 구입금액 / 1000원
- [x] 로또 번호 추첨 규칙 : 1 ~ 45 중의 숫자 6개를 중복 없이 추첨
  - [x] 로또 자동 생성은 Collections.shuffle() 메소드 활용
- [x] 로또 당첨 여부 판단 로직
  - [x] Collections.sort() 메소드를 활용해 정렬
  - [x] ArrayList의 contains() 메소드를 활용하여 어떤 값이 존재하는지 유무를 판단
  - [x] 일치 갯수, 금액을 Enum으로 관리
    - 3개 일치 (5000원)
    - 4개 일치 (50000원)
    - 5개 일치 (1500000원)
    - 6개 일치 (2000000000원)
    
### 2차 TODO LIST
- [x] 하나의 항목을 구현완료할 때 마다 체크 표시와 함께 커밋할 것
- InputView
  - [x] 입력을 받기 위한 메시지 출력은 InputView 내부에서 수행할 것
  - [x] 로또를 구입할 수 있는지 없는지는 도메인에서 검증하도록 메소드 이동
- ResultView
  - [x] 구입한 로또 목록을 출력할 것
  - [x] test 클래스 제거
- Const
  - [x] SRP를 지키기 위해 상수를 사용하는 객체가 상수를 관리할 것
- Lotto
  - [x] 생성에 대한 책임을 모두 주 생성자가 처리하도록 부 생성자는 주 생성자를 호출하도록 할 것
  - [x] 로또 숫자의 갯수가 6개라는 제약을 Lotto 내부에서 검증할 것
  - [x] 인자의 변수명도 축약하지 않고 사용할 것
  - [x] 이유 없이 메서드를 분리하지 말 것
- LottoGames 책임 분리 (각각의 객체로)
  - [x] Lottos를 생성하는 책임 분리
  - [x] 수익률을 구하는 책임 분리
  - [x] 당첨결과를 구하는 책임 분리
  - [x] 당첨 결과를 객체로 도출 -> 수익률은 당첨 결과에게 조회하도록
- RewardEnum 
  - [x] 명명 변경: RewardEnum -> Reward
  - [x] 패키지 분리 필요 없음
  - [x] 큰 숫자에 _추가
  - [x] countMap에 사용
  - [x] matchingCount에 해당하는 타입이 없다면 null을 리턴하기 보다 미당첨 타입을 리턴
- 모든 도메인 로직에 test 추가
  - [x] Lottos : 로또의 제약인 숫자의 범위 test 추가
  - [x] Lottos : 로또가 가지는 숫자의 개수 test 추가 -> LottoTest로 변경
  - [x] Reward : fromMatchingCount() 테스트 추가
  - [x] 테스트 코드라고 하더라도 변수명은 이해하기 쉬운 이름으로 지어주기 (예시: expected)

### 3차 TODO LIST
- Lotto
  - [ ] matchingCount는 인스턴스 변수로 가질 필요가 없는 상태. 인스턴스 변수를 제거하고 계산에 의한 결과를 바로 반환하도록 변경
  - [ ] 유효성 검증 메서드는 검증만 수행하도록. 리턴 제거하기.

- LottoFactory
  - [x] lottos 인스턴스 변수 제거. 불필요한 인스턴스화를 막기

- LottoNumbers
  - [ ] Lotto, LottoNumbers 각 숫자의 범위 1~45를 6개를 가져야한다는 책임이 중복 -> 차이 명확히, 중복 삭제 필요
  - [ ] 상수 변수명 대문자로
  - [ ] Factory에서 로또에서 사용되는 숫자들을 관리하도록
  - [ ] LottoNumbers의 책임이 shuffle이라면 이름을 LottoNumberShuffler 라고 지으면 좋을 것

- Profit
  - [ ] calculateProfitRate : 미당첨은 filter할 필요 없음

- Rank
  - [ ] matchingNumberCount 변수는 Reward로 대체
  - [ ] EnumMap을 활용하면 Rank객체 대체 가능

- 당첨번호
  - [ ] 로또번호와 동일한 제약 추가 필요

- LottoTest
  - [ ] size_exception_test: 예외 검증시에는 테스트할 대상만 인자로 전달 (validate를 수행하지 않으면 6개가 아닌 개수로 로또를 생성할 수 있을 것)

- RankTest
  - [ ] EnumSource를 활용해 중복 코드를 제거

- LottoNumberTest
  - [ ] shuffle test 검증 방식 변경

```java
assertThat(lottoNumberList.shuffle()).isNotEqualTo(lottoNumberList.shuffle());
```

