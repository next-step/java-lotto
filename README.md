# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 문자열 덧셈 계산기 요구사항
### 기능 요구사항
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능 요구사항 분리 힌트
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

### 프로그래밍 요구사항
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

## 2단계 로또(자동) 요구사항
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 구현할 기능 목록
- [x] 구입 금액을 입력받는다.
- [x] 구입 금액으로 구매 할 수 있는 만큼 로또를 구입한다.
    - [x] 로또의 숫자는 자동으로 선정한다. (숫자범위는 1~45이고 6개를 뽑는 것으로 가정)
- [x] 구입한 로또들의 숫자들을 출력한다.
- [x] 지난 주 당첨 번호를 입력받는다.
- [x] 구매한 로또들과 지난 주 당첨 번호로, 등수별 당첨 여부와 수익이 얼마나 되는지 계산한다.
    - [x] 로또 당첨타입 (LottoWinningRank)을 구분한다.
        - [x] LottoWinningRank는 당첨금액과, 당첨을 확인하는 로직을 갖는다.
        - [x] 당첨번호와 구입한 로또을 입력값으로 주면 어떤 당첨 타입인지 반환한다.
- [x] 당첨 통계를 출력한다.

### 2단계 피드백 사항
- [x] Lotto의 numbers 타입을 Integer -> LottoNumber로 warpping
- [x] LottoFactory 1~45 숫자들 상수처리
    - 상수처리는 하되 LottoNumber.VALID_MIN_NUMBER, LottoNumber.VALID_MAX_NUMBER를 기준으로 초기화 하도록 했습니다. 1~45라는 범위가 변경될 때 LottoFactory의 NUNBERS도 같이 변경되면 좋겠다고 생각했어요! :)
- [x] 멤버변수 최대 3개로 (LottoGame)
    - 멤버변수에 갯수에 대한 고민을 많이 해본적이 없어서 이런식으로 하는게 맞는지 잘 모르겠네요. LottoFactory와 WinningChecker를 하나의 추상화된 이름으로 짓는 네이밍도 어려웠구요. 방법은 올바르게 했는지 혹시 해당 규칙을 지키기 위한 팁이나 방법론이 있는지 궁금합니다!
    - LottoFactory와 WinningChecker는 인스턴스 멤버 변수도 없고 기능이 확장될것 같지 않다고 판단해서 정적타입으로 변경했습니다. 어떤 것 같나요?
- [x] Main과 LottoGame 통합 (LottoGame이 main의 역할)
    - 이 부분은 제가 리뷰를 제대로 이해하고 요약한게 맞을까요?ㅎㅎ
    - LottoGame은 일종의 Controller나 Handler의 역할을 하고 외부에서 의존객체를 주입해주면 좋겠다고 생각했어요. 
    - Main은 어플리케이션의 실행과 의존관계 설정을 하는 역할을 주고 싶었습니다.
    - 위와 같은 이유로 2개의 클래스를 분리하고 싶었어요. :)
- [x] WinningCondition Builder패턴 적절한가 고민해보기
- [x] WinningRank의 description을 view에게 위임하는건 어떨지 고민해보기
- [x] ConsoleInputView 상수와 멤버변수를 개행
- [x] ConsoleInputView getWinningNumbers()의 행동이 적절한가? (view가 검증과 정제를 담당하고 있음)
    - 확실히 Input에서 검증을 하는건 별로 안좋아 보이네요.
    - `input이 무언가의 자료구조를 만들어서 반환하는건 유연하지 못하다고 생각합니다.` 라고 하셨는데, Set<Integer>가 아닌 String을 넘기는게 좋다는 말씀이신가요?
        - 입력된 String을 숫자들로 만드는건 Input이 가져도 되지 않을까요? 특히 ','로 split하는 경우가 Input에 있어야 하는 로직이라고 생각이 들었어요. InputView를 확장한 다른 구현체가 생겨서 다른 입력방식이 생겨도 숫자만 건내주면 되니까요 :)  
- [x] 구입금액이 음수로 입력된 경우 예외
- [x] 1000 -> 1_000으로 통일 
- [x] 테스트 메서드명 카멜케이스로
- [x] createTest_invalidNumberSize()의 @MethodSource를 사용 고민

## 3단계 로또(2등) 요구사항
### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항
- 규칙 8: 일급 콜렉션을 쓴다.

### 3단계 피드백 사항
- [ ] Main과 LottoGame 통합에 대한 고민
- [x] LottoNumber는 원시값 포장 객체입니다. 1 == 1 은 true인데, LottoNumber.from(1) == LottoNumber.from(1)이 되게 하려면 어떻게 해야할까요? 
- [ ] Exception class 생성
- [ ] view와 lottoService는 메소드로 분류하지 않아도 될 것 같아요!
- [x] 보통 원시값 포장 객체는 valueOf 라는 이름의 메소드로 사용합니다.
- [x] 이 부분은 from 메소드에 위임하는게 좋을 것 같아요~
    - 생성자보다 정적메서드가 더 좋아보이는 이유는 어떤건가요? :)
- [x] WinningNumber getter는 불필요할 것 같습니다.
- [ ] LottoService 굳이 인터페이스와 구현부로 분류할 필요는 없지 않을까요?이 