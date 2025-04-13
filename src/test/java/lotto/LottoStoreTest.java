package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    @DisplayName("로또 자동 생성 개수 테스트")
    @Test
    public void sellLotto() throws Exception {
        assertThat(LottoStore.sellLotto(1))
                .hasSize(1);

        assertThat(LottoStore.sellLotto(10))
                .hasSize(10);

        assertThat(LottoStore.sellLotto(15))
                .hasSize(15);

        assertThat(LottoStore.sellLotto(100000))
                .hasSize(100000);
    }

    @DisplayName("로또 수동 생성 테스트")
    @Test
    public void sellLottoWithSlips() throws Exception {
        assertThat(LottoStore.sellLotto(List.of(Set.of(1,2,3,4,5,6))))
                .hasSize(1)
                .containsExactly(new LottoNumbers("1,2,3,4,5,6"));
    }

    @DisplayName("로또 자동 + 수동 생성 테스트")
    @Test
    public void sellLottoWithGenerateAndSlips() throws Exception {
        assertThat(LottoStore.sellLotto(new LottoPaper(500), List.of(Set.of(1,2,3,4,5,6))).getLottoNumbers())
                .hasSize(0);

        assertThat(LottoStore.sellLotto(new LottoPaper(1000), List.of(Set.of(1,2,3,4,5,6))).getLottoNumbers())
                .hasSize(1)
                .containsExactly(new LottoNumbers("1,2,3,4,5,6"));

        assertThat(LottoStore.sellLotto(new LottoPaper(2000), List.of(Set.of(1,2,3,4,5,6))).getLottoNumbers())
                .hasSize(2)
                .contains(new LottoNumbers("1,2,3,4,5,6"));
    }
}