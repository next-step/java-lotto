package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryFactoryTest {

    @ParameterizedTest(name = "getLotteries 테스트 - money 입력 | {arguments}")
    @CsvSource(value = {"2500|2", "9900|9", "1000|1"}, delimiter = '|')
    public void getLotteriesByMoney(int moneyNumber, int expectedSize) {
        // given
        Money money = new Money(moneyNumber);

        // when
        List<Lottery> lotteries = LotteryFactory.getLotteries(money);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("getLotteries 테스트 - String 리스트 입력")
    public void getLotteriesByStrings() {
        // given
        List<String> numbers = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");
        int expectedSize = 2;

        // when
        List<Lottery> lotteries = LotteryFactory.getLotteries(numbers);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("getManualLotteryQuantity 테스트")
    public void getManualLotteryQuantity() {
        // given
        String quantity = "4";
        Money money = new Money(5000);
        LotteryQuantity expectedQuantity = new LotteryQuantity(4);

        // when
        LotteryQuantity lotteryQuantity = LotteryFactory.getManualLotteryQuantity(quantity, money);

        // then
        assertThat(lotteryQuantity).isNotNull();
        assertThat(lotteryQuantity).isEqualTo(expectedQuantity);
    }

}