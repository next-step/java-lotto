package calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 공백인 경우 IllegalArgumentException")
    void 입력값_공백(){
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
            InputView.isNullOrBlank(null);
        }).withMessageMatching("\\s");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.isNullOrBlank("");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 사칙연산_기호임(String symbol) {
        assertTrue(InputView.isElementaryArithmeticSymbol(symbol));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
    @ValueSource(strings = {"a", " ", ":", "$", ""})
    void 사칙연산_기호_아님(String symbol) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputView.isElementaryArithmeticSymbol(symbol);
                }).withMessageMatching("\\s");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.isElementaryArithmeticSymbol(symbol);
        });
    }


}
