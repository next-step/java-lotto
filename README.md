🚀 1단계 - 문자열 계산기

## 기능 요구사항

- [x] 입력값이 null 이거나 빈 공백 문자인 경우 IllegalArgumentException  예외가 발생한다.
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException 예외가 발생한다.
- [x] 입력값에 음수가 포함되어 있는 경우 IllegalArgumentException 예외가 발생한다.
- [x] 사칙연산을 모두 포함한 입력값을 계산하여 반환한다.



🚀 2단계 - 로또(자동)


## 기능 요구사항

- [x]  중복되지 않은 6개의 로또 숫자를 생성한다.
- [x]  해당 갯수만큼 로또를 생성해서 반환한다.
- [x]  당첨번호와 구입한 로또번호를 비교하여 몇개 맞추었는지 계산한다.
- [x]  맞춘 개수에 맞게 당첨통계정보를 반영한다.
- [x]  수익률을 계산하기 위한 당첨금액을 계산한다.


### 클래스 설명

`Lotto`

- `List<Integer> numbers`를 상태로 갖는 일급컬렉션
- 한 장의 로또를 관리하는 클래스

`LottoGame`

- `List<Lotto> lottos`를 상태로 갖는, 게임을  진행하기 위한 클래스
- `play(WinningLotto) 결과로 WinningResult`를 반환한다.

`WinningLotto`

- `Lotto lotto`를 상태로 갖고, 당첨로또를 관리한다.
- 당첨로또에게 메시지를 전달하여 몇 개를 맞췄는지 (몇등인지) 알 수 있다.

`WinningResult`

- `List<Integer> staticsList`를 상태로 갖는 타입이다.
- 개수는 0개부터 6개까지 유효하다. 즉 초기값: [0, 0, 0, 0, 0, 0, 0] 에서 시작한다.
- 한 장의 로또에서 **3개**를 맞췄다면 [0, 0, 0, 1, 0, 0, 0] 으로 update 한다.

`LottoMatch`

- 하나의 로또에서 몇 개를 맞췄는지 관리하기 위한 ENUM (당첨수: 3~6개 유효하다)
- `int matchCount, prize`몇 개를 맞췄는지, 상금 금액을 상태로 갖고 있음
