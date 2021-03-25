# 🚀 1단계 - 문자열 덧셈 계산기 
# 실습환경 세팅
* 로또에 대한 github 저장소를 기반으로 실습을 진행한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

# 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
## 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

# 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.

# 기능 요구사항 분리 및 힌트
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
   ```java
   if (text == null) {}
   if (text.isEmpty()) {}
   ```
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    ```java   
    int positiveNumber = Integer.parseInt(text);
    ```
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
   ```java
   String[] positiveNumbers = text.split(","); 
   // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
   ```   

4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
   ```java
   String[] tokens= text.split(",|:");
   ```
5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
   ```java
   // java.util.regex 패키지의 Matcher, Pattern import
   Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
   if (m.find()) {
   String customDelimiter = m.group(1);
   String[] tokens= m.group(2).split(customDelimiter);
   // 덧셈 구현
   ```
   }
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
   * 구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.

### TestCase 소스 코드
```java
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
      
# TODO LIST       
* String split에 대한 학습 테스트      
* 도메인 지식 습득을 위한 완전 레거시 코드 작성 및 테스트          
* 음수 전달시 RuntimeException 발생하는지 테스트 
  * Number 클래스를 가장 먼저 구현할 예정이므로 가장 먼저 만들 테스트 케이스 
* 쉼표 구분자로만 이루어진 문자열 덧셈 기능 테스트
  * 구분하는 split 과 더하는 sum 메서드 구현해야 한다.   
* 콜론 구분자로만 이루어진 문자열 덧셈 기능 테스트
  * 구분하는 split 과 더하는 sum 메서드 구현해야 한다.
* 커스텀 구분자로만 이루아진 문자열 덧셈 기능 테스트 
  * 구분하는 split 과 더하는 sum 메서드 구현해야 한다.
* 쉼표, 콜론 구분자로 이루어진 문자열 덧셈 기능 테스트 
* 커스텀 구분자 + 쉽표, 콜론 구분자로 이루어진 문자열 덧셈 기능 테스트 
  
## 클래스 설계 
* StringAddCalculator : 전체를 관장하는 클래스    
    * splitAndSum 이라는 정적 메서드를 사용한다.
    * 나누는 역할/책임을 가진다. 
    * 더하는 역할/책임을 가진다.  
* StringUtils : String 처리에 대한 공통적인 기능 제공 클래스 
    * 단, String 클래스의 메서드에 한해서이다.
    * isNull, isEmpty : Null 검증, "" 검증
    * isBlank : trim()을 이용해서 빈 공백도 isEmpty 인지 검증
* Number : 각각의 숫자를 저장한 클래스 -> 음수 검증 약할이 있다.   

* 아직 미정: 분리 기준이 되는 연산자 문자열 또한 클래스로 만들어야 할까?  
    * 기존 연산자는 ENUM 으로 미리 처리해볼까?   
    * 이 부분에 대해서는 도메인 지식에 대해서 알고 수정하자  

