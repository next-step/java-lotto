package lotto.domain;

import lotto.domain.Money.ImmutableMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoRewardTest {

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
        assertThat(LottoReward.reward(rank)).isEqualTo(reward);
    }
}
