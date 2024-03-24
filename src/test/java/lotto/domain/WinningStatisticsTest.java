package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    @DisplayName("WinningStatistics는 생성자로 넘긴 랭크별 개수를 갖고 있다.")
    @ParameterizedTest
    @MethodSource("rankCounts")
    void rankCount(List<Rank> ranks, Rank searchTarget, Count expectResult) {
        assertThat(new WinningStatistics(ranks).rankCount(searchTarget))
                .isEqualTo(expectResult);
    }

    @DisplayName("rateOfReturn 함수는 구매 금액 대비 수익률을 반환한다.")
    @Test
    void rateOfReturn() {
        final WinningStatistics statistics = new WinningStatistics(List.of(Rank.FOURTH));

        assertThat(statistics.rateOfReturn(new Cash(10000)))
                .isEqualTo(0.5d);
    }

    static Stream<Arguments> rankCounts() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST, Rank.FIRST), Rank.FIRST, new Count(2)),
                Arguments.of(List.of(Rank.FIRST, Rank.SECOND), Rank.FIRST, new Count(1)),
                Arguments.of(List.of(Rank.SECOND, Rank.SECOND), Rank.FIRST, new Count(0))
        );
    }

}
