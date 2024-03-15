package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class NumbersTest {

    @DisplayName("들어온 데이터가 비어있다면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenEmptyInput() {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Numbers(List.of()));
    }

    @DisplayName("순차적으로 내부의 값을 읽을 수 있다.")
    @Test
    void canReadSequenceNumbers() {
        // given
        Numbers numbers = new Numbers(List.of("1", "2", "3"));

        assertAll(
                () -> assertThat(numbers.nextNumber()).isEqualTo(1),
                () -> assertThat(numbers.nextNumber()).isEqualTo(2),
                () -> assertThat(numbers.nextNumber()).isEqualTo(3)
        );
    }
}