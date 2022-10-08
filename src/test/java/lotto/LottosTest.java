package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 로또_리스트_개수_n() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.lottosSize()).isEqualTo(14);
    }
}
