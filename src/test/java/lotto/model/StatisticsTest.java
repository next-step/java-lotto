package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 수익률을_계산한다(){
        Statistics statistics = new Statistics(5,50000);
        double benefits = statistics.calculateBenefits();
        assertThat(benefits).isEqualTo(10.0);
    }
}