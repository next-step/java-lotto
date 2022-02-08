# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

# 문자열 덧셈 계산기 🧮

## 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3"
  => 6, "1,2:3" => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//a”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 예를 들어 “//1\n,;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 목록

### Calculator - 문자열 계산기

- [x] 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. - Calculator#add
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. - Calculator#add
- [x] 찐 계산 - Calculator#add

### DelimiterTokenizer - 구분자 설정

- [x] 구분자 설정 - 기본 : ',', ':', 커스텀 구분자
- [x] 문자열 시작이 "//"이 아니라면, 기본 구분자를 반환한다. (",",":")
- [x] 입력한 값이 "//"으로 시작하면 커스텀 구분자와 기본 구분자를 반환한다.
    - [x] 구분자는 길이가 1을 초과하면 IllegalArgument Exception
    - [x] 구분자는 길이가 0이면 IllegalArgument Exception
    - [x] 커스텀 구분자에 음이 아닌 정수 값이 들어오면 IllegalArgument Exception
    - [x] 커스텀 구분자가 "\n"(개행문자)인 경우 IllegalArgument Exception
    - [x] 구분자를 파악한다. ("//", "\n")

### Parser - 문자열 파싱

- [x] 구분자를 기준으로 나눈다. (숫자)
- [x] 숫자 이외의 값이면 RuntimeException throw (e.g. "1:a:3", "1::3:", ":1:2", "1:2:")
- [x] 음수 값이면 RuntimeException throw

# 로또 (자동)

## 기능 요구사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 기능 목록

### InputView

- [x] 구입금액 입력
- [x] 당첨 번호 입력
- [x] 보너스볼 입력

### ResultView

- [x] 로또 개수 출력 안내
- [x] 로또 개수만큼 출력
- [x] 당첨 통계
    - [x] 3개 일치
    - [x] 4개 일치
    - [x] 5개 일치
    - [x] 5개 일치, 보너스 볼 일치
    - [x] 6개 일치
    - [x] 총 수익률

### Validator - 입력 검증

- [x] 구매 금액에 대한 최솟값 검증
    - [x] 금액이 숫자가 아닐 경우, IllegalArgument Exception ("[ERROR] 숫자만 입력해주세요")
    - [x] 금액이 1000(MINIMUM_MONEY)원보다 작을 경우, IllegalArgument Exception ("[ERROR] 1000원에 1장입니다. 1000보다
      큰 값을 입력해주세요")
- [x] 당첨 번호에 대한 검증
    - [x] 숫자가 아닐 경우, IllegalArgument Exception ("1,2:3,4,5,6")
    - [x] 숫자가 범위 내에 들어오지 않을경우, IllegalArgument Exception
    - [x] 중복되는 것이 있을 경우, IllegalArgument Exception
    - [x] 당첨 번호의 개수가 6이 아닐 경우, IllegalArgument Exception
- [x] 보너스 번호에 대한 검증
    - [x] 숫자가 아닐 경우, IllegalArgument Exception
    - [x] 숫자가 범위 내에 들어오지 않을경우, IllegalArgument Exception
    - [x] 지난 당첨 번호와 중복되는 것이 있을 경우, IllegalArgument Exception

### GeneratorNumber - 번호 생성기

- [x] 랜덤 번호 생성 (1 - 45)

### LottoRaffle - 당첨 확인

- [x] 로또 당첨 확인

### Lotto - 로또

- [x] 번호 (6개)

### WinningLotto - 당첨 로또

- [x] 번호
- [x] 보너스 번호

### Lottoes - 여러 개의 로또

- [x] 로또 생성

### YieldCalculator - 수익률 계산

- [x] 구입 금액 대비 수익률 계산

### LottoResult - 로또 매칭 결과

- [x] 맞춘 개수에 따라 매칭 결과 반환
