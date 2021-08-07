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

    @Test
    @DisplayName("getLottery 테스트")
    public void getLottery() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottery winningLottery = new Lottery(getLotteryNumbers(1, 6));
        int expectedMatchesCount = 6;

        // when
        Lottery lottery = LotteryFactory.getLottery(numbers);

        // then
        assertThat(lottery).isNotNull();
        assertThat(lottery.getMatchesCount(winningLottery)).isEqualTo(expectedMatchesCount);
    }

    @ParameterizedTest(name = "getLotteries 테스트 | {arguments}")
    @CsvSource(value = {"2500|2", "9900|9", "1000|1"}, delimiter = '|')
    public void getLotteries(int moneyNumber, int expectedSize) {
        // given
        Money money = new Money(moneyNumber);

        // when
        Lotteries lotteries = LotteryFactory.getLotteries(money);

        // then
        assertThat(lotteries).isNotNull();
        assertThat(lotteries.getLotteriesDto().size()).isEqualTo(expectedSize);
    }

    private List<LotteryNumber> getLotteryNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }
}