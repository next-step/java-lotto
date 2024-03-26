package lotto.common;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 가격보다 적은 구매 금액을 입력하면 IllegalArgumentException 발생한다.")
    void validatePurchase() {
        int money = 500;
        int price = 1000;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoValidator.validatePurchase(money, price));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException 발생한다.")
    void validateLottoNumber() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1,2,3,4,5)));
    }

    @Test
    @DisplayName("로또 번호가 중복되면 IllegalArgumentException 발생한다.")
    void validateLottoNumberDuplicate() {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1,2,3,4,5,5)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    @DisplayName("로또 숫자의 범위가 1~45가 아니면 IllegalArgumentException 이 발생한다.")
    void validateLottoNumberRange(int wrongNumber) {

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoValidator.validateLottoNumberRange(wrongNumber));
    }
}