# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
### LottoNumber
- [X] 1부터 45 사이의 숫자 중 하나를 가진다.
### Lotto
- [X] 6개의 정렬된 LottoNumber 쌍을 가진다.
- [X] LottoNumber는 수동으로 입력받거나, 랜덤으로 생성할 수 있다.
### WinningLotto
- [X] Lotto의 모든 기능을 가진다.
- [X] 6개의 정렬된 숫자 쌍과 보너스볼 번호를 가진다.
- [X] 다른 로또가 주어졌을 때 일치하는 개수를 반환할 수 있다.
- [X] 다른 로또가 주어졌을 때 보너스볼 번호의 포함여부를 반환할 수 있다.
### Lottos
- [X] Lotto 리스트를 가진다.
- [X] 주어진 금액만큼 구매 가능한 개수의 Lotto를 생성하여 리스트에 추가한다.
- [X] 입력받은 수동 생성 번호로 Lotto를 생성한 후, 나머지 개수만큼 Lotto를 자동 생성하여 저장한다.
- [X] Lotto 리스트의 요소 개수를 알려준다.
- [X] Lotto 리스트 중 자동생성 로또의 개수를 알려준다.
- [X] Lotto 리스트의 요소들과 WinningLotto를 비교하여 등수 별 개수를 알려준다.
### LottoPurchaseAmount
- [X] 로또 구매금액 정보를 가진다.
- [X] 주어진 금액으로 몇 번 구매 가능한지 알려준다.
- [X] 주어진 금액이 정확히 떨어지지 않으면 에러를 던진다.
- [X] 주어진 당첨금액과 비교하여 이익률을 알려준다.
###Rank
- [X] 로또의 일치개수에 대한 당첨금 쌍을 가진다.
- [X] 로또의 일치개수가 주어지면 해당되는 랭크를 반환한다.