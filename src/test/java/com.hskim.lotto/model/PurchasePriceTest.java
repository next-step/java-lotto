package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchasePriceTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        String price = String.valueOf(LottoTicket.LOTTO_PRICE * 3);
        PurchasePrice purchasePrice = new PurchasePrice(price);

        // when & then
        assertThat(purchasePrice).isEqualTo(new PurchasePrice(price));
    }

    @DisplayName("생성 실패 테스트 - 숫자가 아닌 입력")
    @Test
    void create_숫자아닌입력_실패() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PurchasePrice("fail test");
        }).withMessage(LottoExceptionMessage.NON_NUMERICAL_VALUE.getMessage());
    }

    @DisplayName("생성 실패 테스트 - 로또 가격으로 나누어 떨어지지 않는 수 입력")
    @ParameterizedTest
    @ValueSource(doubles = {LottoTicket.LOTTO_PRICE * 2.5, LottoTicket.LOTTO_PRICE * 7.5})
    void create_나누어지지_않는수_실패(double purchasePrice) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PurchasePrice(String.valueOf((int) purchasePrice));
        }).withMessage(LottoExceptionMessage.INVALID_PURCHASE_PRICE.getMessage());
    }
}
