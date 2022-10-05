package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("로또를 판매한다")
    @Test
    void sell() {
        Integer purchaseAmount = 3000;
        Lotto manualLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto manualLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lottos manualLottos = new Lottos(List.of(manualLotto1, manualLotto2));
        Lotto autoLotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lottos autoLottos = new Lottos(List.of(autoLotto));

        LottoStore lottoStore = new LottoStore(() -> autoLotto);
        Lottos result = lottoStore.sell(purchaseAmount, manualLottos);

        assertThat(result).isEqualTo(manualLottos.add(autoLottos));
    }
}