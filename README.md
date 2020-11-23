# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

##기능 요구 사항
### 1단계 - 문자열 덧셈 계산기 
StringUtils
1. 빈 문자열 또는 null을 입력하면, true을 반환한다.
2. 문자열을 구분자에 맞게 나눈다(, or : or //''\n)

IntegerUtils
3. 나뉜 문자를 숫자로 바꾼다.
    - 숫자가 음수이면 Excption을 throw한다.

AddCalculator
4. 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
5. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
6. 나누어진 문자를 더한 결과를 출력한다.

### 2단계 - 로또(자동)
LottoGenerator
- 1~45까지 6개의 번호를 생성한다.

ResultView
- 생성된 로또번호를 출력한다.
- 당첨 통계 및 수익률을 출력한다.

InputView
- 구입금액(LottoAmount)을 입력 받는다.
- 지난 주 당첨 번호(WinningNumber)를 입력 받는다.

WinningNumber
- 입력한 당첨 번호에 따른 Exception을 throw한다.
    - 1~45 범위 밖의 수 
    - 숫자가 6개가 아닐 때

LottoAmount
- 로또 금액에 따른 로또 구입 갯수를 반환한다.
- 입력한 금액에 따른 Exception을 throw 한다.
    - 음수
    - 1000원 이하의 금액
    
LottoGame
- 입력받은 당첨 번호로 1,2,3,4등 당첨 통계를 반환한다. 

utils.Calculator
- 구입금액과 당첨금액을 바탕으로 수익률을 계산한다.

##TODO
13. MVC 형태로 정리한다.

##DONE
1. 구입금액(LottoAmount)을 입력 받는다.
2. 로또 금액에 따른 로또 구입 갯수를 반환한다.
3. 입력한 금액에 따른 Exception을 throw 한다.
    - 1000원 이하의 금액
4. 1~45까지 6개의 번호(LottoNumbers)를 로또 구입 갯수만큼 생성한다.
5. 생성된 로또번호를 출력한다.
6. 지난 주 당첨 번호(WinningNumber)를 입력 받는다.
7. 입력한 당첨 번호에 따른 Exception을 throw한다.
    - 1~45 범위 밖의 수 
    - 숫자가 6개가 아닐 때
8. 생성된 로또 번호를 당첨 번호와 비교하여 Rank를 구한다.
9. 구입금액과 당첨금액을 바탕으로 수익률을 계산한다.
10. 당첨 통계 및 수익률을 출력한다.
11. MainSimulator 개발
12. MainSimulator 버그 수정