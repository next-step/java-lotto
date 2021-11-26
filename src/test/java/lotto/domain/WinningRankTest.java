package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningRankTest {

    static Stream<Arguments> generateWinnerCountAndMoney() {
        return Stream.of(
            Arguments.of(WinnerLottoTicket.of("1, 2, 3, 4, 5, 6", 7), 5000),
            Arguments.of(new ArrayList<>(Arrays.asList(0l, 0l, 3l, 5l)), 4000)
        );
    }

    static Stream<Arguments> generateWinnerCountAndPrizeMoney() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1l, 2l, 3l, 3l, 4l)), 60_000),
            Arguments.of(new ArrayList<>(Arrays.asList(0l, 0l, 3l, 5l)), 1_505_000)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinnerCountAndMoney")
    @DisplayName("getMoney 값 일치 확인")
    void getMoney(List<Long> winnerCount, double money) {
        WinningRank winningRank = new WinningRank();
        winningRank.updateRank(winnerCount);
        assertThat(winningRank.getMoney()).isEqualTo(money);
    }

    @ParameterizedTest
    @MethodSource("generateWinnerCountAndPrizeMoney")
    @DisplayName("getMoney 값 일치 확인")
    void getPrizeMoney(List<Long> winnerCount, double prizeMoney) {
        WinningRank winningRank = new WinningRank();
        winningRank.updateRank(winnerCount);
        assertThat(winningRank.getPrizeMoney()).isEqualTo(prizeMoney);
    }
}
