package lotto;

import lotto.game.Round;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    @Test
    void buy() {
        Round round = LottoStore.buy(new Amount(3000));
        assertThat(round.gameCount()).isEqualTo(3);
    }
}