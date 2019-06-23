package step2;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {

    @Test
    void less_money() {
        LottoStore lottoStore = new LottoStore();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoStore.buyLotto(new Money(500L)));
    }

    @Test
    void lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLotto(new Money(14000L));
        assertThat(lottos.size()).isEqualTo(14);
    }
}
