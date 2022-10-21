package lotto.domain.rank;

import lotto.domain.LottoMatchCount;
import lotto.domain.money.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
                Arguments.of(new Money(2_000_000_000), Rank.FIRST),
                Arguments.of(new Money(30_000_000), Rank.SECOND),
                Arguments.of(new Money(1_500_000), Rank.THIRD),
                Arguments.of(new Money(50_000), Rank.FOURTH),
                Arguments.of(new Money(5_000), Rank.FIFTH),
                Arguments.of(new Money(0), Rank.MISS)
        );
    }

    @ParameterizedTest(name = "등수에 따른 상금을 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void reward(Money reward, Rank rank) {
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

    @DisplayName("보상을 제공하는 Rank의 리스트를 내림차순으로 반환한다.")
    @Test
    void rank_reward_descending_list() {
        List<Rank> ranks = Rank.rewardDescendingRankList();
        List<Rank> rankList = Arrays.stream(
                        Arrays.copyOfRange(Rank.values(), Rank.REWARD_END_RANK_INDEX, Rank.REWARD_START_RANK_INDEX)
                )
                .collect(Collectors.toList());
        Collections.reverse(rankList);

        assertThat(ranks).containsExactly(rankList.toArray(Rank[]::new));
    }
}
