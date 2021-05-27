# 로또 - 2단계
## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.


# 로또 - 3단계
## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

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
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다

## 기능 구현 목록
* [x] 사용자로부터 로또 구입 금액을 입력을 받는다.
  * [x] 로또 판매기가 입력한 금액으로 구매 가능한 만큼의 로또 게임을 생성 한다.
    * [x] 로또 게임 생성기가 로또 게임을 만든다.
      * [x] 각 로또 게임은 중복 되지 않는 무작위 숫자 6개를 가진다.
        * [x] 로또 번호는 1부터 45까지 이다.
  * [x] 예외: 사용자가 입력한 금액이 한 장당 구입 금액보다 낮을 경우 **'입력한 금액이 낮아 로또 구매가 불가합니다.'** 메시지를 출력한다.
  * [x] 예외: 사용자가 입력한 금액이 문자 혹은 마이너스를 입력할 경우 **유효하지 않은 금액을 입력하셨습니다.** 란 메시지를 출력하며 재 입력을 요청한다.
* [x] 사용자가 구매한 로또 게임 구매 수를 출력한다.
* [x] 사용자가 구매한 로또 게임의 세부 번호 구성을 출력한다.
* [x] 사용자가 당첨 번호를 직접 입력한다.
* [x] 사용자가 구매한 로또 게임의 결과를 산출한다.
* [x] 로또 게임의 결과 중 3개 이상 일치하는 것에 한해 결과를 출력.
  * [x] 3개 일치 : 5,000원 - 5천원
  * [x] 4개 일치 : 50,000원 - 5만원
  * [x] 5개 일치 : 1,500,000원 - 150만원
  * [x] 6개 일치 : 2,000,000,000원 - 20억
* [x] 총 당첨금과 로또 구매로 지출한 금액을 비교해 수익률을 산출한다.
  (소숫점 두번째 자리까지 표시하며 세번째 자리에서 올림한다.)
  
## 클래스 설계
### 키워드
- [C] 클래스
- [I] 인터페이스
- [AC] 추상 클래스

### [C] Rank 등수
일치 하는 로또 번호 갯수 별 상금 정보를 담는 Enum 클래스

### [C] LottoNumber 로또 번호
1부터 45번까지 로또 번호를 담는 클래스.

### [C] LottoGame 로또 게임
1,000원으로 구매 가능한 로또 게임 클래스이다.
6개의 로또 번호와 등수 정보를 가진다.

### [C] LottoGames 로또 게임들
사용자가 구매한 로또 게임을 가지는 1등급 컬렉션 클래스이다.

### [C] PurchaseMoney 구매금액
사용자가 로또를 사기 위해 입력한 구매 금액

### [C] WinningLottoNumber 우승 로또 번호
우승 기준이 되는 로또 번호이다.
번호 일치 갯수를 산정해준다.

### [C] LottoResult 로또 결과
로또 확인 결과 출력. 

### [C] LottoApplication 로또 애플리케이션
로또 애플리케이션의 메인 클래스

### [C] LottoInputView 로또 입력 뷰
사용자에게 입력을 받는 뷰

### [C] LottoInputView 로또 출력 뷰
사용자에게 출력을 해주는 뷰

# 로또 - 4단계
## 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다. 

## 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 8: 일급 콜렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

## 기능 구현 목록
- [x] 2등(5개 + 보너스 번호)에 대한 당첨금 정보 구현
- [ ] 보너스 번호를 입력 받을 수 있도록 함
- [ ] 고객이 구매한 로또 번호와 당첨금 번호를 바탕으로 2등 판별
- [ ] 총 당첨액 통계에 2등(5개 + 보너스 번호)에 대한 정보 추가