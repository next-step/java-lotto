package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test
    void 금액_투입시_로또_갯수_반환() {
        int lottoCount = LottoMoney.getLottoCount(6000);
        assertThat(lottoCount).isEqualTo(6);
    }
}
