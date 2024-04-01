package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoStoreTest {
    @DisplayName("금액에 따라 로또가 구매된다.")
    @Test
    void buyLottos() {
        LottoStore lottoStore = new LottoStore();
        Assertions.assertThat(lottoStore.buyLottos(14000).size())
                .isEqualTo(14);
    }

}