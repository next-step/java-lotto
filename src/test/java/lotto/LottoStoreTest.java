package lotto;

import lotto.game.Round;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoStoreTest {
    @Test
    void buy() {
        Round round = LottoStore.buy(3000);
        assertThat(round.gameCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또를 구매할때 제시할 가격은 1000원의 곱이다.")
    void priceMustMultipleOf1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore.buy(999);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore.buy(1001);
        });
    }
}