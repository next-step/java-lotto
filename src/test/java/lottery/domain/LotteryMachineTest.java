package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {

    @ParameterizedTest(name = "createLotteries 테스트 - money 입력 | {arguments}")
    @CsvSource(value = {"2500|2", "9900|9", "1000|1"}, delimiter = '|')
    public void createLotteriesByMoney(int moneyNumber, int expectedSize) {
        // given
        LotteryOrder lotteryOrder = new LotteryOrder(new Money(moneyNumber), Collections.emptyList());

        // when
        Lotteries lotteries = LotteryMachine.createLotteries(lotteryOrder);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.toDto().size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("createLotteries 테스트 - String 리스트 입력")
    public void createLotteriesByStrings() {
        // given
        List<String> numbers = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        LotteryOrder lotteryOrder = new LotteryOrder(new Money(3000), numbers);
        int expectedSize = 3;

        // when
        Lotteries lotteries = LotteryMachine.createLotteries(lotteryOrder);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.toDto().size()).isEqualTo(expectedSize);
    }

}