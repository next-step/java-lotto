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
}
