package lotto.domain;

import lotto.dto.PurchaseMoney;
import lotto.exception.IllegalLottoNumberCountException;
import lotto.exception.NotEnoughMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LottoPriceTest 클래스")
class LottoPriceTest {

    @ParameterizedTest
    @ValueSource(ints={1_200, 45_000, 60_000, 3_000})
    @DisplayName("isEnoughMoney_정상")
    void isEnoughMoney_정상(int value) {
        // Given
        PurchaseMoney purchaseMoney = new PurchaseMoney(value);

        // When, Then
        assertDoesNotThrow(()->LottoPrice.isEnoughMoney(purchaseMoney));
    }

    @ParameterizedTest
    @ValueSource(ints={120, 450, 600, 300})
    @DisplayName("isEnoughMoney_예외")
    void isEnoughMoney_예외(int value) {
        // Given
        PurchaseMoney purchaseMoney = new PurchaseMoney(value);

        // When, Then
        assertThatExceptionOfType(NotEnoughMoneyException.class)
                .isThrownBy(() -> LottoPrice.isEnoughMoney(purchaseMoney));
    }
}