package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoQuantityTest {

    @Test
    void create() {
        LottoQuantity lottoQuantity = new LottoQuantity(100000);
        assertThat(lottoQuantity).isEqualTo(new LottoQuantity(100000));
    }

    @Test
    void 구입금액_변환_수량() {
        LottoQuantity lottoQuantity = new LottoQuantity(100000);
        assertThat(lottoQuantity.getTotalQuantity()).isEqualTo(100);
    }
}
