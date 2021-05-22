package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @DisplayName("로또 당첨 통계 확인")
    @Test
    void 로또_당첨_통계_확인() {
        //given
        Statistics statistics = new Statistics(1);
        Lotto lotto = new Lotto(() -> Arrays.asList("1", "2", "3", "4", "5", "6"));
        Place place = lotto.matchWinningNumber(Arrays.asList("1", "2", "3", "4", "5", "6"));
        //when
        statistics.addCountToPlace(place);
        //then
        assertThat(statistics.firstPlace()).isEqualTo(1);
    }

    @DisplayName("수익률 확인")
    @Test
    void 수익률_확인() {
        //given
        //1등 2000, 2등 150, 3등 50, 4등 5
        //1장에 10
        Statistics statistics = new Statistics(1, 2, 1, 4, 20);

        //when
        double benefitRate = statistics.calculateBenefitRate();

        //2000*1 + 150*2 + 50*1 + 5*4 = 2370
        //then
        assertThat(benefitRate).isEqualTo(2370d/200d);
    }

}
