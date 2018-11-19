package lotto.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    Money money;

    @Before
    public void setup() {
        money = new Money(10000);
    }

    @Test
    public void 자동_로또_구매_개수() {
        int autoLottoCount = money.buyManualLotto(5);

        assertThat(autoLottoCount).isEqualTo(5);
    }

    @Test
    public void 수익률() {
        float earningRate = money.earningsRate(20000L);
        assertThat(earningRate).isEqualTo(2.0f);
    }
}