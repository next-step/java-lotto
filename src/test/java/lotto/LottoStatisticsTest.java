package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {

    @Test
    void rateOfReturnTest() {
        BigDecimal investment = BigDecimal.valueOf(14000);
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        for (int i = 0 ; i < 14; i++) {
            lottos.add(new Lotto(List.of(11, 12, 13, 24, 25, 26)));
        }

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, List.of(1, 2, 3, 14, 15, 16), 10);
        BigDecimal result = lottoStatistics.rateOfReturn(investment);

        assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
    }

    @ParameterizedTest
    @MethodSource("getWinningSource")
    void ofMatchCountTest(int matchCount, boolean matchBonus, LottoStatistics.Winnings expected) {
        LottoStatistics.Winnings winnings = LottoStatistics.Winnings.fromMatchCount(matchCount, matchBonus);

        assertThat(winnings).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinningSource() {

        return Stream.of(
                Arguments.of(5, false, LottoStatistics.Winnings.THIRD),
                Arguments.of(5, true, LottoStatistics.Winnings.THIRD),
                Arguments.of(6, false, LottoStatistics.Winnings.FIRST),
                Arguments.of(6, true, LottoStatistics.Winnings.SECOND),
                Arguments.of(4, false, LottoStatistics.Winnings.FOURTH),
                Arguments.of(4, true, LottoStatistics.Winnings.FOURTH)
        );
        }

}