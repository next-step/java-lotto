package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 생성() {
        Lotto lotto = new Lotto();

        assertThat(lotto).isEqualTo(new Lotto());
    }

    @Test
    void 금액으로_로또를_살_수_있는_개수를_반환한다() {
        Lotto lotto = new Lotto();
        int money = 14000;
        int lottoCount = lotto.calculateCount(money);

        assertThat(lottoCount).isEqualTo(14);
    }
}
