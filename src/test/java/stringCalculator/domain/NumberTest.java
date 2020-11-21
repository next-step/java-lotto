package stringCalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    public void replaceNullToZero() {
        Assertions.assertThat(new Number("").getNumber())
                .isEqualTo(0);
    }

    @Test
    public void validType() {
        Assertions.assertThatThrownBy(() -> {
            new Number("-1");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void validNumber() {
        Assertions.assertThatThrownBy(() -> {
            new Number("a");
        }).isInstanceOf(RuntimeException.class);
    }
}