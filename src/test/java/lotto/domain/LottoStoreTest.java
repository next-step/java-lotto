package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구매")
    void buyLotto() {
        int money = 10000;
        LottoStore lottoStore = new LottoStore(money);
        List<LottoNumbers> lottoNumbers = lottoStore.buyingLotto();
        assertThat(lottoNumbers.size()).isEqualTo(10);
    }
}