package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("생성된 숫자가 0보다 작거나 45보다가 클 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void testNumberValid(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Number(number));
    }
}
