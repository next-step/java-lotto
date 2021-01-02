package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos();
    }

    @Test
    void createLottoNumber() {
        lottos.createAutoNumber(15);
        assertThat(lottos.buyLottoCount()).isEqualTo(15);
    }
}