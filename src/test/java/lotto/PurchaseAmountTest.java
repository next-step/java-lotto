package lotto;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PurchaseAmountTest {
    @Test
    public void 구입한_금액만큼_로또_갯수가져오기_1개이상() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("14000");
        int lottoCnt = purchaseAmount.getLotto();
        assertThat(lottoCnt).isEqualTo(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구입한_금액만큼_로또_갯수가져오기_1개미만() {
        new PurchaseAmount("100");
    }
}