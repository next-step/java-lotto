import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * 기능 요구사항 :
 * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 *   (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * - 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 *   커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 *
 * 1. 사용자 입력 받기
 *   - "" 공백이나 null 입력시 0 return
 * 2. 입력값 split
 *   - ",", ":"
 *   - "custom": ex) "//;\n1;2;3"
*  3. split 한 후, 숫자로 변경
 * 4. 숫자가 아닌 경우 (runtimeException)
 * 5. 음수인 경우 (runtimeException)
 */
public class StringCalculatorTest {

    @Test
    @DisplayName("사용자 입력값 확인")
    void isEmptyInput() {
        String input = "";
        assertThat(StringCalculator.isEmpty(input)).isTrue();
    }

    @Test
    @DisplayName("사용자 입력값 계산")
    void calculate() {
        String input = "";
        assertThat(StringCalculator.calculate(input)).isEqualTo(0);
    }



}
