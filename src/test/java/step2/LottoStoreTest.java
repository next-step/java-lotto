package step2;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLotto(new Money(14000L));
        assertThat(lottos.size()).isEqualTo(0);
    }
}
