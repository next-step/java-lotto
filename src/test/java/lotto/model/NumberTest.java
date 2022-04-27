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
        Number number = new Number();
        assertAll(() -> assertThat(number).isEqualTo(new Number()),
                () -> assertThat(number.getValue()).isEqualTo(0));
    }

    @ParameterizedTest(name = "Number 객체 생성 - {0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void createInitNumber(int value) {
        Number number = new Number(value);
        assertAll(() -> assertThat(number).isEqualTo(new Number(value)),
                () -> assertThat(number.getValue()).isEqualTo(value));
    }

    @Test
    @DisplayName("Number 더하기")
    void add() {
        Number left = new Number(1);
        Number right = new Number(2);

        assertThat(left.add(right)).isEqualTo(new Number(3));
    }
}