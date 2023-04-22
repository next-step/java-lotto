package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
    }

    @Test
    void calculate_정상() throws Exception {
        //given
        String input = "2 + 3 * 4 / 2";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void calculate_null_또는_Empty(String input) throws Exception {
        //given

        //when

        //then
        assertThatThrownBy(() -> {
            int result = calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null과 공백은 입력할 수 없습니다.");
    }
}
