package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class PurchaseAmountTest {
    @ParameterizedTest
    @CsvSource({
            "14000, 14",
            "500, 0",
            "5300, 5"
    })
    void 구입금액_로또개수_테스트(int input, int expect) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        int actual = purchaseAmount.getLottoCount();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void 예외_구입금액_음수_테스트() {
        assertThatThrownBy(() -> {
            PurchaseAmount purchaseAmount = new PurchaseAmount(-1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseAmount.PURCHASE_AMOUNT_MINUS_ERROR_MESSAGE);
    }
}
