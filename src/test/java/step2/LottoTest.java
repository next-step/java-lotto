package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoStore;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 구매갯수계산() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.getPurchaseLottoCount(14000)).isEqualTo(14);
    }
}
