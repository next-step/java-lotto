package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottosTest {
    @DisplayName("로또 금액은 1000의배수.")
    @Test
    void price_lotto(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BuyLottos(14500);
        });
    }
    @DisplayName("로또 개수는 금액/1000.")
    @Test
    void count_lotto(){
        BuyLottos buyLottos = new BuyLottos(14000);
        assertThat(buyLottos.getCountOfLotto()).isEqualTo(14);
    }
}
