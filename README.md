## 로또

### 3단계
#### 피드백 1

* lottoapp
  - [ ] lottoticketcreation 사용 시 다형성 사용
* lottoGame
  - [ ] LottoResult를 상태로 가지지 않고, 객체를 반환해라.
  - [ ] 3개 이상의 인스턴스 변수를 가지지 않는다.
  - [ ] lastWeeksWinningNumbers, bonusNumber 포장해라.
  - [ ] getCountOfMatch 메서드의 get이라는 명이 부자연스럽다.
  - [ ] LottoTicket 클래스의 역할은 무엇인가? 만약 검증되지 않는 로또 번호들이 입력되면??
* LottoResult
  - [ ] LinkedHashMap<>(); => Enum<>(Rank.class)로 변경해라.
* Rank
  - [ ] indent는 1단계만 허용
    * 문제점
      * throw new IllegalArgumentException("일치하는 당첨 개수가 없습니다. 당첨 개수를 확인 해주세요");
        의 예외가 필요없는데 return 을 던지기 위해 의미없는 코드를 만듬. getRankOfEtc에서 return MISS이기 때문에 필요없다.
        validate()에서 하고 있다.
* LottoGameTest
  - [ ] LottoTickets lottoTickets = lottoTicketCreatable.createTicket(1); 까지 코드와
    LottoTickets lottoTickets = List.of(LottoTicket.newTicket(testTicket));는 뭐가 다른가?
* RankTest
  - [ ] [다이나믹 테스트](https://woowacourse.github.io/javable/2020-07-31/dynamic-test)를 통해 테스트 코드의 중복을 줄여라.




## 온라인 코드 리뷰 과정

------

- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)