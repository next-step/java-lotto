package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    @DisplayName("예산 별 로또 판매 개수 테스트")
    @Test
    public void sellLotto() throws Exception {
        assertThat(LottoStore.sellLotto(1000))
                .hasSize(1);

        assertThat(LottoStore.sellLotto(10000))
                .hasSize(10);

        assertThat(LottoStore.sellLotto(15243))
                .hasSize(15);

        assertThat(LottoStore.sellLotto(100000000))
                .hasSize(100000);
    }
}