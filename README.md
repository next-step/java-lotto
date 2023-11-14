# 로또
## 1단계 - 문자열 계산기
- [x] 사용자가 입력한 문자열을 공백으로 분리한다.
- [x] 사용자가 입력한 문자열의 요소가 공백이면 예외를 던진다.
- [x] 사용자가 입력한 문자열의 숫자 자리가 실수가 아닌 경우 예외를 던진다.
- [x] 사용자가 입력한 문자열의 연산 기호 자리가 (+, -, *, /)가 아닌 경우 예외를 던진다.
- [x] 사용자가 입력한 문자열을 사칙연산 한다.
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- [x] 나머지 연산의 경우 소수점 셋째자리에서 반올림한다.
- [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
- [ ] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.(없는 경우는 시간남으면 진행시켜)
- [ ] 분리된 문자열의 자리수가 16자리(23.99999999999999 or 234.9999999999999)를 초과하는 경우 예외를 던진다.(정확도의 문제) -> 가장 마지막에

## 2단계 - 로또(자동)
### 기능 목록
- [ ] 사용자는 구입 금액을 입력한다. - InputView
- [ ] 구입 금액은 천원 단위이다. -> 천원 단위가 아닌 경우 예외를 발생시키고 재입력 받는다. - InputView
- [ ] 구입 금액을 천원으로 나눠 구매 개수를 계산한다. - InputView
- [ ] 계산된 개수만큼 로또 객체를 생성한다. -> 일급 컬렉션 활용 - Lottos, Lotto
- [ ] 로또 객체는 6개의 오름차순으로 정렬된 숫자를 속성으로 가진다. - Lotto
- [ ] 로또 객체를 생성할 때는 Collections.shuffle()을 활용해 6개의 난수를 인자로 받는다. -> util로 사용할 것인지 고민 필요 - LottoNumber
- [ ] 로또 객체들이 생성이 완료되면 당첨번호를 입력 받는다. - InputView
- [x] 입력 받은 당첨번호와 로또 객체가 가지는 숫자를 비교한다. - LottoController, Lottos, Lotto
- [x] 일치하는 개수별로 그룹핑하여 객체를 카운팅한다. - Lottos
- [ ] 3개 일치(5,000원), 4개 일치(50,000원), 5개 일치(1,500,000원), 6개 일치(2,000,000,000원) 각각 카운팅된 개수와 금액을 곱해 총수익을 계산한다. 
- [ ] 계산된 총 수익과 입력 받은 구매 금액을 나눠 총 수익률을 계산한다.

### 클래스 목록
- [x] Number - 로또 번호 하나를 저장하는 원시 값 포장 클래스. 숫자를 저장하는 필드를 가지고, 숫자의 범위를 검증하는 행위를 한다.
- [x] Numbers - 로또 번호 6개를 컬렉션 필드로 가지는 일급 컬렉션. 당첨번호와 자신이 가진 숫자가 일치하는 지 검증하는 행위를 한다.
- [x] Lotto - Numbers를 속성으로 가진다. 당첨번호와 자신이 가진 숫자가 일치하는 지 검증하는 행위를 한다.
- [x] Lottos - Lotto객체를 컬렉션으로 가지는 일급 컬렉션. Lotto객체가 가지고 있는 숫자와 당첨번호가 일치하는 지 검증하는 행위를 한다.
- [x] LotteryRank - 등수 별 상금을 상수로 가지는 enum.
- [x] RankCount - 등수, 등수 별 당첨 로또 개수를 필드로 가진다.
- [x] RankCountGroup - RankCount의 컬렉션을 필드로 가진다. 등수를 인자로 받아 해당하는 등수의 당첨 개수를 반환, 없으면 0을 반환하는 행위를 한다.
- [ ] LottoNumber - 1~45범위를 가지는 난수 6개를 반환하는 행위를 한다.
- [ ] ProfitCalculator - 로또로 얻은 수익, 수익률을 계산한다.
- [ ] LottoGame - Lotto 게임을 진행한다. Lottos, ProfitCalculator를 필드 변수로 가진다. 로또 번호 일치, 수익률을 계산하는 행위를 한다.
- [ ] LottoGameController - LottoGame, View를 관리한다. 
- [ ] LottoGameApp - 로또 게임 애플리케이션을 실행한다.