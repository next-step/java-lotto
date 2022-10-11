package lottery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static lottery.Lottery.getInstanceByInt;
import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCompanyTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:2", "3:2", "4:0", "5:0", "6:0"}, delimiter = ':')
    void getLotteryResult(int rank, int expected) {
        LotteryWallet lotteryWallet = new LotteryWallet(Arrays.asList(
                getInstanceByInt(Arrays.asList(1, 2, 3, 14, 15, 16)),
                getInstanceByInt(Arrays.asList(1, 2, 3, 14, 15, 16)),
                getInstanceByInt(Arrays.asList(1, 2, 13, 14, 15, 16)),
                getInstanceByInt(Arrays.asList(1, 2, 13, 14, 15, 16))
        ));

        LotteryResult lotteryResult = LotteryCompany
                .createLotteryResult(getInstanceByInt(Arrays.asList(1, 2, 3, 4, 5, 6)), lotteryWallet);
        assertThat(lotteryResult.getWonAmountOf(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"500:0", "1000:1", "14000:14", "14500:14"}, delimiter = ':')
    void getAvailablePurchaseLotteryCount(int cashAmount, int expected) {
        assertThat(LotteryCompany.getAvailablePurchaseLotteryCount(cashAmount)).isEqualTo(expected);
    }
}
