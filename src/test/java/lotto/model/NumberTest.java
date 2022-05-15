package lotto.model;

import lotto.util.Calculator;
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
        long longOne = 1L;
        double doubleOne = 1.0;
        String stringOne = "1";

        assertAll(() -> assertThat(Number.of(longOne).longValue()).isEqualTo(longOne),
                () -> assertThat(Number.of(longOne).doubleValue()).isEqualTo(doubleOne),
                () -> assertThat(Number.of(doubleOne).longValue()).isEqualTo(longOne),
                () -> assertThat(Number.of(doubleOne).doubleValue()).isEqualTo(doubleOne),
                () -> assertThat(Number.of(stringOne).longValue()).isEqualTo(longOne),
                () -> assertThat(Number.of(stringOne).doubleValue()).isEqualTo(doubleOne));
    }

    @Test
    @DisplayName("Number 사칙연산")
    void add() {
        Number left = Number.of(100);
        Number right = Number.of(50);

        assertAll(
                () -> assertThat(Calculator.add(left, right)).isEqualTo(Number.of(150)),
                () -> assertThat(Calculator.add(right, left)).isEqualTo(Number.of(150)),
                () -> assertThat(Calculator.subtract(left, right)).isEqualTo(Number.of(50)),
                () -> assertThat(Calculator.subtract(right, left)).isEqualTo(Number.of(-50)),
                () -> assertThat(Calculator.multiply(left, right)).isEqualTo(Number.of(5000)),
                () -> assertThat(Calculator.multiply(right, left)).isEqualTo(Number.of(5000)),
                () -> assertThat(Calculator.divide(left, right)).isEqualTo(Number.of(2.0)),
                () -> assertThat(Calculator.divide(right, left)).isEqualTo(Number.of(0.5)));
    }

    @Test
    @DisplayName("Number 최소 / 최대")
    void minAndMax() {
        Number left = Number.of(100);
        Number right = Number.of(50);

        assertAll(
                () -> assertThat(Calculator.min(left, right)).isEqualTo(right),
                () -> assertThat(Calculator.max(right, left)).isEqualTo(left));
    }
}
