# 2단계 - 로또(자동)

## 도메인 및 기능목록

### Paser
- 문자열이 숫자포맷이 아니라면 IllegalArgumentException 예외를 발생한다.
- 문자열을 숫자로 파싱한 결과를 리턴한다.
- 숫자포맷 문자열의 공백을 제거하고 구분자(콤마)로 분리된 숫자 리스트의 크기가 6이 아니라면 IllegalArgumentException 예외를 발생한다.
- 숫자포맷 문자열의 공백을 제거하고 구분자(콤마)로 분리된 숫자 리스트를 리턴한다. (당첨번호)

### Lottos
- 금액만큼의 로또 리스트를 리턴한다.
- 로또 총 당첨 금액을 리턴한다.
- 당첨금액/구매금액 값을 소숫점 2자리까지 표현한 값을 리턴한다.(소숫점 3자리에서 반올림)
- 당첨번호와 당첨번호 포함 갯수를 전달하면 일치하는 로또의 갯수를 리턴한다.
- 로또의 갯수를 리턴한다.
- 로또가 한다도 없는지 여부를 리턴한다.

### Lotto
- 당첨번호 포함 갯수에 따른 당첨정보를 리턴한다.
- 특정 번호가 로또 번호에 포함돼있는지 리턴한다.
- 숫자 리스트와 로또번호를 비교해서 일치 갯수를 리턴한다.

### Winning
- 당첨개수에 해당하는 당첨 금액을 리턴한다.
- 당첨정보가 해당 등수와 일치하는지 여부를 리턴한다.

### Amount
- 두 Amount를 나눈 값을 소수점 2자리까지 표현한다.
- 매개변수 Amount와 비교하여 작으면 -1, 크면1, 같다면 0을 리턴한다.
- 두 값을 뺀 Amount를 리턴한다.
- 
---------

# 1단계 - 문자열 계산기

# 기능 목록
## OperatorEnum
- 앞의 값에서 뒤의 값을 더한다.
- 앞의 값에서 뒤의 값을 뺀다.
- 앞의 값에서 뒤의 값을 곱한다.
- 앞의 값에서 뒤의 값을 나눈다.
- 계산기가 지원하는 연산자인지 확인한다.

## Parser
- 입력 문자열이 비어있으면 IllegalArgumentException 예외를 발생한다.
- 문자열을 구분자로 나눠서 list로 반환한다.
- 사칙연산 순서에 사칙연산 기호가 아닌경우 IllegalArgumentException 예외를 발생한다.
- 숫자 순서에 숫자가 아닌경우 IllegalArgumentException 예외를 발생한다.
- 숫자 순서에 모두 숫자일경우 숫자가 담긴 deque를 리턴한다.
- 연산자 순서에 모두 연산자일경우 연산자가 담긴 deque를 리턴한다.

## Calculator
- 식을 계산한 값을 리턴한다.