## 로또

### 3단계
#### 피드백 1

---
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

#### 피드백2

---
* BonusNumber
  - [x] `Rank.SECOND.getCountOfMatch()` 으로 데이를 가져와서 사용하는 것 보다는 
    메시지를 보내라.  `Rank.SECOND.equalsMatchCount(countOfMatch)`
* LastWinningNumbers, BonusNumber, LottoTicket의 예외 중복을 Number 클래스로 분리하자.
  - [x] Number 클래스를 만들어 역할을 분리하자.
    - 중복 메시지 
      - 45보다 클 수 없습니다.
      - 1보다 작을 수 없습니다.
      - 로또 번호는 중복될 수 없습니다.
      - 로또 번호는 6개이어야 합니다.
    ```java
    LottoNumber {
      int value;
      // 1~45 값을 검증
    }
    
    LottoNumbers {
      List<LottoNumber> value;
      // 6개의 값을 가진 것을 검증
    }
    
    WinningLottoNumbers {
      LottoNumbers value;
      LottoNumber bonus;
    }
    ```      
- [x] 인스턴스 변수를 줄여라.
  - 인스턴스 변수가 있다는 것은 분석 시 해당 변수를 고려해야 한다.
    이는 혼란만 가중시킬 수 있는 부분이다.
    그렇기 때문에 반드시 필요한게 아니라면 인스턴스 변수는 가지지 않는게 가독성에 유리하다.
    인스턴스 변수를 분리하기 위해서는 묶을 수 있는 기능들은 묶어서 클래스로 분리하는 것이다.
    다른 방법으로는, 매개변수로 넘겨주는 방식이다. 해당 메서드에서 필요한 매개변수로 넘겨주게 되면,
    해당 메서드에서만 상태를 신경쓰면 되기 때문이다.
- [ ] Rank클래스의 indent를 줄이기 위해 Stream을 사용해라.
- [ ] Rank클래스에서 일치여부하는 역할을 분리??
  - 아이디어가 잘 떠오르지 않네요.
- [x] 매개변수로 객체를 넘기지 말아라.
  - 매개변수로 객체자체를 넘기게 되면, 클라이언트는 객체 내부 구조를 알아야 한다.
    그렇기 때문에 필요한 매개변수를 객체에서 추출하여 넘겨라.
- [ ] LottoTicketCreatable이 불필요한 것 같다. 제거를 고려해라.
  - 테스트를 위한건데 이게 없다면 랜덤요소인 자동 로또 티켓을 어떻게 테스트 할까요??
- [ ] [다이나믹 테스트 구현](https://woowacourse.github.io/javable/post/2020-07-31-dynamic-test/)
      
## 온라인 코드 리뷰 과정

------

- [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
