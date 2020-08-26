package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class StatisticTest {

    @Test
    @DisplayName("등수 별 총 상금 계산 테스트")
    void calculateTotalWinnings() {
        Statistic statistic1 = new Statistic(Rank.FIRST, 1);
        then(statistic1.calculateTotalWinnings()).isEqualTo(2_000_000_000);

        Statistic statistic2 = new Statistic(Rank.SECOND, 1);
        then(statistic2.calculateTotalWinnings()).isEqualTo(1_500_000);

        Statistic statistic3 = new Statistic(Rank.THIRD, 1);
        then(statistic3.calculateTotalWinnings()).isEqualTo(50_000);

        Statistic statistic4 = new Statistic(Rank.FORTH, 1);
        then(statistic4.calculateTotalWinnings()).isEqualTo(5_000);
    }
}
