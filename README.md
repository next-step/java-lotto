# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 로또 구현
### 기능 구현사항 정리
- [X] 로또 구입금액을 입력한다
  - [X] 로또 1장의 가격은 1,000원 이다
- [X] 구입 금액에 따른 로또 구매 갯수를 출력한다
- [X] 로또 번호를 구매 갯수만큼 자동 생성한다
  - [X] 로또 한개당 총 6개의 번호가 생성된다
  - [X] 자동으로 생성된 로또 번호 6개는 중복이 되지 않는다
- [X] 구매 갯수만큼 로또 번호를 출력한다
- [X] 지난 주 당첨 번호를 입력한다
- [X] 당첨 통계를 출력한다
  - [X] 3~6개의 번호가 일치하는 경우를 계산하여 출력한다
  - [X] 총 수익률을 계산하여 출력한다
- [X] 보너스 볼을 입력 받는다.
  - [X] 1 ~ 45중 하나의 숫자이어야 한다.
- [X] 당첨 통계를 계산한다.
  - [X] 보너스 볼이 일치한 2등의 통계를 구한다.
- [X] 사용자가 로또를 수동 및 자동으로 구매한다.
  - [X] 사용자는 구매금액/1000 이내에서 수동으로 살 로또의 갯수를 입력한다.

### 도메인
* LottoNumber(로또 번호 한개)
* Lotto(로또 한개)
* Lottos(로또의 일급콜렉션)
