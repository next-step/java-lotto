package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.domain.wrapper.Numbers;
import lotto.domain.rankcount.RankCountGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProfitCalculatorTest {

    @DisplayName("등수 별 당첨 개수를 인자로 받아 총 수익률을 계산한다. 단, 수익률은 소수점 셋째자리에서 반올림한다.")
    @Test
    void calculateProfitRate() {
        // given
        long purchase = 134000;

        Lottos lottos = new Lottos(
            List.of(
                new Numbers(List.of(1, 5, 12, 25, 35, 43)),
                new Numbers(List.of(1, 5, 24, 27, 29, 43))
            ));
        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));
        RankCountGroup rankCountGroup = lottos.groupByRankCount(winningNumbers);

        ProfitCalculator profitCalculator = new ProfitCalculator();

        // when
        double profitRate = profitCalculator.calculateProfitRate(purchase, rankCountGroup);

        // then
        assertThat(profitRate).isEqualTo(0.41);
    }
}
