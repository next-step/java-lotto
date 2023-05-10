package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void purchaseLotto() {
        BigDecimal payment = BigDecimal.valueOf(14000);
        Lottos lottos = LottoStore.purchaseLotto(payment);

        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }
}
