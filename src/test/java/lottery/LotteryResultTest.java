package lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {

    LotteryResult lotteryResult;

    @BeforeEach
    void setUp() {
        lotteryResult = new LotteryResult();

        lotteryResult.setPrizeOf(3, 5000);
        lotteryResult.setPrizeOf(4, 50000);
        lotteryResult.setPrizeOf(5, 1500000);
        lotteryResult.setPrizeOf(6, 2000000000);

        lotteryResult.setWonAmountOf(3, 1);
        lotteryResult.setWonAmountOf(4, 2);
        lotteryResult.setWonAmountOf(5, 0);
        lotteryResult.setWonAmountOf(6, 0);

        lotteryResult.setTotalAmounts(15);
        lotteryResult.setLotteryPrice(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getPrizeOf(int rank, int expectedPrize) {
        assertThat(lotteryResult.getPrizeOf(rank)).isEqualTo(expectedPrize);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:2", "5:0", "6:0"}, delimiter = ':')
    void getWonAmountsOf(int rank, int expectedWonAmount) {
        assertThat(lotteryResult.getWonAmountOf(rank)).isEqualTo(expectedWonAmount);
    }

    @Test
    void getReturnRate() {
        assertThat(lotteryResult.getReturnRate()).isEqualTo(7);
    }

}
