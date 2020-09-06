package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottosTest {

    @Test
    void canBuyLottos() {
        assertThat(UserLottos.buyLottosWith(3000)).hasSize(3);
        assertThat(UserLottos.buyLottosWith(0)).hasSize(0);
        assertThat(UserLottos.buyLottosWith(4200)).hasSize(4);
    }
}
