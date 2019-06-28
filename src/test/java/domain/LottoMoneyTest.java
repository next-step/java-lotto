package domain;

import domain.LottoMoney;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구입금액이_1000원_미만이면_에러() {
        // when
        new LottoMoney(999);
    }
    @Test
    public void 금액에_해당하는_로또_개수() {
        assertThat(new LottoMoney(1000).getTryNo()).isEqualTo(1);
        assertThat(new LottoMoney(1500).getTryNo()).isEqualTo(1);
        assertThat(new LottoMoney(14000).getTryNo()).isEqualTo(14);

    }
}