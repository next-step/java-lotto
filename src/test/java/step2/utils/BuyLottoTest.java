package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottoTest {
    @Test
    @DisplayName("로또 구매")
    public void buy() {
        BuyLotto buyLotto = new BuyLotto(20000);

        assertThat(buyLotto.buy()).isEqualTo(20);
    }
}
