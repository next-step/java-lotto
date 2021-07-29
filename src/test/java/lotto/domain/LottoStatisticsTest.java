package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {

    LottoNumbers winTicket;
    LottoNumber bonusNumber;
    Lottos buyTicket;
    LottoStatistics statistics = new LottoStatistics();

    @BeforeEach
    void setup() {
        winTicket = LottoNumbers.of("1,2,3,4,5,6");
        bonusNumber = LottoNumber.of("12");
        buyTicket = new Lottos(Arrays.asList(
                LottoNumbers.of("1,2,3,9,10,11"),
                LottoNumbers.of("1,2,3,4,5,20"),
                LottoNumbers.of("1,2,3,4,5,6"),
                LottoNumbers.of("1,2,3,4,5,12"),
                LottoNumbers.of("1,2,11,12,13,14"),
                LottoNumbers.of("1,2,3,12,13,14")
        ));
        statistics.summary(buyTicket, LottoBonus.of(winTicket, bonusNumber));
    }

    @DisplayName("당점번호와 구매한 티켓 리스트를 받아서 통계를 기록한다.")
    @Test
    void statistics() {
        Map<LottoMatchType, Integer> statisticsMap = statistics.getStatisticsMap();

        assertThat(statisticsMap.get(LottoMatchType.FIRST)).isEqualTo(1);
        assertThat(statisticsMap.get(LottoMatchType.SECOND)).isEqualTo(1);
        assertThat(statisticsMap.get(LottoMatchType.THIRD)).isEqualTo(1);
        assertThat(statisticsMap.get(LottoMatchType.FIFTH)).isEqualTo(2);
        assertThat(statisticsMap.get(LottoMatchType.MISS)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculate_profitRate() {
        assertThat(statistics.profitRate(buyTicket)).isEqualTo(338585);
    }
}