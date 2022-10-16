package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCompanyTest {

    static Lottery createLottery(Integer... values) {
        return new Lottery(Arrays.stream(values).map(LotteryNumber::new).collect(Collectors.toList()));
    }

    @Test
    void generateRandomLotteryNumbers() {
        Lottery lottery = LotteryCompany.generateRandomLotteryNumbers();
        List<LotteryNumber> lotteryNumbers = lottery.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest
    @CsvSource(value = {"3:2", "4:0", "5:0", "6:0"}, delimiter = ':')
    void getLotteryResult(int rank, int expected) {
        List<Lottery> lotteries = Arrays.asList(
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 3, 14, 15, 16),
                createLottery(1, 2, 13, 14, 15, 16),
                createLottery(1, 2, 13, 14, 15, 16)
        );


        LotteryResult lotteryResult = LotteryCompany
                .createLotteryResult(createLottery(1, 2, 3, 4, 5, 6), lotteries);
        assertThat(lotteryResult.getWonCountOf(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"500:0", "1000:1", "14000:14", "14500:14"}, delimiter = ':')
    void getAvailablePurchaseLotteryCount(int cashAmount, int expected) {
        assertThat(LotteryCompany.getAvailablePurchaseLotteryCount(cashAmount)).isEqualTo(expected);
    }
}
