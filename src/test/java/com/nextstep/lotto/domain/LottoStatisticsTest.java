package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStatisticsTest {
    @DisplayName("당첨 결과가 null이나 empty일 때 체크")
    @ParameterizedTest
    @MethodSource
    void profitRateEmpty(List<LottoRank> list) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoStatistics(list));
    }

    private static Stream<Arguments> profitRateEmpty() {
        return Stream.of(
                Arguments.of(new ArrayList<>()),
                Arguments.of((Object)null)
        );
    }

    @DisplayName("당첨 복권 계수")
    @ParameterizedTest
    @MethodSource
    void countWinning(LottoRank lottoRank, int count) {
        List<LottoRank> list = new ArrayList<>();
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            list.add(lottoRank);
        }
        LottoStatistics lottoStatistics = new LottoStatistics(list);
        assertThat(lottoStatistics.getCount(lottoRank)).isEqualTo(count);
    }

    private static Stream<Arguments> countWinning() {
        return Stream.of(
                Arguments.of(LottoRank.WIN_1ST, 2),
                Arguments.of(LottoRank.WIN_3RD, 2),
                Arguments.of(LottoRank.WIN_4TH, 2),
                Arguments.of(LottoRank.WIN_5TH, 2)
        );
    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @MethodSource
    void profitRate(LottoRank lottoRank) {
        List<LottoRank> list = new ArrayList<>();
        for ( int ix = 0 ; ix < 5 ; ix ++ ) {
            list.add(lottoRank);
        }
        LottoStatistics lottoStatistics = new LottoStatistics(list);
        double rate = (double) lottoRank.getWinningPrice() * 5 / 5000;
        rate = new BigDecimal(rate).setScale(2, RoundingMode.DOWN).doubleValue();
        assertThat(lottoStatistics.profitRate()).isEqualTo(rate);
    }

    private static Stream<Arguments> profitRate() {
        return Stream.of(
                Arguments.of(LottoRank.WIN_5TH),
                Arguments.of(LottoRank.WIN_4TH),
                Arguments.of(LottoRank.WIN_3RD),
                Arguments.of(LottoRank.WIN_1ST)
        );
    }
}
