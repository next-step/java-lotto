package calculator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO: 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * TODO: 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * TODO: 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp() {
        sc = new StringCalculator();
    }

    @Test
    public void NULL인_문자열을_넘기는_경우_0을_반환() {
        int result = sc.add(new Text(null));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 공백_문자열을_넘기는_경우_0을_반환() {
        int result = sc.add(new Text(""));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 콤마로_구분하는_문자열을_넘기는_경우() {
        int result = sc.add(new Text("1,2"));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 콜론과_콤마로_구분하는_문자열을_넘기는_경우() {
        int result = sc.add(new Text("1,2:3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 커스텀_구분자가_있는_문자열을_넘기는_경우() {
        int result = sc.add(new Text("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 문자열에_음수가_포함된_경우() {
        sc.add(new Text("//;\n1;-2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void 문자열에_숫자가_아닌_문자가_포함된_경우() {
        sc.add(new Text("//;\n1;@;3"));
    }

}
