package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {

    @Test
    void 등수를_기반으로_기본_데이터를_만들_수_있다() {

        WinningResults winningResults = new WinningResults(List.of(LottoRank.THIRD, LottoRank.FIRST));

        Map<LottoRank, Integer> actual = winningResults.getAll();
        Map<LottoRank, Integer> expected = createExpected();

        assertThat(actual).isEqualTo(expected);
    }

    private static Map<LottoRank, Integer> createExpected() {
        Map<LottoRank, Integer> expected = new TreeMap<>();
        expected.put(LottoRank.NOT_MATCHED, 0);
        expected.put(LottoRank.FIFTH, 0);
        expected.put(LottoRank.FOURTH, 0);
        expected.put(LottoRank.THIRD, 1);
        expected.put(LottoRank.SECOND, 0);
        expected.put(LottoRank.FIRST, 1);
        return expected;
    }

    @Test
    void 결과를_기반으로_수익률을_알_수_있다() {
        WinningResults winningResults = new WinningResults(List.of(LottoRank.FIFTH));

        RevenueRate actual = winningResults.revenue(new BuyingAmount(14000));
        RevenueRate expected = new RevenueRate(0.35);

        assertThat(actual).isEqualTo(expected);
    }

}
