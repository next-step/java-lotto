package lotto.domain;

import lotto.domain.lotto.wrapper.Lottos;
import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class ProfitCalculatorTest {

    @DisplayName("등수 별 당첨 개수를 인자로 받아 총 수익률을 계산한다. 단, 수익률은 소수점 셋째자리에서 반올림한다.")
    @Test
    void calculateProfitRate() {
        // given
        long purchase = 134000;

        Lottos lottos = new Lottos(
            List.of(
                new LottoNumbers(Set.of(1, 5, 12, 25, 35, 43)),
                new LottoNumbers(Set.of(1, 5, 24, 27, 29, 43))
            ));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 5, 12, 21, 32, 43), 45);
        RankCountGroup rankCountGroup = lottos.groupByRank(winningNumber);

        ProfitCalculator profitCalculator = new ProfitCalculator();

        // when
        double profitRate = profitCalculator.calculateProfitRate(purchase, rankCountGroup);

        // then
        assertThat(profitRate).isEqualTo(0.41);
    }
}
