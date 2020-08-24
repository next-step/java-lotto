package AutoLotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckDivideByTest {

    @Test
    void canDivideforInt() {
        assertThat(CheckDivideBy.divideForInt("100","200")).isEqualTo(0);
        assertThat(CheckDivideBy.divideForInt("400","300")).isEqualTo(1);
        assertThat(CheckDivideBy.divideForInt("0","200")).isEqualTo(0);

    }
}
