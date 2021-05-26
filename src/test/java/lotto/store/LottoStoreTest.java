package lotto.store;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName(value = "구매 가능한 로또의 개수는 budget / price 이다")
    void count() {
        LottoStore lottoStore = new LottoStore(new Budget(10_000), 1_000);
        assertThat(lottoStore.purchaseCount()).isEqualTo(10);
    }

}
