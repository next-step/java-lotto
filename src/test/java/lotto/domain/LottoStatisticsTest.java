package lotto.domain;

import lotto.enums.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.domain.fixture.LottosFixture.로또_티켓;
import static lotto.domain.fixture.WinningLottoFixture.지난주_로또_당첨;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 통계 테스트")
class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setup() {
        lottoStatistics = new LottoStatistics(지난주_로또_당첨, 로또_티켓);
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void testCalculateYield() {
        // when
        final double v = lottoStatistics.calculateYield();
        // then
        assertEquals(499, Math.floor(v));
    }

    @Test
    @DisplayName("당첨 수준과 일치하는 로또 티켓 (묶음) 테스트 (로또 티켓에는 꽝 2개 2등 하나) ")
    void testPrizeMatchCount() {
        // When & Then
        final Map<LottoPrize, Integer> matchCountsMap = lottoStatistics.getMatchCountsMap();
        System.out.println("matchCountsMap = " + matchCountsMap);
        assertThat(lottoStatistics.getMatchCountsMap())
                .hasSize(2);
    }

}