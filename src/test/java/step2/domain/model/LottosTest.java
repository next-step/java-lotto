package step2.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.strategy.lotto.LottoPolicyStrategy;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setLottos() {
        this.lottos = new Lottos(new LottoPolicyStrategy(), 8);
    }

    @Test
    void getLottos() {
        System.out.println(lottos);
    }
}