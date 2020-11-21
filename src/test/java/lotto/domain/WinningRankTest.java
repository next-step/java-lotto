package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningRankTest {

    static Stream<Arguments> getWinningRank() {
        return Stream.of(
                arguments(new RankMatcher(6, false), WinningRank.FIRST),
                arguments(new RankMatcher(5, true), WinningRank.SECOND),
                arguments(new RankMatcher(5, false), WinningRank.THIRD),
                arguments(new RankMatcher(4, false), WinningRank.FOURTH),
                arguments(new RankMatcher(3, false), WinningRank.FIFTH),
                arguments(new RankMatcher(2, false), WinningRank.FAIL),
                arguments(new RankMatcher(1, false), WinningRank.FAIL),
                arguments(new RankMatcher(0, false), WinningRank.FAIL)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void getWinningRank(RankMatcher rankMatcher, WinningRank expectedWinningRank) {
        WinningRank winningRank = WinningRank.getWinningRank(rankMatcher);

        assertThat(winningRank).isEqualTo(expectedWinningRank);
    }
}
