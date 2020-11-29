package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @Test
    void lotto() {
        assertThat(LottoGame.lotto(new Money(1000))).isInstanceOf(Lottos.class);
    }

}