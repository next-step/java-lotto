# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

----
# [로또 - TDD](https://edu.nextstep.camp/s/MNii0Puk/lt/egiZc5tD)
## 학습 목표
###경험해야할 학습 목표
* TDD 기반으로 프로그래밍하는 경험
* 메소드 분리 + 클래스를 분리하는 리팩토링 경험
* 점진적으로 리팩토링하는 경험
### 경험할 객체지향 생활 체조 원칙
 * 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
 * 규칙 2: else 예약어를 쓰지 않는다.
 * 규칙 3: 모든 원시값과 문자열을 포장한다.
 * 규칙 5: 줄여쓰지 않는다(축약 금지).
 * 규칙 8: 일급 콜렉션을 쓴다.
## Clean Code 가이드
### 의미 있는 이름
#### 의도를 분명히 밝혀라
* 좋은 이름을 지으려면 시간이 걸리지만 좋은 이름으로 절약하는 시간이 훨씬 더 많다.
* 그러므로 이름을 주의 깊게 살펴 더 나은 이름이 떠오르면 개선하기 바란다. 그러면 (자신을 포함해) 코드를 읽는 사람이 좀더 행복해지리라.
* 따로 주석이 필요하다면 의도를 분명히 드러내지 못했다는 소리다.
```
// 잘못된 사용 예
int d; //경과 시간(단위: 날짜 수)
```
#### 그릇된 정보를 피하라
* 프로그래머는 코드에 그릇된 단서를 남겨서는 안 된다. 그릇된 단서는 코드 의미를 흐린다.
* 서로 흡사한 이름을 사용하지 않도록 주의한다.
* 유사한 개념은 유사한 표기법을 사용한다.
#### 의미 있게 구분하라
* 컴파일러나 인터프리터만 통과하려는 생각으로 코드를 구현하는 프로그래머는 스스로 문제를 일으킨다.
* 연속적인 숫자를 덧붙인 이름(a1, a2, ..., aN) 덧붙이거나 불용어(Info, Data, a, an, the)를 추가하는 방식은 적절하지 못하다. 이름이 달라야 한다면 의미도 달라져야 한다.
#### 인터페이스 클래스와 구현 클래스
* 인터페이스 이름은 접두어를 붙이지 않는 편이 낫다고 생각한다.
* IShapeFactory(인터페이스), ShapeFactory(구현 클래스) 구조로 이름을 짓는 것은 좋은 선택은 아니다.
* 오히려 인터페이스를 ShapeFactory로 이름을 짓고 구현 클래스의 의도를 드러낼 수 있는 이름을 짓는 것을 추천한다.
#### 클래스 이름
* 클래스 이름과 객체 이름은 명사나 명사구가 적합하다.
* Customer, WikiPage, Account, AddressParser 등이 좋은 예다.
* Manager, Processor, Data, Info 등과 같은 단어는 피하고, 동사는 사용하지 않는다.
#### 메소드 이름
* 메소드 이름은 동사나 동사구가 적합하다.
* postPayment, deletePage, save 등이 좋은 예다.
* 접근자, 변경자, 조건자는 자바 빈 표준에 따라 값 앞에 get, set, is를 붙인다.
* 생성자를 중복해 정의할 때는 정적 팩토리 메소드를 사용한다. 메소드를 인수를 설명하는 이름을 사용한다.
#### 개념 하나에 단어 하나를 사용하라
* 추상적인 개념 하나에 단어 하나를 선택해 이를 고수한다.
* 일관성 있는 어휘는 코드를 사용할 프로그래머가 반갑게 여길 선물이다.
### 경계
#### 외부 코드 사용하기
* API를 사용하는 사용자는 자신의 요구에 집중하는 인터페이스만 존재하기를 기대한다.
* java.util.List, java.util.Map와 같은 collection을 외부에 노출하는 경우 사용자는 너무 많은 인터페이스에 노출하게 된다.
```
Map<Integer, Sensor> sensors = new HashMap<>();
Sensor s = sensors.get(sensorId);
```
* 경계 인터페이스인 Map을 Sensors라는 클래스 안으로 숨긴다.
```
public class Sensors {
    Map<Integer, Sensor> sensors = new HashMap<>();

    pubilc Sensor getById(String id) {
        return sensors.get(id);
    }
}
```
* 위와 같이 Map을 사용자에게 직접 노출하는 경우 사용자에게 Map의 모든 인터페이스를 노출하지 않아도 된다.
* Sensors를 추가함으로써 필요한 인터페이스 하나만 노출하는 것도 가능하다.
* 또 하나의 장점은 Sensors 내부의 자료구조가 Map이 아닌 다른 자료구조로 변경되더라도 외부에 변경이 발생하지 않아도 된다.
#### 경계 살피고 익히기
* 학습 테스트를 통해 외부 코드 사용 방법을 익힌다.
* 외부 코드가 변경될 경우 발생할 버그를 학습 테스트 코드를 통해 검증할 수 있다.
#### 학습 테스트는 공짜 이상이다.
> 학습 테스트에 드는 비용은 없다. 어쨌든 API를 배워야 하므로 오히려 필요한 지식만 확보하는 손쉬운 방법이다. 학습 테스트는 이해를 높여주는 정확한 실험이다.
> 
> 학습 테스트는 공짜 이상이다. 투자하는 노력보다 얻어지는 성과가 더 크다. 패키지의 새 버전이 나온다면 학습 테스트를 돌려 차이가 있는지 확인한다.

