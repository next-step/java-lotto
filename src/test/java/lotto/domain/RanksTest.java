package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @DisplayName("해당 등수가 몇 개인지 확인")
    @ParameterizedTest
    @MethodSource(value = "provideRank")
    void countRankOf(Rank rank, int count) {
        Ranks ranks = new Ranks(Arrays.asList(
                Rank.FIRST, Rank.FIRST,
                Rank.SECOND,
                Rank.THIRD,
                Rank.FOURTH, Rank.FOURTH));

        assertThat(ranks.countRankOf(rank)).isEqualTo(count);
    }

    private static Stream<Arguments> provideRank() { // 해당 메소드는 맨 밑으로 내려주는게 가독성이 좋을까? 테스트 수가 적던 많던 연관된 테스트 옆에 있는게 좋을 것 같다는 생각.
        return Stream.of(
                Arguments.of(Rank.FIRST, 2),
                Arguments.of(Rank.SECOND, 1),
                Arguments.of(Rank.THIRD, 1),
                Arguments.of(Rank.FOURTH, 2)
        );
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateRateOfProfit() {
        Ranks ranks = new Ranks(Arrays.asList(
                Rank.FOURTH,
                Rank.ETC, Rank.ETC));

        assertThat(ranks.calculateRateOfProfit()).isEqualTo(1.66);
    }

}
