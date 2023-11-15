package lotto.domain;

import lotto.exception.InsufficientPriceException;
import lotto.exception.MisMatchPriceUnitException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    @DisplayName("실패 - 1000원 미만일 경우 로또를 구매할 수 없다.")
    void fail_insufficient_purchase_price(int price) {
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchasePrice(price))
                .isInstanceOf(InsufficientPriceException.class)
                .hasMessage("로또 최소 금액 단위는 1000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {14000, 140000, 200000})
    @DisplayName("성공 - 로또 금액 단위가 1000원 단위 일경우 로또를 구매할 수 있다.")
    void success_purchase_price_unit(int price) {
        InputValidator.validatePurchasePrice(price);
    }

    @ParameterizedTest
    @ValueSource(ints = {12345, 12340, 12300})
    @DisplayName("실패 - 로또 금액 단위가 1000원 단위가 아닐 경우 로또를 구매할 수 없다.")
    void fail_purchase_price_unit(int price) {
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchasePrice(price))
                .isInstanceOf(MisMatchPriceUnitException.class)
                .hasMessage("구입할 수 있는 로또의 금액 단위는 1000원 단위 입니다.");
    }

}
