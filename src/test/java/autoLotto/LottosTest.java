package autoLotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @Test
    void lotto() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto());

        assertThat(lottos.getLottosSize()).isEqualTo(1);
    }
}
