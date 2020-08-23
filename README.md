# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1 문자열 덧셈계산기 (기능요구사항)

- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능구현
- [x] 쉼표, 콜론: 을 구분자로 갖는 문자열을 분리
- [x] 분리된 문자열을 합을 구하는 기능
- [x] 커스텀 구분자를 지정
- [x] 입력값이 숫자가 아닐경우 예외 처리
- [x] 입력값이 음수인 경우 예외 처리

## Step2 로또 - 자동 (기능요구사항)

- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급
- [x] 로또 1장의 가격은 1000원

### 기능구현
- [x] InputView - 구입금액을 입력하기위한 InputView
- [x] InputView - 당첨번호를 입력하기위한 InputView
- [x] ResultView - 구입후 당첨번호를 출력하기위한 ResultView
- [x] ResultView - 당첨통계를 출력하기위한 ResultView
- [x] 로또번호 자동생성기능 - Collections.shuffle() 이용
- [x] 당첨된 로또의 등수별 갯수와 수익률을 관리하는 기능

## Step3 진행전 step2 피드백 수정사항
- [x] 상수인 변수는 final 선언하기
- [x] 내용이없는 생성자일 경우 클래스변수영역에서 초기화하기
- [x] 로또결과화면 스트림수정해보기


## Step3 로또(2등) (기능요구사항)

- [ ] 2등을 위해 추가번호를 하나더 추첨한다.
- [ ] 당첨 통계에 2등도 추가한다.

### 기능구현
- [ ] InputView - 보너스번호도 추가로 입력받는다.
- [ ] ResultView - 보너스번호 통계로 추가로 출력한다.
- [ ] WinnerLottoNumber객체를 따로 분리한다.
- [ ] 2등을 관리하기 위한 Enum을 수정한다.

