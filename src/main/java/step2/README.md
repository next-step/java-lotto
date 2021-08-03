### 기능 요구사항

- [ ] 일정한 금액을 투입하고 투입 금액만큼의 로또를 구입 할 수 있어야한다. #LottoGame#main()
- [x] 사용자는 로또를 구입 할 수 있다 #User#buyLotto()
    - [x] 로또 기계에서 투입 금액만큼의 로또를 살 수 있다. #LottoMachine#createLottos()
        - [x] 로또를 만든다. #Lotto#createLotto()
            - [x] 음수로 된 로또 번호가 들어 올 시에 IllegalArgument 발생 
    - [x] 1부터 45까지의 서로 다른 임의의 수 6개를 생성한다. #LottoNumberGenerator#create()
    - [x] 사용자는 돈을 뺄 수 있다. #User#withDrow()
      - [x] 지갑은 돈을 뺄 수 있다. #Wallet#withDrow()
        - [x] 돈이 없는데 인출을 하면 IllegalArgument 발생
    - [x] 사용자는 지갑에 돈을 저장 할 수 있다. #User#save()
        - [x] 사용자는 지갑에 돈을 저장 할 수 있다. #Wallet#save()
- [x] 로또 당첨 통계를 보여준다. #LottoStatistics#lottoOfStatistics()
- [] 로또 수익률을 보여준다. #LottoStatistics#profic()
- [x] 로또 당첨 번호를 입력 할 수 있다. #LottoMachine#winOfLotto()

### 프로그래밍 요구사항

- [ ] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
    - 단, UI(System.out, System.in) 로직은 제외
- [ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [ ] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- [ ] else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    