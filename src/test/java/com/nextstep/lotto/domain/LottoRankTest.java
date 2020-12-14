package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("맞은 개수에 맞는 등수 나오는지 확인")
    @ParameterizedTest
    @MethodSource
    void winning(long matchedCount, boolean matchedBonus, LottoRank expected) {
        LottoRank winning = LottoRank.select(matchedCount, matchedBonus);
        assertThat(winning).isEqualTo(expected);
    }

    private static Stream<Arguments> winning() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.WIN_1ST),
                Arguments.of(5, true, LottoRank.WIN_2ND),
                Arguments.of(5, false, LottoRank.WIN_3RD),
                Arguments.of(4, false, LottoRank.WIN_4TH),
                Arguments.of(3, false, LottoRank.WIN_5TH),
                Arguments.of(2, false, LottoRank.RETIRE),
                Arguments.of(1, false, LottoRank.RETIRE)
        );
    }
}
