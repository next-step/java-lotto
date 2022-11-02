package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryCompanyTest {

    @Test
    void generateRandomLotteryNumbers() {
        Lottery lottery = LotteryCompany.generateRandomLotteryNumbers();
        List<LotteryNumber> lotteryNumbers = lottery.getLotteryNumbers();

        assertThat(lotteryNumbers).hasSize(6);
        assertThat(lotteryNumbers).doesNotHaveDuplicates();
    }

    @ParameterizedTest
    @CsvSource(value={"1000:1", "14000:14", "14500:14"}, delimiter = ':')
    void 구입가능금액_1000원_이상(int cashAmount, int expected) {
        assertThat(LotteryCompany.getAvailablePurchaseAmount(cashAmount)).isEqualTo(expected);
    }

    @Test
    void 구입가능금액_1000원_미만() {
        assertThatThrownBy(() -> LotteryCompany.getAvailablePurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
