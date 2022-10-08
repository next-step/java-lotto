package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력값이__빈스트링일_경우_에러발생(String blank){
        Assertions.assertThatThrownBy(() -> new Formula(blank))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 문자열 사용 금지");
    }

    @Test
    void 입력값이_NULL일_경우_에러발생(){
        String nullString = null;
        Assertions.assertThatThrownBy(() -> new Formula(nullString))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("null 사용 금지");
    }
}
