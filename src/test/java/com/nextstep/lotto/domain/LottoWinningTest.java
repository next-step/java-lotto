package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {

    @DisplayName("맞은 개수에 맞는 등수 나오는지 확인")
    @ParameterizedTest
    @MethodSource
    void winning(long matchedCount, boolean matchedBonus, LottoWinning expected) {
        LottoWinning winning = LottoWinning.select(matchedCount, matchedBonus);
        assertThat(winning).isEqualTo(expected);
    }

    private static Stream<Arguments> winning() {
        return Stream.of(
                Arguments.of(6, false, LottoWinning.WIN_1ST),
                Arguments.of(5, true, LottoWinning.WIN_2ND),
                Arguments.of(5, false, LottoWinning.WIN_3RD),
                Arguments.of(4, false, LottoWinning.WIN_4TH),
                Arguments.of(3, false, LottoWinning.WIN_5TH),
                Arguments.of(2, false, LottoWinning.RETIRE),
                Arguments.of(1, false, LottoWinning.RETIRE)
        );
    }
}
