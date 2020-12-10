package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @MethodSource
    void profitRate(LottoWinning lottoWinning) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for ( int ix = 0 ; ix < 5 ; ix ++ ) {
            lottoStatistics.addCount(lottoWinning);
        }
        double rate = (double)lottoWinning.getWinningPrice() * 5 / 5000;
        rate = new BigDecimal(rate).setScale(2, RoundingMode.DOWN).doubleValue();
        System.out.println(rate);
        assertThat(lottoStatistics.profitRate()).isEqualTo(rate);
    }

    private static Stream<Arguments> profitRate() {
        return Stream.of(
                Arguments.of(LottoWinning.WIN_5TH),
                Arguments.of(LottoWinning.WIN_4TH),
                Arguments.of(LottoWinning.WIN_3RD),
                Arguments.of(LottoWinning.WIN_1ST)
        );
    }
}
