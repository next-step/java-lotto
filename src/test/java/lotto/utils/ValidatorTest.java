package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("checkNumberValidationTest: 숫자 데이터인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "b"})
    void checkNumberValidationTest(String input) {
        assertThatThrownBy(() -> Validator.checkNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkPriceValidationTest: 로또 구매가능 가격인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {100, 999, 0, 500, 50, 10})
    void checkBuyPriceValidationTest(int input) {
        assertThatThrownBy(() -> Validator.checkBuyPriceValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkLottoNumberValidationTest: 로또번호가 올바른지 확인 (1~45)")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void checkLottoNumberValidationTest(int input) {
        assertThatThrownBy(() -> Validator.checkLottoNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkLengthWinningNumbersValidationTest: 로또 당첨번호 개수가 올바른지 확인 (6)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 7, 8})
    void checkLengthWinningNumbersValidationTest(int input) {
        assertThatThrownBy(() -> Validator.checkLengthLottoNumberSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
