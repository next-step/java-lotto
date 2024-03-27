package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void create() {
        Lottos lottos = LottoGenerator.lotteryTickets(3);
        assertThat(lottos).isNotNull();
    }
}
