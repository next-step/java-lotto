# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1. 문자열 덧셈 계산기
### 제약 조건
- 덧셈만 가능하다.
- 기본 동작 모드에서는 `,`, `:`로 구분된 숫자를 구분한다.
- 커스텀 구분자 모드가 있다.
- 숫자 이외의 값은 계산할 수 없다.
- 양수만 계산할 수 있다.

### Todo-list
- Number(class)
    - 문자열 계산기에서 사용할 숫자를 안전하게 관리하는 래퍼 객체
    - [X] 문자열을 입력받아 객체를 생성할 수 있다.
    - [X] 정합성 검증을 진행한다.
        - [X] 입력값이 비었거나 null인 경우 예외 발생
        - [X] 양수가 아닌 경우 예외 발생
    - [X] 같은 타입의 객체끼리 더하기가 가능하다.
- Numbers(class)
    - Number 컬렉션을 관리하는 일급 컬렉션
    - [X] Number 컬렉션을 인자로 받아 객체를 생성할 수 있다.
    - [X] 속한 Number 오브젝트의 합을 구할 수 있다.
- Mode(interface)
    - 계산기 구분자를 결정 짓고 분리하는 객체
- NormalMode(class)
    - Mode 구현체
    - [X] 기본 구분자(, or :)로 주어진 문자열을 나눌 수 있다.
- CustomMode(class)
    - Mode 구현체
    - [X] 커스텀 구분자로 주어진 문자열을 나눌 수 있다.
- ModeSelector(class)
    - 기본 모드, 커스텀 모드 중 어떤 모드로 동작할지 결정하는 객체
    - [X] 입력값이 Custom 모드인지 기본 모드인지 구분할 수 있다.
    - [X] 입력값 구분에 따른 알맞는 Mode 구현체를 반환한다.
- StringCalculator(class)
    - 문자열 덧셈 계산을 수행하는 객체
    - [X] 주어진 테스트 케이스를 충족하는지 확인

## Step1. 피드백
### Todo-list
- [X] 성격이 비슷한 검증문 합치기
- [X] Mode 추상화의 동작 고민하기 (모드를 선택만 할 것인지, 실제 동작까지 진행할 것인지)
- [X] Numbers 오브젝트의 size 메서드 대신 더 직관적인 네이밍의 메서드 사용해보기
- [X] JUnit5 기능을 활용해서 하드코딩 된 테스트 케이스 제거

## Step2. 로또(자동)
### 제약조건
- 로또 한장의 금액은 1000원이다.
- 로또를 구매할 가격을 입력하면 구매 가능한 최대한의 로또 티켓을 발행한다.
- 로또는 자동으로만 구매 가능하다.

### Todo-list
- LottoNumber(class)
    - 로또에서 사용될 로또 번호를 안전하게 래핑하는 오브젝트
    - [X] 숫자를 인수로 받아서 오브젝트를 생성할 수 있다.
    - [X] 숫자의 범위는 1 ~ 45를 벗어날 수 없다.
- LottoTicket(class)
    - 로또 번호 일급 컬렉션
    - [X] LottoNumber 컬렉션을 인자로 받아서 오브젝트를 생성할 수 있다.
    - [X] 컬렉션 크기가 중복 없이 6이어야만 한다.
    - [X] LottoTicket 간 일치하는 LottoNumber의 개수를 계산할 수 있다.
    - [X] 생성 정책에 따라 알맞는 LottoTicket을 생성할 수 있다.
- LottoTicketCreatePolicy(interface)
    - LottoTicket을 생성하는 방법을 정의하는 인터페이스
- AutoCreatePolicy(class)
    - LottoTicketCreatePolicy의 구현체
    - [X] 자동으로 정합성을 지킨 LottoTicket을 만들고 반환한다.
- StaticCreatePolicy(class)
    - LottoTicketCreatePolicy의 구현체
    - [X] 6자리의 숫자 컬렉션을 인자로 받아서 LottoTicket을 생성한다.
- LottoTicketsFactory(class)
    - LottoTickets를 생성하는 객체
    - [X] Moeny를 인수로 받아 구매가능한 최대 수의 LottoTicket 컬렉션을 반환한다.
    - [X] LottoTikcets 일급 컬렉션을 반환하도록 리팩토링
- LottoTickets(class)
    - LottoTicket 일급 컬렉션
    - [X] 속한 LottoTicket 컬렉션을 기반으로 LottoPrize를 계산할 수 있다.
