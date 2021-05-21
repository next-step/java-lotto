# 로또
## 3단계 - 로또(자동)

### 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다
    * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
### 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    * 참고문서: AngularJS Commit Message Conventions
    
### 기능 목록
* 구입 금액을 입력받으면 몇 개의 로또 게임을 구입할 수 있는지 계산할 수 있다.
* 로또 한 게임은 1 ~ 45 범위의 숫자 중 중복되지 않는 6개의 숫자로 이루어진다.
* 메서드를 호출 할 때마다 다른 숫자로 이루어진 로또 게임을 발생시킬 수 있다.
* 로또 숫자의 범위(1 ~ 45)가 초과하면 Exception을 발생시킬 수 있다.
* 두 가지 로또 게임의 번호를 비교해서 몇개의 숫자가 동일한지 반환 할 수 있다.
* 숫자를 입력받으면 로또 등수가 몇 등인지 반환할 수 있다.
* 당첨 금액을 구입 금액으로 나눠 수익률을 반환할 수 있다.
* 당첨 통계를 출력할 수 있다.

### 클래스 목록
* LottoNumber
  * 로또 숫자를 나타내는 클래스
  * 1 ~ 45 사이의 숫자인지 validation 할 수 있다.
* LottoNumbers
  * 로또 숫자들의 집합을 나타내는 일급 컬렉션
  * 중복 되지 않는 숫자들의 집합이다.
  * 로또 한 게임의 숫자 개수인 6개가 맞는지 validation할 수 있다.
  * 다른 LottoNumbers와 몇개의 숫자가 동일한지 반환할 수 있다.
  
* LottoNumbersFactory
  * 1 ~ 46의 고정된 LottoNumber 풀에서 랜덤한 LottoNumbers를 생성해내는 클래스

* LottoRanking
  * 숫자를 맞춘 개수에 따라 등수 정할 수 있는 enum
  * 등수를 나타내는 enum마다 당첨금을 나타낼 수 있다.
  
* LottoGame
  * LottoNumbers를 멤버변수로 갖는 하나의 로또 게임을 나타내는 클래스
  * 전달 받은 LottoGame(당첨 게임)과 비교해서 당첨 결과인 LottoRanking을 반환할 수 있다.
  
* TotalRankings
  * 로또 게임들의 당첨 결과인 여러개의 LottoRanking를 갖는 일급 컬렉션
  * LottoRanking List를 받으면 LottoRanking 별로 그룹핑해서 당첨 갯수를 담고 있는다.

* LottoGames
  * LottoGame의 집합을 나타내는 일급 컬렉션
  * 당첨 게임을 인자로 전달받아 LottoGame의 집합의 당첨 결과를 TotalRankings로 반환할 수 있다.
  
* OrderSheet
  * 입력받은 구매 금액을 도메인 객체에 전달하는 DTO 클래스

* InputView
  * 로또 구입 금액과 당첨 번호를 입력 받는 UI 클래스
  
* PrizeInfo
  * 일치한 번호 수, 당첨금액, 구매한 로또 중 당첨된 로또 수를 OutputView에 전달하는 DTO 클래스 
  
* OrderedInfo
  * 주문한 로또의 번호를 노출시키기 위해 로또 번호를 전달하는 DTO 클래스
  * 출력 포맷에 맞춰 toString 오버라이드

* OrderedInfos
  * 주문한 로또들의 갯수와 로또 번호를 노출시키기 위한 DTO 클래스 OrderedInfo의 일급컬렉션이다.
  * 출력 포맷에 맞춰 toString 오버라이드
