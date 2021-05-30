package lotto;

import lotto.domain.PurchaseLotto;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLottoTest {

    @Test
    public void availablePurchaseLottoCount_구매가능매수확인() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        int lottoCount = purchaseLotto.availablePurchaseLottoCount(14000);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    public void purchaseAvailableLotto_구매로또개수생성검증() {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        assertThat(purchaseLotto.purchaseAvailableLotto(14).count()).isEqualTo(14);
    }
}
