package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    @Test
    @DisplayName("로또 생성시 number size가 유효하지 않으면 throw IllegalStateException")
    void createTest_invalidNumberSize() {
        assertAll(
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                        .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG),
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                        .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG)
        );
    }

    @Test
    @DisplayName("로또 숫자가 중복되어 number size가 유효하지 않으면 throw IllegalStateException")
    void createTest_duplicatedNumbers() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG);
    }

    @Test
    @DisplayName("로또 숫자가 지정된 범위 만족하지 않으면 throw IllegalStateException (ex 1~45 사이의 숫자만).")
    void createTest_numberRange() {
        assertAll(
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                        .withMessage(Lotto.INVALID_NUMBER_RANGE_ERR_MSG),
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)))
                        .withMessage(Lotto.INVALID_NUMBER_RANGE_ERR_MSG)
        );
    }
}
