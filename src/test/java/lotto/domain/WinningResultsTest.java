package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {

    @Test
    void 등수를_기반으로_기본_데이터를_만들_수_있다() {
        WinningResults actual = new WinningResults(List.of(LottoRank.SECOND, LottoRank.FIRST));
        Map<LottoRank, Integer> values = new TreeMap<>();
        values.put(LottoRank.NOT_MATCHED, 0);
        values.put(LottoRank.FOURTH, 0);
        values.put(LottoRank.THIRD, 0);
        values.put(LottoRank.SECOND, 1);
        values.put(LottoRank.FIRST, 1);
        WinningResults expected = new WinningResults(values);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 결과를_기반으로_수익률을_알_수_있다() {
        WinningResults winningResults = new WinningResults(List.of(LottoRank.FOURTH));

        RevenueRate actual = winningResults.revenue(new BuyingAmount(14000));
        RevenueRate expected = new RevenueRate(0.35);

        assertThat(actual).isEqualTo(expected);
    }

}
