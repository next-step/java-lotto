## 로또

### 3단계
#### 피드백 1

* lottoApp
  - [x] lottoticketcreation 사용 시 다형성 사용
* lottoGame
  - [x] LottoResult를 상태로 가지지 않고, 객체를 반환해라.
    * 인스턴스 변수를 가지지 않는게 좋은 이유는??
  - [1] 3개 이상의 인스턴스 변수를 가지지 않는다.
    * 어떻게 분리해야 할까?
  - [x] 로또 번호가 잘못들어왔을 때 예외처리(LottoTicket)
  - [x] lastWeeksWinningNumbers, bonusNumber 포장해라.
    * 예외를 잡아라.
    * 의문
      * 파라미터로 객체를 넘기는게 좋은가? 객체에서 필요한 값을 꺼내서 넘기는게 좋은가?
        * 객체를 넘기면 객체가 변경되면, 객체를 받은 객체의 내용도 수정 되어야 할 수도 있기 때문에 필요한 값만
          뽑아서 넘기는 것이 좋아 보인다.
  - [x] getCountOfMatch 메서드의 get이라는 명이 부자연스럽다.
  - [x] LottoTicket 클래스의 역할은 무엇인가? 만약 검증되지 않는 로또 번호들이 입력되면??
    * 예외를 처리 했지만, LastWeeksWinningNumbers에 똑같은 로직이 들어간다.??? 
      * 또한, for문으로 각각의 번호를 검증하고 있는데, Number라는 클래스를 따로 분리해야 할까?(for문을 제외하면 BonusNumber도 마찬가지)
        일부러 for문은 indent 처리를 하지 않았습니다. 리뷰어님께 검사 받는 도라서요
* LottoResult
  - [ ] LinkedHashMap<>(); => Enum<>(Rank.class)로 변경해라.
* Rank
  - [x] indent는 1단계만 허용
  - [x] LinkedHashMap<>(); => EnumMap<>()로 변경해라.
* Rank
  - [x] indent는 1단계만 허용
    * 어떻게 적용해야 할까? 바꾸긴 바꿨는데 모르겠넹.. 2단계가 한계 ㅜ,ㅜ
* LottoGameTest
  - [6] LottoTickets lottoTickets = lottoTicketCreatable.createTicket(1); 까지 코드와
    LottoTickets lottoTickets = List.of(LottoTicket.newTicket(testTicket));는 뭐가 다른가?
    * 이해가 안됨. List.of는 불변 리스트를 반환하는 건데?? 뭘 하라는 건가?
* RankTest
  - [7] [다이나믹 테스트](https://woowacourse.github.io/javable/2020-07-31/dynamic-test)를 통해 테스트 코드의 중복을 줄여라.
    * 링크가 없습니다. ㅜ.ㅜ 다른 블로그 보려고 해도 정보가 없네요 ㅜ.ㅜ




## 온라인 코드 리뷰 과정

------

- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