- Money(class)
    - LottoTicket을 구매하기 위한 자원 오브젝트
    - [X] 숫자를 인수로 받아서 객체를 생성할 수 있다.
    - [X] 인수로 받은 숫자가 0 이상인지 정합성을 검증한다.
    - [X] 구매할 수 있는 최대의 LottoTicket 수를 계산할 수 있다.
    - [X] Long 타입과 곱셈 연산이 가능하다.
- Rank(enum)
    - Lotto 당첨 결과를 보여주기 위한 오브젝트
    - [X] 맞춘 LottoNumber 수를 인수로 받아서 알맞는 상품 금액을 알려줄 수 있다.
    - [X] 해당 랭크가 여러개 있을 때의 상금 총합을 계산할 수 있다.
    - [X] 당첨 결과가 없을 경우 꽝을 반환한다.
- LottoPrize(class)
    - 로또 당첨 결과를 통합적으로 관리하는 오브젝트
    - [X] Rank 컬렉션을 인자로 받아 Rank 별로 몇개가 있는지 관리한다.
    - [X] 수익률을 계산할 수 있다.
- BoughtHistoryOutputView
    - 로또 티켓 컬렉션을 사용자에게 보여줄 수 있다.
    - [X] 구매한 금액으로 구매할 수 있는 최대의 LottoTicket 수를 사용자에게 보여줄 수 있다.
    - [X] 구매한 LottoTickets를 인자로 받아서 출력형식에 맞는 String으로 변환한다.
- StatisticsOutputView
    - 로또 당첨 결과(당첨 티켓 수, 수익률)을 사용자에게 보여줄 수 있다.
    - [X] LottoPrize를 인자로 받아서 출력형식에 맞는 String으로 변환한다.
- MoneyInputView
    - 사용자가 구매할 로또 금액을 입력받을 수 있다.
    - [X] 1000원 이하의 금액을 입력할 경우 예외를 발생시킨다.
- WinningTicketInputView
    - 사용자로부터 당첨 티켓 로또 번호들을 입력받을 수 있다.
    - [X] 입력받은 문자열로 당첨 티켓 도메인을 생성할 수 있다.

## Step2. 피드백 반영
- [X] 로또 숫자 관리를 중복해서 하지 않도록 개선 (힌트: LottoNumber 캐싱 활용)
- [X] 상수 사용 시 경계값 범위의 의미가 같도록 개선
- [X] HashTable을 굳이 쓸 이유가..?
- [X] LottoPrize의 static 메서드에 대한 고민
- [X] LottoTicket 간 서로 비교하는 메서드 네이밍 고민
- [X] LottoTicket 간 비교 후 Rank를 반환하는 게 어떤지 고민
- [X] Rank 내 숫자 리터럴 표현을 가독성이 좋도록 개선
- [X] Rank 내 금액과 설명을 한군데서 관리할 수 있도록 검토
- [X] Rank enum의 객체 선언 순서가 의미가 있도록 재정렬
- [X] assertJ 기능 적극 활용하기
- [X] LottoTickets 일급 컬렉션에서 LottoPrize에 대한 임의의 수정 가하지 않도록 수정

## Step3. 로또(2등)
### 제약 조건
- 로또 2등을 당첨 결과에 추가한다.
  - 로또 2등과 3등은 모두 다섯개의 숫자를 맞춘 경우를 칭한다.
  - 단, 보너스 숫자와 일치하는 경우는 2등으로 취급한다.
- 로또 2등 추가에 따라 사용자에게 보여주는 결과도 바뀌어야 한다.

### Todo-list
- Rank(enum)
  - 로또 2등을 추가한다.
  - [X] 2등 오브젝트를 추가한다.
  - [X] 당첨 결과 찾는 메서드에 보너스 볼 유무 인자도 추가한다.
  - [X] Rank를 찾은 뒤 최종적으로 내보내기 전 2등과 3등 여부를 확인하고 내보낸다.
  - [X] Description 제거
    - 사용자에게 보여주기 위한 기능이므로 view에서 처리하도록 개선
    - 2등 당첨 결과를 보여주기 위한 요구사항이 복잡해졌으며, Rank에서 판단할 내용은 아니라 판단됨.
