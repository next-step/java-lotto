package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseAmountTest {

    @ParameterizedTest(name = "구매 로또개수 확인. 구매금액={0}, 로또 수={1}")
    @CsvSource(value = {"14000,14", "3000, 3"})
    void getLottoCount(int purchaseAmountValue, int expectedLottoCount) {

        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountValue);
        assertThat(purchaseAmount.getPurchasedLottosCount()).isEqualTo(expectedLottoCount);
    }

    @ParameterizedTest(name = "구매금액이 0 이하일 경우 IllegalArgumentException 발생")
    @ValueSource(ints = {0, -1})
    void getLottosCountIsLowerEqualsThan0(int purchaseAmountValue) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(purchaseAmountValue));
    }

    @ParameterizedTest(name = "구매금액이 1000원 단위가 아닐 경우 IllegalArgumentException 발생")
    @ValueSource(ints = {1500, 300})
    void purchaseAmountValueIsNot1000(int purchaseAmountValue) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(purchaseAmountValue));
    }

}