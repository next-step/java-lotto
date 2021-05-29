# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 3단계 요구 사항

* 금액에 따른 로또 구매 횟수를 정한다.
  * 구매 금액에 대한 원시값을 포장한다.
* 재활용이 가능한 랜덤 값을 생성하는 클래스를 만들자.
  * 번호 생성 로직을 만든다.
  * 번호 생성이 유효한지 체크하는 로직을 만든다.
  * 번호는 자동으로 값을 감싸도록 되며, 숫자의 범위도 체크가 가능하다.
* 구매한 만큼의 번호를 생성한다.
  * 생성 된 번호는 Set 자료구조에 담도록 한다.
  * 한 장의 로또는 Set이며 이 로또를 List에 담도록 한다.
* 당첨 번호를 입력 받고, 번호와 일치 되는지 체크하도록 한다.
  * 정렬을 이용하고, 낮은 번호부터 일치하는지 체크하도록 한다.
  * 통계는 Map을 활용하여 3,4,5,6개 일치와 카운트를 만들도록 한다.
* 당첨 통계와 구매 금액에 따른 수익률을 계산한다.
* 입력과 출력에 대한 클래스를 생성한다.

## 질문 내용

Q. 그 중 제일 기억에 남는 것이 바로 getter 메서드를 get이라는 프리픽스를 제거하고 사용하는 부분이었는데요. 메서드들에서 get이라는 네이밍을 제거하여 사용을 하였는데, 결국 게터를 남발한게 아닌가 싶은 생각이 들었습니다…! 리뷰어님께 피드백 요청 드려도 될까요?

A.
메서드명에서 get을 지운다고 getter가 아닌걸까요.
객체지향 생활체조에서 말하는 건 getter를 불필요하게 사용하지 말라는 의미입니다.
객체에서 값을 꺼내서 어떤 처리를 하면 캡슐화가 깨집니다.

Q.
lotto 클래스 내에서 정답이 몇 개 인지 체크 하는 함수는 외부로 빼내는게 맞나요? 이 전 미션인 계산기 로직에서도 Positive 클래스의 덧셈은 외부에서 했던거 처럼요. 혹시 외부에서 처리하는게 맞다면 내부에서 계산을 하는 것의 단점은 무엇일까요?

A.
로또 클래스가 너무 많은 역할을 맡게 되겠죠. 이건 글로 설명하는 것보다 두 가지 케이스를 구현해보시고 비교해보셔도 좋을 것 같네요

Q.
다른 분들의 풀리퀘를 보았을 때 공통적으로 많이 보았던 피드백이 바로 Positive가 계산하는 역할을 할 필요가 없다는 것이었는데요. 구글링을 통해 getter를 사용하지 않는 방법 중 객체에서 덧셈을 하는 increase 메서드를 제공하는 것을 본 적이 있었는데요. 이에 대해 혹시 어떤 의견이신지 여줘봐도 될까요?

A.
객체를 어떻게 설계하느냐에 따라 갈릴 것 같네요. 다른 리뷰어들의 피드백이 의미하는 건 positive에게 덧셈하는 기능을 넣게 되면 다른 연산이 추가될 때마다 positive에 계속 연산을 추가하면서 클래스의 복잡도가 높아질테니 역할을 분리해보자는 뜻일거에요

## 4단계 요구사항
* 보너스 볼을 입력 받는다. 이 때 중복이 되는 번호가 아닌지 체크한다.
* PrizeEnum을 활용하여 일치하는 수를 로또 등수로 변경한다.
* 5개가 일치하고 보너스 넘버 까지 일치하면 상금을 2등에 맞게 변경하도록 하는 로직을 개발한다.


## 질문 내용

Q. 3단계 마지막 피드백 내용중  Lotto 클래스의 numbersToString 메서드를 출력을 담당하는 OutputView 클래스로 옮기는 것을 말씀해 주셨습니다. 메서드를 출력 담당으로 옮기게 되면 Lotto클래스에는 getter가 필요하게 될 것으로 생각을 하였는데요. getter를 생성하더라도 출력을 위한 toString 메서드이니 OutputView 클래스로 이동을 하는 것이 좋을까요? (혹은 제가 getter를 만들지 않고 내용을 출력 할 수 있는 방법을 생각하지 못하는 것일까요?)

A. 출력을 위해서는 getter를 추가해주셔야 합니다. getter를 아예 안 쓸 수 없습니다. 객체지향 생활체조의 getter를 쓰지 말라는 부분은 남용하지 말라로 이해하시면 됩니다.


## 5단계 요구사항

* 로또 피드백 영상의 내용을 반영한다.
  * 로또 넘버 캐싱
  * 정적 팩토리 메서드
* 랜덤 숫자가 아닌 직접 로또 넘버를 받고 로또리스트에 추가 되는지 테스트케이스를 작성한다.
* 입력받은 금액에서 수동의 로또를 생성한 뒤 자동으로 생성이 되는지 테스트 케이스를 작성한다.
* 로또 게임의 로직을 간결하게 한다. 
* 실제 UI의 로직을 구현하고 로또가 정상적으로 실행되는지 확인한다.