package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test
    public void 한장_구매() {
        assertThat(new LottoMoney(1000).getNumberOfLotto()).isEqualTo(1);
        assertThat(new LottoMoney(1500).getNumberOfLotto()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지_않은_금액() {
        new LottoMoney(500);
    }


}
