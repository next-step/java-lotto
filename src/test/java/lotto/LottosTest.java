package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    public void init() {
        lottos = new Lottos(14);
    }

    @Test
    void makeLottos() {
        lottos = new Lottos(10);

        var actualSize = lottos.getLottoList().size();
        var expectSize = 10;

        assertThat(actualSize).isEqualTo(expectSize);
    }
}
