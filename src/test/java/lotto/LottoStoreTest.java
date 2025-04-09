package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

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

    @DisplayName("로또 수동 생성 테스트")
    @Test
    public void sellLottoWithSlips() throws Exception {
        assertThat(LottoStore.sellLotto(List.of(Set.of(1,2,3,4,5,6))))
                .hasSize(1)
                .containsExactly(new LottoNumbers("1,2,3,4,5,6"));
    }
}