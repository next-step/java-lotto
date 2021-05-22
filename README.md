# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Todo list

- 객체 간 메세지 플로우를 설계한다.
- 기능 목록 단위 리스트를 작성한다.
- TDD 기반으로 기능 목록 단위를 구현한다.

### 객체 간 메세지 플로우

![](lotto_message_flow.png)

### 기능 목록 리스트

- LottoSeller : 구매 가능한 수량만큼 로또를 생성하여 바구니에 담는다.
- Lotto : 숫자 생성기에 의해 생성된 여섯 자리 숫자로, 로또 하나를 생성한다.
- LottoBucket : 생성된 로또를 담고, 정답 로또 번호와 몇 개 일치하는지 계산한다.
- PurchaseAmountQuantity : 사용자에 의해 입력된 구매 금액과 수량을 저장하며, 수익률을 계산한다.
- InputView : 사용자에 의해 입력을 받는다.
- ResultView : 결과를 출력한다.
