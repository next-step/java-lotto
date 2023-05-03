package lotto;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 금액을_입력하면_로또갯수_출력() {
        int money = 14000;
        List<Lotto> lottos = LottoStore.sell(money);
        assertThat(lottos).hasSize(14);
    }
}
