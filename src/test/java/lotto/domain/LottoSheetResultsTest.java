package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSheetResultsTest {
    @Test
    void create_로또_여러_장의_당첨_결과를_생성한다() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoSheet lottoSheet1 = new LottoSheet(new LottoNumbers(1, 2, 3, 7, 8, 9));
        LottoSheet lottoSheet2 = new LottoSheet(new LottoNumbers(1, 2, 7, 8, 9, 10));

        Map<LottoNumberMatchCount, LottoSheetMatchCount> results = LottoSheetResults.create(winningLottoNumbers, Arrays.asList(lottoSheet1, lottoSheet2)).getValue();

        assertThat(results.get(new LottoNumberMatchCount(3))).isEqualTo(new LottoSheetMatchCount(1));
        assertThat(results.get(new LottoNumberMatchCount(2))).isEqualTo(new LottoSheetMatchCount(1));
    }

    @Test
    void sumCashPrizes_로또_상금_합계를_반환한다() {
        LottoSheetResults lottoSheetResults = new LottoSheetResults(new HashMap<>() {{
            put(new LottoNumberMatchCount(3), new LottoSheetMatchCount(4));
            put(new LottoNumberMatchCount(4), new LottoSheetMatchCount(3));
            put(new LottoNumberMatchCount(5), new LottoSheetMatchCount(2));
            put(new LottoNumberMatchCount(6), new LottoSheetMatchCount(1));
        }});

        assertThat(lottoSheetResults.sumCashPrizes()).isEqualTo(2_003_170_000);
    }
}
