package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class YieldTest {
    private static final int LOTTO_PRICE = 1000;

    @Test
    @DisplayName("수익률 > 1 케이스 (2개 구매 3등 2회)")
    public void testYield() {
        // when
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        List<Integer> winningNumbers = List.of(1, 2, 3, 14, 15, 16);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = 10;

        // given
        LottoResult result = lottos.rankCounts(winningLotto, bonusNumber, LOTTO_PRICE);
        int totalPrize = result.totalPrize();
        int totalInvestment = result.totalInvestment();
        Yield lottoYield = Yield.of(totalPrize, totalInvestment);

        // then
        double expectedYield = 5;
        assertThat(lottoYield.valueOf()).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("수익률 < 1 케이스 (2개 구매 등수 0)")
    public void testNoYield() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(11, 12, 13, 14, 15, 16);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers2);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        List<Integer> winningNumbers = List.of(21, 22, 23, 24, 25, 26);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = 10;

        // given
        LottoResult result = lottos.rankCounts(winningLotto, bonusNumber, LOTTO_PRICE);
        int totalPrize = result.totalPrize();
        int totalInvestment = result.totalInvestment();
        Yield lottoYield = Yield.of(totalPrize, totalInvestment);

        // then
        double expectedYield = 0;
        assertThat(lottoYield.valueOf()).isEqualTo(expectedYield);
    }
}
