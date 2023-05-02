package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryStandTest {
    @Test
    public void buyLotteriesWithAmount() {
        LotteryStand lotteryStand = new LotteryStand();
        var lotteries = lotteryStand.buyLotteriesOfAmount(14000);
        assertThat(lotteries).hasSize(14);
    }
}
