package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.LottoPrice.LOTTO_PRICE_PER_UNIT;
import static step2.LottoPrice.VALID_LOTTO_MINIMUM_AMOUNT_MSG;

class LottoPriceTest {

    @Test
    void 로또_금액_생성() {
        assertThat(new LottoPrice("3000")).isEqualTo(new LottoPrice("3000"));
    }

    @ParameterizedTest
    @ValueSource(strings={"100", "-3000", "0"})
    void 로또_금액_비정상(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoPrice(input);
        }).withMessageMatching(String.format(VALID_LOTTO_MINIMUM_AMOUNT_MSG, LOTTO_PRICE_PER_UNIT));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 로또_금액_비정상_빈값_NULL(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoPrice(input);
        }).withMessageMatching(LottoPrice.VALID_NULL_EMPTY_MSG);
    }

    @Test
    void 로또_구매_가능개수() {
        assertThat(new LottoPrice("3000").getAvailableForPurchaseCount()).isEqualTo(3);
        assertThat(new LottoPrice("4500").getAvailableForPurchaseCount()).isEqualTo(4);
    }


}