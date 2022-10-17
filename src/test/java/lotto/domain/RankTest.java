package lotto.domain;

import lotto.domain.Money.ImmutableMoney;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    private static Stream<Arguments> provideForRank() {
        return Stream.of(
                Arguments.of(new LottoMatchCount(0), false, Rank.EIGHTH),
                Arguments.of(new LottoMatchCount(1), false, Rank.SEVENTH),
                Arguments.of(new LottoMatchCount(2), false, Rank.SIXTH),
                Arguments.of(new LottoMatchCount(3), false, Rank.FIFTH),
                Arguments.of(new LottoMatchCount(4), false, Rank.FOURTH),
                Arguments.of(new LottoMatchCount(5), false, Rank.THIRD),
                Arguments.of(new LottoMatchCount(5), true, Rank.SECOND),
                Arguments.of(new LottoMatchCount(6), false, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForRank")
    void rank(LottoMatchCount matchCount, boolean containBonusNumber, Rank rank) {
        assertThat(Rank.rankValue(matchCount, containBonusNumber)).isEqualTo(rank);
    }

    private static Stream<Arguments> provideLottoReward() {
        return Stream.of(
                Arguments.of(new ImmutableMoney(2_000_000_000), Rank.FIRST),
                Arguments.of(new ImmutableMoney(30_000_000), Rank.SECOND),
                Arguments.of(new ImmutableMoney(1_500_000), Rank.THIRD),
                Arguments.of(new ImmutableMoney(50_000), Rank.FOURTH),
                Arguments.of(new ImmutableMoney(5_000), Rank.FIFTH),
                Arguments.of(new ImmutableMoney(0), Rank.SIXTH),
                Arguments.of(new ImmutableMoney(0), Rank.SEVENTH),
                Arguments.of(new ImmutableMoney(0), Rank.EIGHTH)
        );
    }

    @ParameterizedTest(name = "등수에 따른 상금을 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void reward(ImmutableMoney reward, Rank rank) {
        assertThat(rank.reward()).isEqualTo(reward);
    }
}
