package lotto.domain;

import lotto.domain.money.ImmutableMoney;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    private static Stream<Arguments> provideForRank() {
        return Stream.of(
                Arguments.of(new LottoMatchCount(0), false, Rank.MISS),
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
                Arguments.of(new ImmutableMoney(0), Rank.MISS)
        );
    }

    @ParameterizedTest(name = "등수에 따른 상금을 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void reward(ImmutableMoney reward, Rank rank) {
        assertThat(rank.reward()).isEqualTo(reward);
    }

    @DisplayName("2등일 경우 True를 반환한다.")
    @Test
    void isBonus() {
        Assertions.assertAll(
                () -> assertThat(Rank.SECOND.isBonus()).isTrue(),
                () -> assertThat(Rank.FIRST.isBonus()).isFalse()
        );
    }
}
