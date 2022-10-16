package lotto.domain;

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
                Arguments.of(2_000_000_000, 1, 6),
                Arguments.of(30_000_000, 2, 5),
                Arguments.of(1_500_000, 3, 5),
                Arguments.of(50_000, 4, 4),
                Arguments.of(5_000, 5, 3),
                Arguments.of(0, 6, 2),
                Arguments.of(0, 7, 1),
                Arguments.of(0, 8, 0)
        );
    }

    @ParameterizedTest(name = "등수에 따른 상금을 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void reward(int reward, int rank, int count) {
        assertThat(LottoReward.reward(rank)).isEqualTo(reward);
    }

    @ParameterizedTest(name = "등수에 따른 맞힌 개수를 반환한다.")
    @MethodSource(value = "provideLottoReward")
    void count(int reward, int rank, int count) {
        assertThat(LottoReward.count(rank)).isEqualTo(count);
    }
}
