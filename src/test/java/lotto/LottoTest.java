package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidNumberSize")
    @DisplayName("로또 생성시 number size가 유효하지 않으면 throw IllegalStateException")
    void createTestInvalidNumberSize(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG);
    }

    private static Stream<Arguments> invalidNumberSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @Test
    @DisplayName("로또 숫자가 중복되어 number size가 유효하지 않으면 throw IllegalStateException")
    void createTestDuplicatedNumbers() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(1, 1, 1, 1, 1, 1))
                .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG);
    }

    @ParameterizedTest
    @MethodSource("invalidNumberRange")
    @DisplayName("로또 숫자가 지정된 범위 만족하지 않으면 throw IllegalStateException (ex 1~45 사이의 숫자만).")
    void createTestNumberRange(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage(LottoNumber.INVALID_NUMBER_RANGE_ERR_MSG);
    }

    private static Stream<Arguments> invalidNumberRange() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5))
        );
    }
}
