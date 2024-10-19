package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.model.BuyAmount.ERROR_LOWER_MINIMUM_BUY_AMOUNT;
import static lotto.model.BuyAmount.LOTTO_NOT_ALLOWED_REMAINDER;
import static org.assertj.core.api.Assertions.*;

public class BuyAmountTest {
    @Test
    void 구입금액_저장() {
        assertThatNoException().isThrownBy(() -> {
            BuyAmount buyAmount = new BuyAmount(1000);
        });
    }

    @Test
    void 구입금액이_1000원_미만이면_오류() {
        assertThatThrownBy(() -> {
                    BuyAmount buyAmount = new BuyAmount(999);

                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_LOWER_MINIMUM_BUY_AMOUNT);

    }

    @Test
    void 구입금액이_1000원으로_나눗셈할때_나머지가_있으면_오류() {
        assertThatThrownBy(() -> {
                    BuyAmount buyAmount = new BuyAmount(1001);

                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NOT_ALLOWED_REMAINDER);
    }

    @Test
    void 구입금액을_이용하여_전체_로또_번호_갯수를_출력한다() {
        BuyAmount buyAmount = new BuyAmount(12000);
        int actual = buyAmount.count();
        int expected = 12;
        assertThat(actual).isEqualTo(expected);
    }
}
