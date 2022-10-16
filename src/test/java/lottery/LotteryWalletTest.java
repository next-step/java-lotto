package lottery;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWalletTest {

    static Lottery createLottery(Integer... values) {
        return new Lottery(Arrays.stream(values).map(LotteryNumber::new).collect(Collectors.toList()));
    }

    @Test
    void getLotteries() {
        LotteryWallet lotteryWallet = new LotteryWallet(Arrays.asList(
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 13, 14, 15, 16),
                createLottery(1, 2, 13, 14, 15, 16)
        ));

        List<Lottery> lotteries = lotteryWallet.getLotteries();
        assertThat(lotteries).hasSize(4);
    }
}