----
# [1단계 - 문자열 덧셈 계산기](https://edu.nextstep.camp/s/MNii0Puk/ls/BqEG7gXQ)
## 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.

## 기능 요구사항 분리 및 힌트
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    ```if (text == null) {}
    if (text.isEmpty()) {}
    ```
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    ```
    int number = Integer.parseInt(text);
    ```
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    ```
    String[] numbers = text.split(",");
    // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
    ```
4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    ```
    String[] tokens= text.split(",|:");
    ```
5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    ```
    // java.util.regex 패키지의 Matcher, Pattern import
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
        String customDelimiter = m.group(1);
        String[] tokens= m.group(2).split(customDelimiter);
        // 덧셈 구현
    }
    ```
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
   * 구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.
## TestCase 소스 코드
```
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

     @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
```
## Reviewer Feedback (2020-11-22 반영)
- [x] 메소드 순서대로 parseOperands , sumOperands 위치 변경
- [x] Pattern 객체 캐싱 처리
`private static final Matcher customMatcher = Pattern.compile(customRegex).matcher(userInput);`
- [x] 상수로 처리
`private static final String customRegex = "//(.)\n(.*)";`
`private static final String customRegex = "//(.)\n(.*)";`
- [x] Objects 클래스를 활용한 null 검사
`return Objects.isNull(userInput) || userInput.isEmpty();`
- [x] `RuntimeException` --> `IllegalArgumentExceptinon으로 핸들링`
- [x] testcase에대해서도 리팩토링(반복제거) 수행하기 (ParameterizedTest 도입)
- [x] `@DisplayName`을 활용해서 test의도 나타내기

----
# [2단계 - 2단계 - 로또(자동)](https://edu.nextstep.camp/s/MNii0Puk/ls/uYOLrcvU)

## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

### 힌트
로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
Collections.sort() 메소드를 활용해 정렬 가능하다.
ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 프로그래밍 요구사항
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
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

## 기능 목록 및 commit 로그 요구사항
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 구현할 기능 목록 정리
* LotteryNumber class를 구현한다.
  * 1~ 45 이내의 숫자만 허용한다.
* LotteryTicket class를 구현한다.
  * 6개 숫자는 중복이 없다.
  * 오름 차순으로 정렬한다.  
* LotteryGame class를 구현한다.
  * 입력한 금액 만큼 로또 티켓을 발행한다.
  * 당첨 번호를 입력 받는다.
  * 로또 1장을 구입한다.
  * 로또 당첨을 확인한다.
* LotteryResult class를 구현한다.
  * 3,4,5,6개 맞춘 결과를 저장한다.
  * 수익성을 계산한다. (ing)
* LotteryWinNumbers class를 구현한다.(? 구현이 필요한가)
  * 당첨번호를 입력한다.
  * 로또 티켓이 당첨되었는 확인한다.
* InputView class를 구현한다.
  * 금액을 입력 받는다.
  * 6개의 당첨 번호를 입력 받는다.
* ResultView class를 구현한다.
  * 구매한 복권 개수를 출력한다.
  * 당첨 통계를 출력한다.
* LotteryGameManager class를 구현한다.