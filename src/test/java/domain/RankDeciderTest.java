package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

class RankDeciderTest {
    @ParameterizedTest()
    @MethodSource("provideLottoAndExpectedRank")
    @DisplayName("로또와 당첨번호를 비교해 Rank를 결정한다")
    void 랭크_결정(Lotto lotto, WinningNumber winningNumber, Rank expectedRank) {
        Assertions.assertThat(RankDecider.decide(lotto, winningNumber))
                .isEqualTo(expectedRank);
    }

    private static List<org.junit.jupiter.params.provider.Arguments> provideLottoAndExpectedRank() {
        return List.of(
                org.junit.jupiter.params.provider.Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumber("1,2,3,4,5,6", "7"),
                        Rank.FIRST
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                        new WinningNumber("1,2,3,4,5,6", "7"),
                        Rank.SECOND
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                        new WinningNumber("1,2,3,4,5,6", "7"),
                        Rank.THIRD
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                        new WinningNumber("1,2,3,4,5,6", "7"),
                        Rank.FOURTH
                )
        );
    }
}