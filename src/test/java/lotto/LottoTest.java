package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 입력된_금액에_맞는_로또_개수를_구한다() {
        int money = 14000;
        int lottoCount = Lotto.lottoCount(money);

        assertThat(lottoCount).isEqualTo(14);
    }
}
