# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기 기능 요구 사항

- [x] 계산식을 입력받을 수 있다. - calculator.view#InputView#readFormula
- [x] 빈 문자열 또는 `null` 값을 입력할 경우 0을 반환해야 한다. - calculator.util#validateInput#isEmptyOrNull
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. - calculator.domain#Parser#getOneNumberToString
- [x] 숫자 두개를 쉼표(`,`) 구분자로 입력 받을 수 있다. - calculator.domain#Parser#splitStringToNumber
- [x] 구분자를 쉼표(`,`) 이외에 콜론(`:`)을 사용할 수 있다. - calculator.domain#Parser#
- [x] 두 숫자의 합을 반환한다. - calculator.domain#StringCalculator#add
- [x] `//`와 `\\n` 문자 사이에 커스텀 구분자를 지정할 수 있다. - calculator.domain#Parser#customSplit
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 문자열 계산기에 음수를 전달하는 경우 `RuntimeException` 예외 처리를 한다. - calculator.util#validateCalculator

## 로또(자동) - step1 기능 요구 사항

- [x] 구입금액을 입력받을 수 있다. lotto.view#InputView#readPrice
- [x] 로또 한 번은 1000원이다. lotto.domain#Lotto
- [x] 로또는 한 장을 발행할 수 있다. lotto.domain#Lotto#generatorLotto
  - 로또 자동 생성은 Collections.shuffle()를 활용한다.
  - Collections.sort()를 활용해 정렬 가능하다.
- [x] 금액에 해당하는 로또를 발행해야 한다. lotto.domain#Lottos#generatorLottos
- [x] 지난 주 당첨 번호를 입력받을 수 있다. lotto.view#InputView#readWinningNumber
  - 예를 들어 1, 2, 3, 4, 5, 6 쉼표를 구분자로 공백을 갖춰 입력해야 한다. 
- [x] 보너스 볼을 입력받을 수 있다. lotto.view#InputView#readBonusNumber
- [x] 로또 당첨 통계를 알 수 있다. lotto.domain#LottoStatistics
  - ArrayList의 contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
- [x] 로또의 총 수익률을 알 수 있다. lotto.domain/Lottos
- [x] UI는 InputView와 OutputView, ResultView에서 작성한다. lotto.view#

## 마감 기한

금요일 18시까지 1차 PR

## 피드백 및 리펙토링 사항

- [x] `"".equals(input)` 보다는 `input.isEmpty()`를 지향하자.
- [x] Parser 메서드 이름 명사에서 동사로 리펙토링.
- [x] `Arrays.asList(splitedFormular.///split(delimiter)).stream()`은 `Arrays.stream(splitedFormular.split(delimiter))`으로 표현 가능하다.
- [x] 해당 리스트에 값을 추가하는 과정이 없으므로, 크기가 고정되는 Arrays의 ArrayList를 사용
- [x] `.subList()`는 메모리 누수 위험이 있다. `.stream().limit()`을 사용해보자.
- [x] IntStream.rangeClosed 사용해보자.
- [x] 번호 생성의 책임은 다른 객체에 위임해보기.
- [x] 객체를 기능별로 나눠 객체의 책임과 역할을 먼저 구현을 하고, 객체들끼리 통신하게 코드를 작성하자.
  - [x] LottoMachine 싱글턴으로 만들기
  - [x] Price (VO)
  - [x] Lottos를 LottoTicket 과 LottoTicketGenerator로 분리하기
    - [x] LottoTicketGenerator
    - [x] LottoTicket
  - [x] LottoMachine.calculateWinningResult 메서드 
    - [x] WinningNumber (VO)
    - [x] LottoMachine에서 lottoPrice, lottoTicket 상태 유지되지 않게 구조 변경
    - [x] LottoStatistics 상태 유지되지 않게 구조 변경
    - [x] LottoStatistics 팩토리 메서드로 변경 및 빌더 패턴 적용 
- [x] 보너스 볼 매칭에 대한 구현이 빠져 있다.
- [x] `.collect(Collectors.toList()).size();` 보다는 `stream count` 지향하자.
- [x] 불필요한 선언이 있다. 메서드에서 로컬변수로 처리해보자.

---

- [x] LottoTicket -> LottoTicketGenerator 인데, LottoTicketGenerator에서 LottoTicket생성하는 것으로 변경 해보기.
- [x] Lotto -> NumberGenerator 에서 lottoGenerator -> Lotto 로 변경
- [x] lottoGenerator에서 generateStrategy 전략 패턴 적용
- [x] Generator 테스트 케이스 작성
- [x] LottoMachine 메서드 네이밍 변경, getLottoPrice() ->  purchaseAmount()
- [x] 메서드 참조 방식 적용
- [x] Price의 티켓 구매가능한 범위 검사 로직을 LottoTicketGenerate으로 이동 
- [x] Statistics 리펙토링
- [x] Enum PrizeGrade refactoring (@FunctionalInterface 사용)

---

- [x] 원시타입 포장하기, LottoNumber
- [x] LOTTO_BONUS_GRADE 제거
- [x] generateLottoTicket, mapToObj 활용
- [x] RATE_OF_RETURN_FORMAT, format 상수로 표현
- [x] WinningNumbers, 미사용 getter 제거
- [x] Int 표기형식 통일성있게 수정
- [x] 상수 네이밍 및 Lotto 사이즈 검증 로직 추가
- [x] WinningNumbers List<LottoNumber>를 Lotto로 포장하기.
- [x] 테스트 케이스 추가
  - [x] LottoNumberTest
  - [x] WinningNumbersTest
- [x] WinningNumbers 중복 검증 로직 삭제 

## 로또(수동) - step2 기능 요구 사항

- [x] 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- [x] 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
- [x] 수동으로 입력된 추첨 번호들이 로또 생성에 포함된다.

## 피드백 및 리펙토링 사항 (Step2) 

- [x] 불필요한 stream 삭제
- [x] anyMatch 및 메서드 참조 활용하기
- [x] `+` 연산자로 문자열을 구성하는 것보다는 `String.format`을 이용해보자.
- [x] `System.out.println(String.format)`을 `System.out.printf`으로 바꿔보자.
- [x] 네이밍을 맴버변수와 동일하게 지어서 bonusNumber가 맴버변수가아닌 매개변수로 적용되는 오류 해결

## multiple authors

```bash
git commit -m "commit message


Co-authored-by: hochan222 <hochan049@gmail.com>
Co-authored-by: YuYangWoo <yuyw0712@naver.com>
```
