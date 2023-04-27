package step2.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.model.Lotto.Lottos;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setLottos() {
        this.lottos = new Lottos(8);
    }

    @Test
    void getLottos() {
        System.out.println(lottos);
    }
}