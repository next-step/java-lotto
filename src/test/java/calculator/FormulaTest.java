package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormulaTest {

    @Test
    void 계산식_문자열을_문자배열로_변경한다() {
        Formula formula = new Formula("3 + 4 * 2 / 7");

        Assertions.assertThat(formula)
            .isEqualTo(new Formula(new String[]{"3", "+", "4", "*", "2", "/", "7"}));
    }

    @Test
    void 계산을_한다(){
        Formula formula = new Formula("3 + 4 * 2 / 7");

        Assertions.assertThat(formula.calculate()).isEqualTo(2);
    }
}
