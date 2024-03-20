### 4단계 피드백

- [x] LottoMachineValidator -> MoneyValidator renaming
- [x] assertMoney(..) 파라미터 타입, 조건식 수정
- [x] Money 생성자 할당 전에 유효성 검사하도록 수정
- [x] 로또 구매 요청시 OrderRequest (dto) 제거
- [x] LOTTO_PER_MONEY 제약조건을 Money 로 이동
- [x] LottoPaper에 분리했던 자동/수동 구매 로또 필드를 제거하고 하나로 합치기
- [x] 전략패턴 적용해서 자동/수동 로또 구매하도록 리팩토링
    - LottoStrategy 인터페이스
    - AutomaticPurchaseStrategy : 자동 구매 전략
    - ManualPurchaseStrategy : 수동 구매 전략

---

### 4단계 - 로또 (수동)

- [x] 구매 금액 원시값을 포장하는 Money 클래스 생성한다
- [x] 수동으로 구매할 로또 수를 입력받는다
    - 음수는 입력할 수 없다
- [x] 수동으로 구매할 로또 수만큼 로또 번호를 입력받는다
    - 수동 구매 수량은 최대 구매 수량을 초과할 수 없다
- [x] LottoMachine에서는 요청에 따라 수동/자동 구매 로또를 처리하여 반환한다
- [x] 수동/자동 구매 로또 개수와 번호 출력한다
- [x] 수동/자동 로또 포함하여 로또 당첨 결과를 구한다
- [x] 수동 구매 로또 번호 순서 보장되지 않는 이슈
    - Lotto 생성자에서 LinkedHashSet 으로 처리하도록 리팩토링

---

### 3단계 피드백

- [x] Prize 멤버 필드 타입을 EnumMap (구현체)에서 Map(인터페이스)로 변경
- [x] Prize 수익률 테스트시 @EnumSource 사용하여 중복 제거
- [x] WinningInfo -> WinningLotto renaming
- [x] WinningLotto null 테스트 추가
- [x] WinningLotto findRank(..) 를 enum Rank 로 이동
    - WinningLotto와 사용자 Lotto 비교 위한 메소드 추가
- [x] findRank(..) -> findUserRank(..) renaming
- [x] 사용하지 않는 메소드 제거 -- Lotto value()
- [x] LottoNumberDto -> LottoNumberResponse renaming
- [x] LottoNumberResponse 생성자에서 mapper 처리하도록 변경
    - dto의 변경이 domain에 전파되지 않도록 하기 위해서
    - 생성자 타입으로 List\<String\> 과 List\<LottoNumber\> 구분했는데, 런타임시 제네릭 타입 소거로 인해 충돌 감지
    - 정적 메소드로 from(..) 생성하여 해결
- [x] Lotto 클래스(일급컬렉션) 멤버 필드 타입을 List 에서 Set으로 변경
- [x] Prize 생성자 추가 -> List\<Rank\> 타입을 받음
    - 테스트에서 팩토리 메소드 만든게 의미 불명한 것으로 파악됨
- [x] model 에서 LottoNumberResponse (dto) 에 대한 의존성 제거 -> controller에서 처리하도록 수정
- [x] enum Rank findUserRank(..) 파라미터 원시 값을 받도록 리팩토링
- [x] enum Rank에 boolean matchBonus 상태 추가, 중복 메소드 제거

---

### 3단계 - 로또(2등)

- [x] Rank에 로또 2등에 대한 정보를 추가한다
- [x] 보너스 번호를 입력 받는다
    - 이때 보너스 번호는 당첨 번호와 중복되어서는 안된다
    - (참고) 당첨 번호 5개를 맞추고, 보너스 볼을 포함하는 경우에만 2등이 된다
- [x] 보너스 번호를 포함한 당첨 결과를 구한다 -- WinningInfo findRank(..)
- [x] 당첨 결과 출력시 2등 포맷을 포함하도록 한다

---

### 2단계 피드백

