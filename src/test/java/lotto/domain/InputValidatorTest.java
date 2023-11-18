package lotto.domain;

import lotto.exception.ExceedLottoPurchaseException;
import lotto.exception.InsufficientPriceException;
import lotto.exception.LottoSizeException;
import lotto.exception.MisMatchPriceUnitException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("성공 - 구입한 수동 로또 개수가 구입 금액을 초과하지 않을 경우 예외가 발생하지 않는다.")
    void success_lotto_purchase_not_exceed_amount() {
        int manualLottoCount = 3;
        int price = 4000;
        InputValidator.validateLottoPurchaseAmount(manualLottoCount, price);
    }

    @Test
    @DisplayName("실패 - 구입한 수동 로또 개수가 구입 금액을 초과할 경우 예외가 발생한다.")
    void fail_lotto_purchase_exceed_amount() {
        int manualLottoCount = 5;
        int price = 4000;
        Assertions.assertThatThrownBy(() -> InputValidator.validateLottoPurchaseAmount(manualLottoCount, price))
                .isInstanceOf(ExceedLottoPurchaseException.class)
                .hasMessage("구매할 수동 로또 개수에 비해 구입 금액이 부족합니다.");
    }

    @Test
    @DisplayName("성공 - 입력한 번호 개수가 6개면 예외가 발생하지 않는다.")
    void success_lotto_size() {
        InputValidator.validateNumberCount(6);
    }

    @Test
    @DisplayName("실패 - 구입한 수동 로또 개수가 구입 금액을 초과할 경우 예외가 발생한다.")
    void fail_lotto_size() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateNumberCount(7))
                .isInstanceOf(LottoSizeException.class)
                .hasMessage("번호는 반드시 6개를 입력해야 합니다.");
    }

}
