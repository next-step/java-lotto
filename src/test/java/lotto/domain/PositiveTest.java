package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositiveTest {

    @DisplayName("양수가 아닌 값으로 생성할 경우 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] value: {0}")
    @ValueSource(ints = {-1, 0})
    void create_notPositive_thrownException(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Positive(value))
                .withMessage(Positive.NOT_POSITIVE_ERROR_MESSAGE);
    }

    @Test
    void create() {
        assertThat(new Positive(1)).isEqualTo(new Positive(1));
    }

    @DisplayName("범위 밖의 값을 가지고 있을 경우 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] value: {0}, left: {1}, right: {2}")
    @CsvSource(value = {
            "3, 4, 5",
            "3, 1, 2",
            "3, 4, 2"
    })
    void range(int value, int left, int right) {
        Positive positive = new Positive(value);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> positive.checkRange(left, right))
                .withMessage(Positive.INVALID_RANGE_ERROR_MESSAGE);
    }

}
