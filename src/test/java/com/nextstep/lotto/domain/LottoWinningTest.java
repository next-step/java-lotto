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
    void winning(long matchedCount, LottoWinning expected) {
        LottoWinning winning = LottoWinning.select(matchedCount);
        assertThat(winning).isEqualTo(expected);
    }

    private static Stream<Arguments> winning() {
        return Stream.of(
                Arguments.of(6, LottoWinning.WIN_1ST),
                Arguments.of(5, LottoWinning.WIN_3RD),
                Arguments.of(4, LottoWinning.WIN_4TH),
                Arguments.of(3, LottoWinning.WIN_5TH),
                Arguments.of(2, LottoWinning.RETIRE),
                Arguments.of(1, LottoWinning.RETIRE)
        );
    }
}
