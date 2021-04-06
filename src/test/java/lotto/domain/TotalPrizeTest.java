package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalPrizeTest {

    @Test
    @DisplayName("총 당첨 금액 생성")
    public void create() throws Exception {
        TotalPrize totalPrize = new TotalPrize(1_000);
        assertThat(totalPrize).isEqualTo(new TotalPrize(1_000));
    }

    @Test
    @DisplayName("총 당첨 금액을 구매 금액으로 나누면 수익률이 나온다.")
    public void dividedBy() throws Exception {
        //given
        int prize = 10_000;
        TotalPrize totalPrize = new TotalPrize(prize);
        int amount = 1_000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        //when
        double profitRate = totalPrize.dividedBy(purchaseAmount);

        //then
        assertThat(profitRate).isEqualTo((double) prize / amount);
    }

    @Test
    @DisplayName("각 당첨된 금액을 더해 총 당첨 금액을 구한다.")
    public void sum() throws Exception {
        TotalPrize totalPrize = TotalPrize.from(Arrays.asList(1_000, 2_000));
        assertThat(totalPrize.sum()).isEqualTo(3_000);
    }
}
