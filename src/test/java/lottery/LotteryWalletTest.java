package lottery;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWalletTest {

    @Test
    void generate() {
        LotteryWallet lotteryWallet = new LotteryWallet();
        lotteryWallet.generateLottery(3);

        List<Lottery> lotteries = lotteryWallet.getLotteries();
        assertThat(lotteries).hasSize(3);
    }
}
