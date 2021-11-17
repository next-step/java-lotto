package edu.nextstep.camp.calc.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositiveNumberTest {
    @Test
    public void create() {
        assertThat(PositiveNumber.of(0).toInt()).isEqualTo(0);
        assertThat(PositiveNumber.of(0)).isEqualTo(PositiveNumber.ofZero());
        assertThat(PositiveNumber.of("0")).isEqualTo(PositiveNumber.ofZero());
    }

    @Test
    public void createFailed() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumber.of(-1))
                .withMessageContaining("invalid input");
    }

    @Test
    public void sum() {
        assertThat(PositiveNumber.sum(PositiveNumber.of(0), PositiveNumber.of(0))).isEqualTo(PositiveNumber.ofZero());
        assertThat(PositiveNumber.sum(PositiveNumber.of(1), PositiveNumber.of(2))).isEqualTo(PositiveNumber.of(3));
    }
}
