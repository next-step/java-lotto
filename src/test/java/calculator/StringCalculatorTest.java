package calculator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static calculator.StringCalculator.add;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO: 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * TODO: 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * TODO: 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class StringCalculatorTest {

    @Test
    public void 문자열이_NULL인_경우() {
        assertThat(add(null))
                .as("문자열이 NULL인 경우 0이 반환되야한다")
                .isEqualTo(0);
    }

    @Test
    public void 문자열이_공백인_경우() {
        assertThat(add(""))
                .as("문자열이 공백인 경우 0이 반환되야한다")
                .isEqualTo(0);
    }

    @Test
    public void 콤마로_구분하는_문자열_추가() {
        assertThat(add("1,2"))
                .as("합계가 3이 아니면 실패")
                .isEqualTo(3);
    }

    @Test
    public void 콤마와_콜론이_있는_문자열_추가() {
        assertThat(add("1,2:3"))
                .as("합계가 6이 아니면 실패")
                .isEqualTo(6);
    }

    @Test
    public void 문자열에서_커스텀_구분자를_사용한_경우() {
        assertThat(add("//;\n1;2;3"))
                .as("합계가 6이 아니면 실패")
                .isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 문자열에_구분자를_제외하고_숫자가_아닌_값이_있다면_런타임_예외가_발생해야한다() {
        add("1;@;3");
    }

}
