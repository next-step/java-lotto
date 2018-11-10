package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
 * (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
public class StringCalculatorTest {

    @Test
    public void add_숫자_하나() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_쉼표() {
        int result = StringCalculator.add("1,4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void add_쉼표_또는_구분자() {
        int result = StringCalculator.add("1:4,2");
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void add_null_또는_빈문자() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);

        result = StringCalculator.add(null);
        assertThat(result).isEqualTo(0);
    }

    @Test(expected = RuntimeException.class)
    public void add_숫자가_아닐_경우_RuntimeException() {
        StringCalculator.add("asdf");
    }

    @Test(expected = RuntimeException.class)
    public void add_숫자가_음수인_경우_RuntimeException() {
        StringCalculator.add("-1");
    }

    @Test
    public void add_커스텀_패턴() {
        int result = StringCalculator.add("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);

        result = StringCalculator.add("//^\\n1^2^3");
        assertThat(result).isEqualTo(6);
    }
}
