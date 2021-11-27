package edu.nextstep.camp.calc.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositiveNumberTest {
    @Test
    public void create() {
        assertThat(PositiveNumber.of(0).toInt()).isEqualTo(0);
        assertThat(PositiveNumber.of(0)).isEqualTo(PositiveNumber.ZERO);
        assertThat(PositiveNumber.of("0")).isEqualTo(PositiveNumber.ZERO);
    }

    @Test
    public void createFailed() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumber.of(-1))
                .withMessageContaining("invalid input");
    }

    @Test
    public void sum() {
        assertThat(PositiveNumber.of(0).add(PositiveNumber.of(0))).isEqualTo(PositiveNumber.ZERO);
        assertThat(PositiveNumber.of(1).add(PositiveNumber.of(2))).isEqualTo(PositiveNumber.of(3));
    }
}
