package lotto.step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    @ParameterizedTest(name = "profitsTest")
    @MethodSource("arrayProvider")
    public void profitsTest(Money moneyInput, int fourthRank, int thirdRank, int secondRank, int firstRank) {
        WinningStatistics statistics = new WinningStatistics(moneyInput, fourthRank, thirdRank, secondRank, firstRank);
        assertThat(statistics.profits()).isEqualTo(53.33);
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of((Object)new Money(3000),2,3,0,0)
        );
    }
}
