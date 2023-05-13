package lotto.domain;

import lotto.enums.LottoPrize;
import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static lotto.domain.fixture.LottosFixture.로또_티켓;
import static lotto.domain.fixture.WinningLottoFixture.로또_1등;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 통계 테스트")
class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setup() {
        lottoStatistics = new LottoStatistics(로또_1등, 로또_티켓);
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void testCalculateYield() {
        // when
        final double v = lottoStatistics.calculateYield();
        // then
        assertEquals(10000, Math.floor(v));
    }

    @Test
    @DisplayName("당첨 수준과 일치하는 로또 티켓 수 테스트")
    void testCalculateYield2() {
        // When & Then
        assertThat(lottoStatistics.getMatchCountsMap()).hasSize(3);
    }

}