# 📌 로또

## 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 구현 요구 사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.

## 기능 구현 사항

- [x] 구입 금액을 입력받는다. (InputView)
- [x] 구매 단위는 1000원 단위이다. (Lotto#buyLottoTickets()) 
- [x] 구입 금액에 맞추어 해당하는 로또를 발급한다. (Lotto#generateLottoTickets())
- [X] 1 ~ 45 범위의 6개의 난수 생성 (Lotto#generateRandoms()) 
- [X] 6개의 숫자들은 중복되지 않는다. (LottoNumbers)
- [x] 지난 주 당첨번호를 입력 받는다. (InputView#)
- [x] 보너스 볼을 입력 받는다. 중복 X (InputView#)
- [x] 로또 번호가 당첨되었는지 여부를 확인한다.(Lotto#compareWithWinning())
  - [x] 당첨에 대한 정보는 enum의 형태로 제공한다. (LottoRank)
- [x] 당첨번호는 보너스볼 한 개를 포함해 7개의 숫자이어야 한다. (WinningNumbers)
- [x] 수익률 및 통계를 계산한다. 소수점 두자리에서 버림 처리 (Lotto#getProfit)
- [x] 당첨 통계를 출력한다. (ResultView#printStatistic())
  - [x] 로또 결과를 map 형태로 받아온다. (Lotto#getWinningResult())
- [x] 수익률을 출력한다. (ResultView#printProfit())

---

# 📌 문자열 덧셈 계산기

## 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3"
  => 6, "1,2:3" => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
- 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는
  세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 구현 사항

- [x] 입력 받기 (InputView)
    - [x] 문자열은 쉼표(,) 또는 콜론(:)은 구분되어야 한다. (Delimiter#delimiters)
    - [x] 커스텀 구분자는 문자열 앞부분의 //와 \n 사이에 위치한다. (Delimiter#findExpression())
    - [x] 커스텀 구분자를 추가한다.(Delimiter#addCustomDelimiter())
    - [x] 구분자를 통해 숫자들을 추출한다. (Delimiter#extractNumberFromExpression())
    - [x] 구분된 문자는 반드시 양수의 숫자여야 한다. (Validator#validatePositiveNumber())
- [x] 구분된 숫자에 대해서 덧셈을 수행한다. (StringCalculator#add())
