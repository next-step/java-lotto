package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void 유효한_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
