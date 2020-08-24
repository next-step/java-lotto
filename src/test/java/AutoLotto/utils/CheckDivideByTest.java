package AutoLotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckDivideByTest {

    @Test
    void canDivideToInt() {
        assertThat(CheckDivideBy.divideToInt("100","200")).isEqualTo(0);
        assertThat(CheckDivideBy.divideToInt("400","300")).isEqualTo(1);
        assertThat(CheckDivideBy.divideToInt("0","200")).isEqualTo(0);

    }

    @Test
    void canDivideToDecimal() {
        assertThat(CheckDivideBy.divideToDecimal("5000","14000")).isEqualTo(0.35);
        assertThat(CheckDivideBy.divideToDecimal("5","140")).isEqualTo(0.03);
        assertThat(CheckDivideBy.divideToDecimal("0","200")).isEqualTo(0);

    }
}
