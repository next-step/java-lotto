package calculator;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings={"", "  "})
    public void givenString_whenNullOrEmptyString_thenThrowException(String str) {
        System.out.println("[!] null, empty string test = [" + str + "]");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(str);
        });
    }

    @Test
    public void splitString() {
        String str = "1 + 2 * 3 - 1";

        AssertionsForClassTypes.assertThat(StringCalculator.splitString(str))
                .containsExactly("1", "+", "2", "*", "3", "-", "1");
    }

    @Test
    public void calculate() {
        String str = "1 + 2 * 3 - 1 / 2";

        StringCalculator calc = new StringCalculator(str);

        AssertionsForClassTypes.assertThat(calc.calculate())
                .isEqualTo(4);
    }
}
