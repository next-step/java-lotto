package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 판매점 생성 테스트")
    void createLottoStore() {
        LottoStore lottoStore = new LottoStore(14000);
        assertThat(lottoStore).isNotNull();
    }

    @Test
    @DisplayName("구매금액에 맞춰 로또를 발급한다")
    void purchaseLotto() {
        final int purchaseAmount = 14000;
        LottoStore lottoStore = new LottoStore(purchaseAmount);
        List<Lotto> lottoList = lottoStore.getLotto();
        assertThat(lottoList).hasSize(purchaseAmount/LottoStore.LOTTO_PRICE);
    }
}
