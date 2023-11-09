package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {

    @Test
    void 등수를_기반으로_기본_데이터를_만들_수_있다() {
        WinningResults winningResults = new WinningResults();

        int actual = winningResults.size();
        int expected = LottoRank.values().length;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 등수를_기반으로_기본_데이터를_만들_수_있다2() {
        WinningResults actual = new WinningResults();

        actual.report(new WinningLottoNumber(List.of(1, 2, 3, 4, 5, 6)),
                List.of(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(List.of(1, 2, 3, 4, 5, 9))));
        Map<LottoRank, Integer> values = new TreeMap<>();
        values.put(LottoRank.NOT_MATCHED, 0);
        values.put(LottoRank.FOURTH, 0);
        values.put(LottoRank.THIRD, 0);
        values.put(LottoRank.SECOND, 1);
        values.put(LottoRank.FIRST, 1);
        WinningResults expected = new WinningResults(values);

        assertThat(actual).isEqualTo(expected);
    }

}
