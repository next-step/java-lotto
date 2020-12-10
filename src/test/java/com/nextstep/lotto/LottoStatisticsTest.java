package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @DisplayName("당첨 복권 계수")
    @ParameterizedTest
    @MethodSource
    void countWinning(LottoWinning lottoWinning, int count) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            lottoStatistics.addCount(lottoWinning);
        }

        assertThat(lottoStatistics.getCount(lottoWinning)).isEqualTo(count);
    }

    private static Stream<Arguments> countWinning() {
        return Stream.of(
                Arguments.of(LottoWinning.WIN_1ST, 2),
                Arguments.of(LottoWinning.WIN_3RD, 2),
                Arguments.of(LottoWinning.WIN_4TH, 2),
                Arguments.of(LottoWinning.WIN_5TH, 2)
        );
    }
}
