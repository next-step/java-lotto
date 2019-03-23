import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test
    public void 금액에_해당하는_로또_개수() {
        assertThat(new LottoMoney(1000).count()).isEqualTo(1);
        assertThat(new LottoMoney(1500).count()).isEqualTo(1);
        assertThat(new LottoMoney(14000).count()).isEqualTo(14);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원이하_입력시_에러발생() {
        new LottoMoney(700).count();
    }
}