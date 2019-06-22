# 로또 Step2
1. 로또 구입금액을 입력받는다. (InputView)
1. 로또 객체를 만든다. (Lotto)
1. Collections.suffle() 활용하여 로또 생성 및 번호 정렬 로직을 구현한다.
1. 로또 객체의 일급콜렉션을 만든다. (Lottos)
1. 로또 당첨번호를 입력받는다. (InputView)
1. ArrayList.contains() 활용하여 몇개의 값이 일치하는지 확인한다.
1. 일치 갯수에 따른 결과를 출력한다.

## 제한사항
1. 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
1. indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
1. 메소드의 크기가 최대 15라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
1. else를 사용하지 마라.
1. 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596