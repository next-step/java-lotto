# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP2 기능 요구 사항
 - InputView 객체 구현
   - `Scanner` 클래스를 이용한다.
   - `로또 총 구입금액`을 입력받고 출력한 후, 금액을 리턴한다.
   - `당첨 번호`를 입력 받은 후 `당첨 번호`를 리턴한다.
   
 - `LottoMoney` 객체 구현
   - 원시 로또 금액을 받는다.
   - 로또 금액이 음수인지, 1000원 미만인지 검사한다. 올바르지 않은 값이면 `IllegalStateException`을 발생한다.
   
 - LottoFactory 객체 구현
   - `LottoMoney` 인스턴스를 받는다.
   - `로또 총 구입금액으로` 생성할 `로또 개수`를 구한다.
   - `로또 개수`를 리턴한다.
   - `로또 개수` 만큼 Lotto 객체를 만들어 `읽기전용 List`로 리턴한다. 
   
 - Lotto 객체 구현
   - 클래스 변수로 로또번호 1~45까지 입력된 List를 구현한다.
   - `Collections.shuffle()`로, 랜덤 6자리 숫자를 구하여 인스턴스 변수 `List`에 넣는다.
   - 로또 숫자 6자리의 `읽기전용 List를` 리턴한다.
   - `숫자 List`를 받은 후, 요소를 하나씩 탐색하면서 `포함된 숫자 개수`를 구하고 리턴한다.
   
 - LottoRank 객체 구현
   - `5_000`, `50_000`, `1_500_000`, `2_000_000_000` 상수로 `Enum` 타입으로 구현한다.  
   - 상수에 매칭되는 실제 `금액 변수`도 만든다.
   - 일치 번호를 입력시 해당하는 `금액 변수`를 리턴한다.
     - 인자가 1~6 사이가 아니라면, `Exception`를 호출한다.
     
 - `LottoRankCounter` 객체 구현
   - `Map` 자료구조를 가지는 일급객체로 구현한다.
   - `addCount` : 로또 당첨 개수를 저장한다.
   - `getCount` : 로또 당첨 개수를 리턴한다.
   
 - LottoResults 객체 구현
   - `당첨 번호`를 받는다.
   - `Lotto 객체 List`를 받는다. 
   - `배열`을 생성한다. 이는 로또 정답이 일치 하는 개수를 저장할 공간이다.
   - 입력 받은 Lotto 객체를 순회하면서 당첨 번호를 이용해 몇개의 번호가 포함 되어 있는지를 구하고 `배열`에 저장한다.
   - 인자를 1~6까지 받으며, 해당 인자에 일치하는 배열 값을 리턴한다.
     - 인자 범위가 맞이 않으면 `Exception`를 호출한다.
   - 총 수익률을 계산한다.
     - 받은 Lotto 객체 개수 * 1000 으로 로또를 구입한 금액을 구한다.
     - `배열`에 저장된 일치 개수와 통해, 이윤 금액을 구한다.
     - `이윤금액 / 로또 금액` 값을 구하고, 소수점 두자리 까지 저장한다.  
   
 - ResultView 구현
   - `로또 개수`를 받고 몇개를 구입했는지 출력한다.
   - `LottoResults 객체`를 받습니다.
   - 로또 일치번호 1~6 개를 `LottoResults 객체`를 통해 당첨 개수를 구합니다.
   - 당첨 개수와 `LottoRank Enum`를 통해, 결과값 문자열을 만든다.
   - 총 수익률을 `LottoResults 객체`로 받아, 결과값 문자열을 만든다.

## STEP3 기능 요구 사항
 - `InputView` 클래스 이용.
   - 보너스 볼을 입력 받을 수 있게 기능을 추가한다.
 
 - `ResultView` 클래스 이용.
   - 결과를 출력 할 때, 2등인 경우 `보너스 볼 일치` 문구를 추가한다.
        
 - `LottoLank` 클래스 이용.
   - 보너스 매치 여부를 인자로 받은 후, 2등 여부를 가리는 기능을 추가한다.
        
 - `LottoNumber` 클래스 구현.
   - 숫자 인자가 1-45 사이의 숫자 인지 검증하는 기능을 구현한다.
   - 최소 값 과 최대 값을 상수로 제공한다.
   - 객체 상태가 1-45 한정되어 있으므로, 인스턴스 풀을 제공한다.
   
 - `LottoResults` 클래스 수정.
   - `로또 당첨 번호 문자열` 을 받아, List<Integer>로 만들어 사용하지 않고, List<LottoNumber>로 만들어서 사용하도록 변경.
   - `로또 보너스 당첨 번호` 도 추가적으로 받아, 계산한다.
   
 - `Lotto` 클래스 이용.
   - 기존에는 매치된 숫자 개수를 리턴하는데, 이를 보너스 숫자와 함께 받아, 곧바로 `LottoRank`를 리턴하도록 변경한다.