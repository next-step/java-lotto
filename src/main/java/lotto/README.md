# 로또

## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

## 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

## Todo List

### Lotto

- Price: 금액(가격)
    - [X] 로또 구매자는 로또 구매를 위해 Price를 지불할 수 있다.
    
- LottoSeller: 로또 판매자
    - [X] LottoSeller는 구매자가 지불한 Price만큼 LottoNumbers를 가진 LottoTicket을 발급할 수 있다.

- LottoNumber: 로또 개별 번호
    - [X] 로또 번호 하나는 1~45 사이의 값을 갖는다.

- LottoNumbers: 로또 1장
    - [X] 로또 1장은 LottoNumber 6개를 갖는다.
    - [X] WinningNumbers와 비교하여 존재하는 갯수를 리턴할 수 있다.  

- LottoTicket: 로또 티켓(묶음) 
    - [X] LottoTicket 한 장은 LottoNumbers 하나 이상을 갖는다.
    - [X] 입력받은 Price 만큼 LottoTicket을 생성할 수 있다.
    - [ ] WinningNumbers, 보너스 볼(LottoNumber)을 입력 받아 매칭 결과를 반환할 수 있다.

- NumberGenerator, LottoNumberGenerator: 로또 번호 자동 생성
    - [X]  1~45 사이의 무작위 값으로 구성된 6개의 숫자를 생성한다.

- WinningNumbers: 지난 주 당첨 번호
    - [X] 지난 주 당첨 LottoNumbers를 갖는다.

- LottoGame: 로또 게임 실행기
    - [X] LottoTicket, WinningNumbers를 전달받아 로또 게임을 진행한다.

- LottoRank: 로또 랭크
    - [X] 일치하는 갯수에 대한 상금액을 갖는다.
    - [ ] 5개 일치, 보너스 볼 일치하는 2등을 갖는다.

- WinningStatistics: 당첨 통계
    - [X] LottoRank를 반환할 수 있다.
    - [X] 지불 Price 대비 수익률을 확인할 수 있다.

- InputView
    - [X] 구입 Price를 입력 받을 수 있다.
    - [X] WinningNumbers를 입력 받을 수 있다.
    - [ ] 보너스 볼을 입력받 을 수 있다.
    
- OutPutView
    - [X] 로또 구매 갯수와 LottoTicket을 출력할 수 있다.
    - [X] WinningStatistics를 출력할 수 있다.
