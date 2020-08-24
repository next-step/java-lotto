package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void buyLottosHowMany() {
        assertThat(Lottos.buyLottosWith(3000)).hasSize(3);
        assertThat(Lottos.buyLottosWith(0)).hasSize(0);
        assertThat(Lottos.buyLottosWith(4200)).hasSize(4);
    }
}
