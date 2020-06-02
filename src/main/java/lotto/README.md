# 로또

## 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.
- 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
    - 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

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
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
    - 사용자가 잘못된 값을 입력했을 때 java exception으로 에러 처리를 한다.
    - java8에 추가된 Optional을 적용해 NullPointerException이 발생하지 않도록 한다.

## Todo List

### Lotto

- Price: 금액(가격)
    - [X] 로또 구매자는 로또 구매를 위해 Price를 지불할 수 있다.
    
- LottoIssueRequest: 로또 발급 요청
    - [X] 수동 발급 번호와, 구입 Price를 가질 수 있다.
    
- LottoNumber: 로또 개별 번호
    - [X] 로또 번호 하나는 1~45 사이의 값을 갖는다.
    - [X] 로또 번호가 1~45 사이의 값인지 검증할 수 있다.

- LottoNumbers: 로또 1장
    - [X] 로또 1장은 LottoNumber 6개를 갖는다.
    - [X] LottoNumber 6개를 갖는지 검증할 수 있다.
    - [X] LottoNumber 6개 중 중복된 값이 있는지 검증할 수 있다.
    - [X] LottoNumber와 비교하여 존재하는 갯수를 리턴할 수 있다.
    
- LottoTicket: 로또 티켓(묶음) 
    - [X] LottoTicket 한 장은 LottoNumbers 하나 이상을 갖는다.
    - [X] WinningNumbers, 보너스 볼(LottoNumber)을 입력 받아 매칭 결과를 반환할 수 있다.
    - [X] LottoIssueRequest와 NumberGenerator를 요청 받아 LottoTicket을 생성할 수 있다.

- NumberGenerator, LottoNumberGenerator: 로또 번호 자동 생성
    - [X] 1~45 사이의 무작위 값으로 구성된 6개의 숫자를 반환할 수 있다.

- WinningLotto: 지난 주 당첨 번호
    - [X] 지난 주 당첨 LottoNumbers를 갖는다.
    - [X] LottoNumbers와 비교하여 존재하는 갯수를 리턴할 수 있다.

- LottoRank: 로또 랭크
    - [X] 일치하는 갯수에 대한 상금액을 갖는다.
    - [X] 5개 일치, 보너스 볼 일치하는 2등을 갖는다.

- WinningStatistics: 당첨 통계
    - [X] LottoRank를 반환할 수 있다.
    - [X] 지불 Price 대비 수익률을 확인할 수 있다.

- InputView
    - [X] 구입 Price를 입력 받을 수 있다.
    - [X] WinningNumbers를 입력 받을 수 있다.
    - [X] 보너스 볼을 입력 받을 수 있다.
    - [X] 수동 로또 발급 수를 입력 받을 수 있다.
    - [X] 수동 로또 번호를 발급 갯수만큼 입력 받을 수 있다.
    
- OutPutView
    - [X] 수동 로또 구매 갯수와 자동 로또 구매 갯수를 출력할 수 있다.
    - [X] LottoTicket을 출력할 수 있다.
    - [X] WinningStatistics를 출력할 수 있다.
