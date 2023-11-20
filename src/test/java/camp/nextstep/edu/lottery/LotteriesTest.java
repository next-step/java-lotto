package camp.nextstep.edu.lottery;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LotteriesTest {

    @ParameterizedTest
    @CsvSource(value = { "999:0", "1000:1", "1999:1", "2000:2" }, delimiter = ':')
    @DisplayName("1000원당 1장의 로또를 생성한다")
    void generateLotteries(int money, int lotteryCount) {
        Lotteries lotteries = new Lotteries(money);
        assertThat(lotteries.count()).isEqualTo(lotteryCount);
    }
}
