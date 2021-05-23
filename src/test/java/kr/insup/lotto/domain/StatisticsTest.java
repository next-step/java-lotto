package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @DisplayName("로또 당첨 통계 확인(1등)")
    @Test
    void 로또_당첨_통계_확인_1등() {
        //given
        Statistics statistics = new Statistics(1);
        Lotto lotto = new Lotto(() -> Arrays.asList("1", "3", "2", "4", "5", "6"));
        Place place = lotto.matchWinningNumber(new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6")));

        //when
        statistics.addCountToPlace(place);

        //then
        assertThat(statistics.firstPlace()).isEqualTo(1);
    }

    @DisplayName("로또 당첨 통계 확인(2등)")
    @Test
    void 로또_당첨_통계_확인_2등() {
        //given
        Statistics statistics = new Statistics(1);
        Lotto lotto = new Lotto(() -> Arrays.asList("4", "3", "2", "1", "5", "10"));
        Place place = lotto.matchWinningNumber(new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6")));

        //when
        statistics.addCountToPlace(place);

        //then
        assertThat(statistics.secondPlace()).isEqualTo(1);
    }

    @DisplayName("로또 당첨 통계 확인(3등)")
    @Test
    void 로또_당첨_통계_확인_3등() {
        //given
        Statistics statistics = new Statistics(1);
        Lotto lotto = new Lotto(() -> Arrays.asList("4", "3", "2", "1", "11", "10"));
        Place place = lotto.matchWinningNumber(new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6")));
        //when
        statistics.addCountToPlace(place);
        //then
        assertThat(statistics.thirdPlace()).isEqualTo(1);
    }

    @DisplayName("로또 당첨 통계 확인(4등)")
    @Test
    void 로또_당첨_통계_확인_4등() {
        //given
        Statistics statistics = new Statistics(1);
        Lotto lotto = new Lotto(() -> Arrays.asList("4", "3", "2", "12", "11", "10"));
        Place place = lotto.matchWinningNumber(new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6")));
        //when
        statistics.addCountToPlace(place);
        //then
        assertThat(statistics.fourthPlace()).isEqualTo(1);
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
