package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NumberTest {

    @Test
    @DisplayName("Number 생성 - 0")
    void createNumber() {
        assertAll(() -> assertThat(Number.of().longValue()).isEqualTo(0),
                () -> assertThat(Number.of().doubleValue()).isEqualTo(0.0));
    }

    @Test
    @DisplayName("Number 생성 - Value 주입")
    void injectValue() {
        assertAll(() -> assertThat(Number.of(1).longValue()).isEqualTo(1),
                () -> assertThat(Number.of(1).doubleValue()).isEqualTo(1.0),
                () -> assertThat(Number.of(1.0).longValue()).isEqualTo(1),
                () -> assertThat(Number.of(1.0).doubleValue()).isEqualTo(1.0),
                () -> assertThat(Number.of("1").longValue()).isEqualTo(1),
                () -> assertThat(Number.of("1").doubleValue()).isEqualTo(1.0));
    }

    @Test
    @DisplayName("Number 사칙연산")
    void add() {
        Number left = Number.of(100);
        Number right = Number.of(50);

        assertAll(
                () -> assertThat(left.add(right)).isEqualTo(Number.of(150)),
                () -> assertThat(right.add(left)).isEqualTo(Number.of(150)),
                () -> assertThat(left.subtract(right)).isEqualTo(Number.of(50)),
                () -> assertThat(right.subtract(left)).isEqualTo(Number.of(-50)),
                () -> assertThat(left.multiple(right)).isEqualTo(Number.of(5000)),
                () -> assertThat(right.multiple(left)).isEqualTo(Number.of(5000)),
                () -> assertThat(left.divide(right)).isEqualTo(Number.of(2.0)),
                () -> assertThat(right.divide(left)).isEqualTo(Number.of(0.5)));
    }

    @Test
    @DisplayName("Number 최소 / 최대")
    void minAndMax() {
        Number left = Number.of(100);
        Number right = Number.of(50);

        assertAll(
                () -> assertThat(Number.min(left, right)).isEqualTo(right),
                () -> assertThat(Number.max(right, left)).isEqualTo(left));
    }
}
