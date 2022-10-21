package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void generate_Number_of_tickets() {
        BigDecimal amount = BigDecimal.valueOf(14000);
        Lottos lottos = new Lottos(amount).buyLottos(amount);
        assertThat(lottos.getLottoList()).hasSize(14);
    }
}
