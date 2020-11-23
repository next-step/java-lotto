# 로또

## [Step1] 문자열 덧셈 계산기
* [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
* [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자 반환
* [X] 숫자 두개를 컴마(,)로 구분하여 합 반환
* [X] 추가적으로 콜론(:)을 구분자로 사용
* [X] //와 \n 문자 사이에 커스텀 구분자 지정
* [X] 음수를 전달할 경우 RuntimeException 사용

### Step1 feedback
* 과한 랩핑 금지
* List\<T\> x = new Vector<>(); 에서 Vector 사용한 이유
  * TODO: 실제 구현 시에 특별한 이유가 없었는데 이후에 한 번 생각해보기(ArrayList, VectorList 등)

## [Step2] 로또(자동)
* [X] 구입 금액을 입력 받는 기능
* [X] 입력된 구입 금액에 대해 구입할 로또 갯수를 출력하는 기능
* [X] 구입 해야할 로또 갯수에 대해 자동으로 6개의 로또 번호를 지정하여 발급하는 기능
* [X] 당첨 번호를 입력 받는 기능
* [X] 입력 받은 당첨 번호를 가지고 당첨 통계를 나타내는 기능

### 요구 사항에서 파생된 구현 리스트
* [X] 로또에서 사용되는 숫자를 나타내는 기능(객체지향 체조 요구사항)
* [X] 로또 티켓(6개 로또 번호 묶음)
* [X] 구입한 로또 목록
* [X] 로또 발급 기능
* [X] 로또 등수 구하는 기능
* [X] InputView
* [X] ResultView

### Step2 1차 피드백
* [X] NumberPool 리팩토링
   * AS-IS: LottoNumber 및 LottoNumber 배열 만드는 모든 곳에 관여 중
   * TO-BE: 중복되지 않은 LottoNumber 6개 묶음 생성, 로또 번호 생성, 티켓 생성, 당첨 번호 생성으로 분리
      * [X] 전체 로또 번호(1 ~ 45) 관리 기능(LottoNumber)
      * [X] 당첨번호 생성 및 관리 기능(WinningNumber)
      * [X] 티켓 발급 기능(TicketPublisher)
      * [X] 중복되지 않은 LottoNumber 6개 묶음 생성 기능(NumberPool)
* [X] 예외처리 메시징
* [ ] LottoResult 에서 ResultView 에 결과 전달하는 방식 변경(AS-IS: toString()) [참고 자료](https://javacan.tistory.com/entry/methods-about-exporting-domain-object-to-view)
* [X] 객체지향체조 'getter/setter 금지' 부분 공부 [참고 자료](https://velog.io/@ybg7955/Clean-Code-10%EC%9E%A5-%ED%81%B4%EB%9E%98%EC%8A%A4)
* [X] Enum 도입하여 LottoResult, Rank 로 분리 [참고 자료](https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html)

### Step2 2차 피드백

* Domain <-> View 결합도
```
안녕하세요 성협님 🙇 

요구사항 반영해주시느라 고생 많으셨습니다 

정말 많은 부분이 개선 되었습니다 👍 💯 

조금만 더 보완 되면 좋을 것 같아서 
몇 가지 의견 드렸습니다 😅 

> 일단... ResultView < - > Domain 사이에 결합도 높은 문제를 제외하고 진행을 하였습니다!

이 부분에 대해서 너무 어렵게 생각 안하셨으면 좋겠습니다
두 객체간에 Story로 한번 풀어보면

* Domain 의 비즈니스 로직 및 역할, 책임 변경에 대해 ResultView는 몰라도 됩니다
* 그렇지만 ResultView는 Domain을 가지고 자유롭게 출력을 해야 하는 책임이 있으니 출력에 맞도록 Domain 속성을 조회는 할 수 있으면 좋겠습니다
* ResultView는 Domain이 가지고 있는 속성을 다 반환 받게 되면 비즈니스 로직이나 역할, 책임이 변경될 때 속성이 변경 될 수도 있으니 그 부분은 최소화 하고 싶습니다
* Domain 또한 모든 정보를 외부로 노출시키기는 좀 망설여 집니다.
* 그래서 Domain과 ResultView는 서로 약속을 정합니다 하나의 객체를 만들고 Domain은 ResultView에서 필요하다고 하는 내용만 담아서 전달합니다 
* ResultView도 Domain과 약속한 객체를 통해 내용을 전달 받고 Domain의 변경과 무관하게 출력 형태 및 형식을 정합니다 

어떠신가요?? 이렇게 Story로 정리해놓고 보니 좀 어색하긴 한데 😅 😅 
두 객체간에 고민에 대해서 좀 더 이해를 돕고자 해봤습니다 😄 
부디 성협님의 고민해결에 도움이 되셨으면 좋겠습니다 🙇 

일단 여기서 merge 하겠습니다 
3단계 진행 부탁 드립니다 🔥 

고생 많으셨습니다 👍 
```
* Budget 의 책임에 맞지 않는 기능이 추가 되어 있음.

## [Step3] 로또(2등)

### 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 요구사항서 파생된 구현 목록
* [X] Rank 수정
* [X] 보너스 볼 입력 받는 기능 추가
* [X] WinningNumber 에 보너스 볼 검증 기능 추가

### 피드백 반영을 위해 진행해야 하는 부분
* [X] TicketPublisher 에서 Budget 을 받아서 티켓을 발급하도록 변경
* [ ] 내가 생각한 식대로 Domain <-> Model 결합도 완화하고 리뷰 받기
