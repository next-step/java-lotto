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
                Arguments.of(new ImmutableMoney(2_000_000_000), 1, 6),
                Arguments.of(new ImmutableMoney(30_000_000), 2, 5),
                Arguments.of(new ImmutableMoney(1_500_000), 3, 5),
                Arguments.of(new ImmutableMoney(50_000), 4, 4),
                Arguments.of(new ImmutableMoney(5_000), 5, 3),
                Arguments.of(new ImmutableMoney(0), 6, 2),
                Arguments.of(new ImmutableMoney(0), 7, 1),
                Arguments.of(new ImmutableMoney(0), 8, 0)
        );
    }

    @ParameterizedTest(name = "등수에 따른 상금을 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void reward(ImmutableMoney reward, int rank, int count) {
        assertThat(LottoReward.reward(rank)).isEqualTo(reward);
    }

    @ParameterizedTest(name = "등수에 따른 맞힌 개수를 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void count(ImmutableMoney reward, int rank, int count) {
        assertThat(LottoReward.count(rank)).isEqualTo(count);
    }
}
