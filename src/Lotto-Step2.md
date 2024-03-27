## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 힌트
* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항 
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
  힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.


## 구조 도메인
- 게임(로또)
- 지불 금액
- 로또 생성기(게임수만큼)
- 게임들
- 당첨번호 입력 
- enum 로또순위

## 기능목록 및 테스트 목록
- [X] 구매금액 입력 -> 1게임당 1000원 -> 몇개 구매 출력 - inputview
- [X] 구매한 게임 만큼 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- [X] 각 게임 숫자 정렬 Collections.sort() 메소드를 활용해 정렬 가능하다.
- [X] 게임들 출력
- [X] 당첨 번호 입력
- [X] ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
- [X] 당첨 통계
- [X] 수익률 계산

## 리뷰 피드백 내용
- 3/24
- [X] Fee -> 매개변수가 1000원 이하이거나 음수일 경우에 대해서 
- [X] Lotto -> 객체명과 변수명은 동일하게 짓지 않는걸 권장 -> 가독성, 코드혼란방지, 유지보수를 위해
- [ ] Lotto -> 객체의 내부 값을 직접 꺼내서 연산하기보단 요청과 응답으로 구현해보면 어떨까요? 우리가 객체의 변수들을 private로 접근제어자를 설정한건 외부 접근을 막기 -> 제가 리뷰 내용을 이해 못한것 같습니다. 추가적인 설명 부탁드립니다.
- [X] LottoGenerator -> 유틸리티클래스 -> 생성자제한 하거나 싱글턴패턴 -> 생성자 제한
- [X] LottoGenerator.rangeOfLotto() -> 1~ 45라는 로또 번호는 바뀌지 않고 재사용도 가능한데, 매번 ArrayList를 새로 생성해야할까요?!
- [X] LottoMatchLogic -> 도메인? 서비스? -> 도메인 영역같다는 의견입니다.
- [X] ResultView -> StringBulider -> 처움에 StringBulider 였으나 인텔리제이가 바꾸도록 권장
- [X] LottoRank -> 오탈자
- [ ] Lotto 일급 컬렉션 Lotto와 로직? 서비스? LottoMatchLogic 콜백 또는 고차함수 -> 제가 리뷰 내용을 이해 못한것 같습니다. 추가적인 설명 부탁드립니다.