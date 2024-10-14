package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
}
