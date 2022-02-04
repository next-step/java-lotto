# 📌 문자열 덧셈 계산기

## 기능 요구 사항

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3"
=> 6, "1,2:3" => 6)

앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를
들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 구현 사항

- [X] 사용자의 입력을 받음 - view.InputView
    - [x] 구분자 입력 - getDelimiter
        - [X] 입력 형식이 맞는지 (//*)
        - [X] custom 구분자가 있는지
            - 없으면 : ',' , ':'
    - [X] Delimiter
        - [X] 첫 글자와 마지막 글자가 숫자만 아니면 OK
    - [x] Delimiters
        - [X] 구분자들을 List<String> 으로 반환
    - [X] 식 입력 - getExpression
        - [X] 입력은 공백이면 0을 반환("", " ")

- [X] 식 파싱 - ExpressionParser()
    - parse(expression)
    - 식을 구분자로 파싱해서 Numbers 반환. (List<Number>)
    - Number
        - [X] 구분자가 아닌 숫자 이외의 문자가 포함되어 있으면 안된다.
        - [X] 숫자는 양수.

- [X] 계산기 - Accumulator
    - Numbers 순회하며 덧셈.

- [X] 결과 출력 view.ResultView


# 📌 로또 (자동)
### 로또 규칙
- 1등 당첨번호 6개 숫자일치
- 2등 당첨번호 5개 숫자일치 + 보너스 숫자일치
- 3등 당첨번호 5개 숫자일치
- 4등 당첨번호 4개 숫자일치
- 5등 당첨번호 3개 숫자일치

- 로또 1장의 가격은 1000원이다.

## 구현 사항
- [X] 구입할 금액 입력받기 - InputView.inputBudget
- [X] 예산 관리 - Budget
  - [X] 불필요한 공백 제거.
  - [X] 공백 입력을 허용하지 않음.
  - [X] 숫자만 입력 허용.

- [X] 로또번호 - LottoBalls
  - [X] 1 ~ 45 까지 List<Integer> 형식으로 로또 번호 관리.

- [X] 구매한 로또 번호 발급 - Lottos.createAutoLottos
  - [X] 1000원 단위로 로또 개수 발급. (ex: 14500 원 = 14장)
  - [X] 6개의 랜덤 로또 번호를 생성한다.
  - [X] Lotto(List<Integer>)

- [X] 당첨 번호 + 보너스볼 - CorrectNumbers
  - [X] 당첨 번호와 보너스볼은 서로 중복되지 않는 값이어야 함.
  
- [X] 당첨 번호  - WinningNumbers 
  - [X] 불필요한 공백 제거.
  - [X] 공백 입력을 허용하지 않음.
  - [X] 숫자와 구분자를 제외한 입력을 허용하지 않음.
  - [X] 연속된 구분자의 입력을 허용하지 않음.
  - [X] 숫자는 반드시 6개만 입력되어야 함.
  - [X] 1 ~ 45 범위의 숫자.
  - [X] 구분자를 기준으로 숫자 분리.
  
- [X] 보너스볼 - BonusNumber
  - [X] 불필요한 공백 제거.
  - [X] 공백 입력을 허용하지 않음.
  - [X] 숫자만 입력 가능하고, 반드시 1개만 입력되어야 함.
  - [X] 1 ~ 45 범위의 숫자.
    
- [x] 로또 등수 구하기 - Judge
  - [x] 로또 번호가 몇개 맞았는지 확인. - lottos.matchNumber
  - [x] 보너스번호 확인. - lottos.containsBonusNumber
  - [x] 맞은 개수가 몇등인지 확인. - LottoRank.getRank

- [x] 로또 결과 통계 만들기. - Statistics
  - [x] 몇등이 몇개인지 확인. Statistics.getRankCounts
  - [x] 총 수익률이 얼마인지. (기준 1) Statistics.getProfitRate

- [X] 출력 - PrintView
  - [X] 구매한 로또 수 출력. - PrintView.printNumberOfLotto
  - [X] 자동 생성된 로또 번호 출력. PrintView.printLottoNumber
  - [X] 당첨 통계 출력. - PrintView.printRankCounts
  - [X] 수익률 출력. - printView.printProfitRate