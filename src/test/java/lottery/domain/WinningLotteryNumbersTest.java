package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLotteryNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void duplicatedBonusNumber(int bonusNumber) {
        LotteryTicket lotteryTicket = LotteryTicket.from(Lists.list(1, 2, 3, 4, 5, 6));

        assertThatIllegalArgumentException().isThrownBy(
            () -> WinningLotteryNumbers.of(lotteryTicket, LotteryNumber.from(bonusNumber)));
    }
}
