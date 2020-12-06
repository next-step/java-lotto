# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

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
    - [ ] 6자리의 숫자 컬렉션을 인자로 받아서 LottoTicket을 생성한다.
- LottoTicketsFactory(class)
    - LottoTickets를 생성하는 객체
    - [X] Moeny를 인수로 받아 구매가능한 최대 수의 LottoTicket 컬렉션을 반환한다.
- Money(class)
    - LottoTicket을 구매하기 위한 자원 오브젝트
    - [X] 숫자를 인수로 받아서 객체를 생성할 수 있다.
    - [X] 인수로 받은 숫자가 1000 이상인지 정합성을 검증한다.
    - [X] 구매할 수 있는 최대의 LottoTicket 수를 계산할 수 있다.
- Rank(enum)
    - Lotto 당첨 결과를 보여주기 위한 오브젝트
    - [X] 맞춘 LottoNumber 수를 인수로 받아서 알맞는 상품 금액을 알려줄 수 있다.
