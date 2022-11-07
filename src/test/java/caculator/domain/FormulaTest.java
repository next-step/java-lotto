package caculator.domain;

import caculator.exception.NotFormulaException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class FormulaTest {
    @Test
    void null_또는_blank() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Formula.checkBlank(null))
                .withMessageMatching("공백은 허용되지 않습니다.");
    }

    @Test
    void 수식_개수() {
        assertThat(Formula.checkFormula(Arrays.asList("1", "+", "2"))).isTrue();
        assertThatExceptionOfType(NotFormulaException.class)
                .isThrownBy(() -> Formula.checkFormula(Arrays.asList("1", "+")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
    }

    @Test
    void 수식() {
        assertThat(Formula.checkFormula(Arrays.asList("1", "+", "2"))).isTrue();
        assertThatExceptionOfType(NotFormulaException.class)
                .isThrownBy(() -> Formula.checkFormula(Arrays.asList("1", "2", "+")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
        assertThatExceptionOfType(NotFormulaException.class)
                .isThrownBy(() -> Formula.checkFormula(Arrays.asList("+", "1", "2")))
                .withMessageMatching("수식이 맞는지 확인 바랍니다.");
    }

    @Test
    void 문자열_리스트_변환() {
        assertThat(Formula.strToList("1 + 2")).isEqualTo(Arrays.asList("1", "+", "2"));
    }
}
