package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test
    public void 한장_구매() {
        assertThat(new LottoMoney(1000).countOfLotto()).isEqualTo(1);
        assertThat(new LottoMoney(1999).countOfLotto()).isEqualTo(1);
    }

    @Test
    public void 두장_구매() {
        assertThat(new LottoMoney(2000).countOfLotto()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void 천원_미만() {
        assertThat(new LottoMoney(999));
    }
}