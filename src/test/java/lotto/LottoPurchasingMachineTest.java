package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchasingMachineTest {

    @Test
    void buyLotto() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> ticket = lottoPurchasingMachine.buyLotto(13500);
        List<Lotto> ticket2 = lottoPurchasingMachine.buyLotto(14000);

        assertThat(ticket.size()).isEqualTo(13);
        assertThat(ticket2.size()).isEqualTo(14);
    }
}