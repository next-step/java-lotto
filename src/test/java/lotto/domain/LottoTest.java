package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_구입() {
        ILottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(5000,lottoGenerator);
        lotto.buy();

        assertThat(lotto.getUserLotto().getTickets()).hasSize(5);
    }
}