- LottoTicket(class)
  - Rank에 2등 추가된 변경사항 반영
  - [X] Rank를 계산하는 메서드 제거
    - 해당 메서드는 새로운 오브젝트 WinningTicket으로 이관 예정
- LottoTickets(class)
  - 당첨 결과에 보너스 넘버까지 반영하여 2등을 판별할 수 있도록 기능 변경
  - [X] 로또 당첨 결과를 계산하는 메서드에서 WinningTicket을 인자로 받아서 계산하도록 기능 변경
- LottoPrize(class)
  - 로또 2등 계산 방식이 바뀜에 따라 순위별 달라진 상금 정보를 반영한다.
  - [X] 초기화 과정에 로또 5등에 대한 정보를 추가한다.
  - [X] 로또 추첨 결과를 확인하는 테스트에 상금 변동에 따른 변동된 수익률을 확인한다.
- WinningTicket(class)
  - 당첨 티켓의 역할을 수행하는 오브젝트
  - [X] LottoTicket(당첨 티켓), LottoNumber(보너스 넘버)를 인자로 받아서 생성할 수 있다.
      - [X] 보너스 넘버가 LottoTicket에 포함된 경우 예외 발생
  - [X] 일반 LottoTicket과 비교하여 당첨 여부를 확인할 수 있다.
- LottoRunner(class)
  - [X] 당첨 티켓을 받을 때 보너스 번호도 받아서 WinningTicket을 만들 수 있도록 기능 개선
- InputView(class)
  - [X] 보너스 번호를 사용자로부터 입력받을 수 있도록 기능 추가
- BonusNumberInputView(class)
  - [X] 보너스 번호를 사용자로부터 입력받을 수 있도록 기능 추가
- OutputView(class)
  - [X] 사용자에게 보너스 번호를 요청할 수 있도록 문구 출력 기능 추가
- StatisticsOutputView
  - [X] 당첨 종합 결과에 2등 내용을 포함해서 보여주도록 변경

## Step3. 피드백 반영
- [X] 이상한 변수명 수정하기
- [X] LottoPrize에서 등수 계산 관련 부분을 순서 보장하는 Map 타입으로 바꿔보기
  - 관련해서 Rank 클래스의 불필요한 속성도 제거하기
- [X] 불필요한 래퍼 클래스 대신 primitive 타입 적용하기

## Step4. 로또(수동)
### 제약조건
- 모든 원시값을 포장한다
- 사용자가 수동으로도 로또 구매를 할 수 있어야 한다.
- 수동으로 구매한 로또 외에는 남은 금액을 모두 자동으로 구매 진행한다.
- 로또 티켓 구매 결과는 수동과 자동 모두 보여줘야 한다.

### Todo-list
- Rank(class)
  - [X] 제약 조건을 지키기 위해 원시 타입 numberOfMatchedNumber를 래퍼 클래스로 대체한다.
- MatchedNumber(class)
  - 당첨 티켓과 로또 티켓간의 일치하는 LottoNumber의 수를 관리하는 클래스
  - [X] 6을 넘길 수 없다.
  - [X] 음수가 존재할 수 없다.
- LottoTickets(class)
  - [X] LottoTickets끼리 내용물을 합칠 수 있다.
- Money(class)
  - [X] 수동으로 구매한 로또 티켓의 수만큼 금액을 빼는 기능 구현
- OutputView(class)
  - [X] 수동으로 구매할 로또 수를 요청하는 메시지를 출력할 수 있다.
  - [X] 수동으로 구매할 로또 티켓 번호를 요청하는 메시지를 출력할 수 있다.
- InputView(class)
  - [X] 수동으로 구매할 로또 티켓 수를 입력받을 수 있다.
- NumberOfStaticLotto(class)
  - 사용자로부터 안전하게 수동으로 구매할 로또티켓 수를 입력받기 위한 오브젝트
  - [X] 음수로 오브젝트 생성 시도 시 예외가 발생한다.
- WinningTicketInputView(class)
  - [X] 수동 로또 티켓 입력 재사용 시에도 어색하지 않도록 이름을 변경한다.
- BoughtHistoryOutputView(class)
  - [X] 수동으로 구매한 로또 티켓수와, 자동으로 구매한 로또 티켓 수를 구분해서 사용자에게 보여줄 수 있다.
- LottoRunner(class)
  - [X] 사용자로부터 수동으로도 로또 티켓을 입력받을 수 있도록 변경된 요구사항 반영
