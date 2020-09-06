# 기능 목록
## 문자열 덧셈 계산기
- [x] 쉼표(,) 또는 콜론(:)를 기준으로 분리한 각 숫자의 합을 반환한다.
  - [x] 빈 문자열 또는 null 값을 입력한 경우 0을 반환한다.
  - [x] 숫자 하나를 입력한 경우 해당 숫자를 반환한다.
- [x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- [x] 쉼표와 콜론외 커스텀 구분자를 지정할 수 있다.
  - [x] 커스텀 구분자는 "//"와 "\n" 사이에 위치해야 한다.

## 로또
### Step2
#### 핵심 로직
- [x] 현재 금액으로 구입할 수 있는 로또를 발급한다. 숫자는 자동으로 생성한다.
  - [x] 로또는 6개의 숫자로 이루어져있다.
  - [x] 6개의 숫자가 중복되지 않는다.
  - [x] 각 숫자는 1 ~ 45 사이의 임의값이다.
- [x] 로또 숫자와 당첨 번호가 몇 개 일치하는지 알 수 있다. (등수)
- [x] 등수별 당첨된 로또 장수와 총 수익률을 알 수 있다.
  ```
  4등 - 3개 일치하는 경우, 5000원
  3등 - 4개 일치하는 경우, 50000원
  2등 - 5개 일치하는 경우, 1500000원
  1등 - 6개 일치하는 경우, 2000000000원
  ```
  - [x] 총 수익률은 `당첨 금액 / 구입 금액`으로 구한다.

#### 입출력
- [x] 구입 금액을 입력할 수 있다.
- [x] 구입한 로또 장수를 출력한다.
- [x] 각 로또의 6개 숫자를 출력한다.
- [x] 지난 주 당첨 번호 6개를 입력할 수 있다.
- [x] 당첨 통계를 출력한다.
  - [x] 순위별로 당첨된 개수를 표시한다.
  - [x] 총 수익률은 소수점 2자리까지 표시한다.
