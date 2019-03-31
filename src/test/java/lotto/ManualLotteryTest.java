package lotto;

import lotto.domain.Lotteries;
import lotto.domain.Lottery;
import org.junit.Test;

import java.util.Arrays;

import static lotto.domain.LotteryNo.makeLotteryNos;
import static org.assertj.core.api.Assertions.assertThat;

public class ManualLotteryTest {
    static final int NumberManualLotteries = 3;
    static final Lottery firstManualLottery = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6)));
    static final Lottery secondManualLottery = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 7, 8)));
    static final Lottery thirdManualLottery = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 9, 10)));
    static final Lotteries lotteries = new Lotteries();

    @Test
    public void 수동_구매_개수_입력_테스트() {
        lotteries.addLottery(firstManualLottery)
                .addLottery(secondManualLottery)
                .addLottery(thirdManualLottery);

        assertThat(lotteries.size()).isEqualTo(NumberManualLotteries);
    }
}
