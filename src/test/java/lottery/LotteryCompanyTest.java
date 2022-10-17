package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCompanyTest {

    @Test
    void generateRandomLotteryNumbers() {
        Lottery lottery = LotteryCompany.generateRandomLotteryNumbers();
        List<LotteryNumber> lotteryNumbers = lottery.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest
    @CsvSource(value={"500:0", "1000:1", "14000:14", "14500:14"}, delimiter = ':')
    void getAvailablePurchaseLotteryCount(int cashAmount, int expected) {
        assertThat(LotteryCompany.getAvailablePurchaseLotteryCount(cashAmount)).isEqualTo(expected);
    }
}
