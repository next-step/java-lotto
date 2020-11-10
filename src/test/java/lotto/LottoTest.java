package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    @Test
    @DisplayName("로또 생성시 number size가 유효하지 않으면 throw IllegalStateException")
    void createTestInvalidNumberSize() {
        assertAll(
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                        .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG),
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
                        .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG)
        );
    }

    @Test
    @DisplayName("로또 숫자가 중복되어 number size가 유효하지 않으면 throw IllegalStateException")
    void createTestDuplicatedNumbers() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(1, 1, 1, 1, 1, 1))
                .withMessage(Lotto.INVALID_NUMBERS_SIZE_ERR_MSG);
    }

    @Test
    @DisplayName("로또 숫자가 지정된 범위 만족하지 않으면 throw IllegalStateException (ex 1~45 사이의 숫자만).")
    void createTestNumberRange() {
        assertAll(
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 46))
                        .withMessage(LottoNumber.INVALID_NUMBER_RANGE_ERR_MSG),
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(0, 1, 2, 3, 4, 5))
                        .withMessage(LottoNumber.INVALID_NUMBER_RANGE_ERR_MSG)
        );
    }
}
