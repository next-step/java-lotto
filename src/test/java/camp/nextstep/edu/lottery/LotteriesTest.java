package camp.nextstep.edu.lottery;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteriesTest {

    @ParameterizedTest
    @CsvSource(value = { "999:0", "1000:1", "1999:1", "2000:2" }, delimiter = ':')
    @DisplayName("1000원당 1장의 로또를 생성한다")
    void generateLotteries(int money, int lotteryCount) {
        Lotteries lotteries = new Lotteries(money);
        assertThat(lotteries.count()).isEqualTo(lotteryCount);
    }

    @ParameterizedTest
    @MethodSource("generate1stPrizeCountTestSet")
    @DisplayName("1등에 당첨된 복권의 수를 센다")
    void count1stPrize(Lotteries lotteries, int expected) {
        // given
        Lottery winningLottery
            = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        // when
        int actual = lotteries.count1stPrize(winningLottery);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generate1stPrizeCountTestSet() {
        return Stream.of(
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33))
                    )
                ),
                0
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 5, 6))
                    )
                ),
                1
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 5, 6)),
                        new Lottery(List.of(6, 5, 4, 3, 2, 1))
                    )
                ),
                2
            )
        );
    }

    @ParameterizedTest
    @MethodSource("generate3rdPrizeCountTestSet")
    @DisplayName("3등에 당첨된 복권의 수를 센다")
    void count3rdPrize(Lotteries lotteries, int expected) {
        // given
        Lottery winningLottery
            = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        // when
        int actual = lotteries.count3rdPrize(winningLottery);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generate3rdPrizeCountTestSet() {
        return Stream.of(
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33))
                    )
                ),
                0
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 5, 45))
                    )
                ),
                1
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 5, 45)),
                        new Lottery(List.of(45, 5, 4, 3, 2, 1))
                    )
                ),
                2
            )
        );
    }

    @ParameterizedTest
    @MethodSource("generate4thPrizeCountTestSet")
    @DisplayName("4등에 당첨된 복권의 수를 센다")
    void count4thPrize(Lotteries lotteries, int expected) {
        // given
        Lottery winningLottery
            = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        // when
        int actual = lotteries.count4thPrize(winningLottery);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generate4thPrizeCountTestSet() {
        return Stream.of(
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33))
                    )
                ),
                0
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 44, 45))
                    )
                ),
                1
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 4, 44, 45)),
                        new Lottery(List.of(6, 5, 4, 3, 44, 45))
                    )
                ),
                2
            )
        );
    }

    @ParameterizedTest
    @MethodSource("generate5thPrizeCountTestSet")
    @DisplayName("5등에 당첨된 복권의 수를 센다")
    void count5thPrize(Lotteries lotteries, int expected) {
        // given
        Lottery winningLottery
            = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        // when
        int actual = lotteries.count5thPrize(winningLottery);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generate5thPrizeCountTestSet() {
        return Stream.of(
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33))
                    )
                ),
                0
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 43, 44, 45))
                    )
                ),
                1
            ),
            Arguments.of(
                new Lotteries(
                    List.of(
                        new Lottery(List.of(45, 43, 42, 41, 40, 39)),
                        new Lottery(List.of(38, 37, 36, 35, 34, 33)),
                        new Lottery(List.of(1, 2, 3, 43, 44, 45)),
                        new Lottery(List.of(6, 5, 4, 43, 44, 45))
                    )
                ),
                2
            )
        );
    }

    @Test
    void calcReturnRate() {
        // given
        Lotteries lotteries = new Lotteries(
            List.of(
                new Lottery(List.of(1, 2, 3, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45)),
                new Lottery(List.of(40, 41, 42, 43, 44, 45))
            )
        );
        Lottery winningLottery = new Lottery(List.of(1, 2, 3, 4, 5, 6));

        // when
        double returnRate = lotteries.calcReturnRate(winningLottery);
        assertThat(returnRate).isEqualTo(0.5);
    }
}