- [x] LottoNumbers -> LottoNumberFactory renaming
- [x] 구매 수량이 0인 경우 예외 반환하도록 변경
- [x] Lotto 클래스 가변인자 생성자 제거, 테스트용 팩토리 추가
- [x] 팩토리 생성, matches() 파라미터 타입을 LottoNumber 리스트에서 Lotto로 변경
- [x] 당첨 번호 매칭 결과를 EnumMap으로 반환하도록 변경
- [x] 로또 당첨 정보와 수익률 가지는 Prize 클래스 추가
- [x] 구매 로또 출력시 LottoNumberDto 리스트 전달하여 출력하도록 변경
    - OrderResponse 삭제

---

### 2단계 -로또 (자동)

LottoNumber

- [x] 로또 번호를 가진다
- [x] 로또 번호는 1 ~ 45의 수이다.
- [x] 범위를 벗어날 경우 InvalidLottoException 을 던진다
- [x] 로또 객체가 같은지 비교 가능하다 (동등성)

Lotto

- [x] LottoNumber 컬렉션을 가지는 일급 컬렉션
- [x] LottoNumber 6자리 가진다
    - [x] LottoNumber 입력값이 비어있거나, 6개가 아닌 경우 InvalidLottoException 던진다
- [x] 주어진 번호와 로또 번호를 매칭하여 일치하는 개수를 반환한다
    - ① 하나의 LottoNumber와 비교하는 경우 -- match()
    - ② 여러 개의 LottoNumber와 비교하는 경우 -- matches()

LottoMachine

- [x] 구입 금액만큼의 로또 개수를 계산하여 로또를 반환한다
    - 로또 한장 당 1,000원
- [x] 6개의 랜덤한 로또 번호를 반환한다

Buyer

- [x] 주어진 금액으로 로또를 구매한다
- [x] 구매한 로또를 확인한다 -- LottoPaper 책임 위임 (confirm())
- [x] 구매한 로또와 당첨번호를 매칭한 결과를 반환한다 -- LottoPaper 책임 위임 (matches())

LottoPaper

- [x] Lotto의 일급 컬렉션
- [x] 보유한 로또 번호를 확인한다
    - 출력 예시 : "[1, 2, 3, 4, 5, 6]"
    - 이때 입력한 인덱스가 유효 범위가 아닌 경우 InvalidLottoException 던진다
- [x] 당첨 번호와 보유한 로또 번호를 매칭한다
    - 결과는 Map 자료 유형으로 응답

Rank

- [x] 당첨 볼 갯수, 당첨 보상을 가진다
- [x] 수익률을 계산한다

---

### 1단계 - 문자열 계산기

```text
[기능 요구사항]
- 사용자 입력 문자열 값에 따라 사칙연산을 수행하는 계산기를 구현 
- 입력 문자열의 숫자와 사칙 연사 사이에는 반드시 "빈 공백 문자열"이 있다고 가정한다
- "나눗셈의 경우 결과 값을 정수"로 떨어지는 값으로 한정한다
- "사칙연산의 계산 우선 순위가 아닌 입력 값에 따라 계산 순선가 결정"된다
```

#### 기능 구현 목록

1. 유효성 검사

- [x] 입력 값이 null이거나 빈 공백 문자일 경우 -- IllegalArgumentException
- [x] 사칙연산 기호가 아닌 경우 -- IllegalArgumentException
- [x] 연산자의 개수는 (피연산자 - 1) 개수가 맞지 않은 경우 -- IllegalArgumentException
- [x] 연산자의 시작이 숫자가 아닌 경우 -- IllegalArgumentException

2. 사칙연산

- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈

#### 피드백

- [x] 프로덕션/테스트 코드 패키지 분리
- [x] operator, operation 검증 클래스 분리
- [x] enum Operation에서 추상 메서드 대신 함수형 인터페이스 적용
- [x] 피연산자, 연산자를 분리하여 연산식 계산하도록 리팩토링
- [x] OperationWrapper 클래스 제거, 후위 순회로 연산하도록 StringCalculator 클래스 리팩토링
    - 사칙연산의 우선 순위가 없어 순차적으로 후위 순회 연산 처리하기 위해 Stack 대신 Queue 사용
    - 중위 순회 "2 + 3 * 4 / 2" -> 후위 순회 "2 3 4 2 + * /"
        - 사칙연산시 숫자의 경우 Queue 넣음
        - 연산자 만나면 Queue에서 두 개 뽑아서 계산 후 Queue 맨 앞에 추가
        - Queue 남은 숫자가 최종 연산 결과
