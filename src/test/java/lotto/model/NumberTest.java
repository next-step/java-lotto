package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class NumberTest {

    @Test
    @DisplayName("Number 객체 생성")
    void createDefaultNumber() {
        Number number = Number.of();
        assertAll(() -> assertThat(number).isEqualTo(Number.of()),
                () -> assertThat(number.getLongValue()).isEqualTo(0));
    }

    @ParameterizedTest(name = "Number 객체 생성 - {0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void createInitNumber(int value) {
        Number number = Number.of(value);
        assertAll(() -> assertThat(number).isEqualTo(Number.of(value)),
                () -> assertThat(number.getLongValue()).isEqualTo(value));
    }

    @Test
    @DisplayName("Number 더하기")
    void add() {
        Number left = Number.of(1);
        Number right = Number.of(2);

        assertThat(left.add(right)).isEqualTo(Number.of(3));
    }
}