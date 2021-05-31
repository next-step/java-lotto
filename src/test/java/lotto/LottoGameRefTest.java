package lotto;

import lotto.domain.LottoGame_ref;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameRefTest {

    @Test
    public void availablePurchaseLottoCount_자동_수동_구매가능매수확인() {
        LottoGame_ref lottoGameRef = new LottoGame_ref();
        int lottoCount = lottoGameRef.availablePurchaseCount(14500);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    public void purchaseAvailableLotto_구매로또개수생성검증() {
        LottoGame_ref lottoGameRef = new LottoGame_ref();
        assertThat(lottoGameRef.purchaseLottos(14).count()).isEqualTo(14);
    }
}
