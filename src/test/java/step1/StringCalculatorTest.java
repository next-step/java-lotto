package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "3 + 5:8",
            "10 + 9:19",
            "3 - 7:-4",
            "10 * 4:40",
            "3 / 7:0",
            "3 + 5 - 7:1",
            "7 * 3 + 1 / 3:7",
            "8 / 3 - 10 * 2 + 3:-13"
    })
    @DisplayName("연산 테스트")
    void calculate(String input) {
        String[] split = input.split(":");
        String expressions = split[0];
        Integer expected = Integer.parseInt(split[1]);

        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(expressions);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 ( 2",
            "3 * 2 & 10",
            "10 * @ 10",
            "",
    })
    @DisplayName("연산 오류 테스트")
    void calculate_invalid(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }


}
