package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCount;
import lotto.domain.LottoCountSummary;
import lotto.domain.ManualLottoCount;
import org.junit.jupiter.api.Test;

public class LottoCountSummaryTest {
    @Test
    void of() {
        // given
        LottoCount totalLottoCount = LottoCount.from(10);
        ManualLottoCount manualLottoCount = new ManualLottoCount(3, totalLottoCount);

        // when
        LottoCountSummary lottoCountSummary = LottoCountSummary.of(totalLottoCount, manualLottoCount);

        // then
        assertThat(lottoCountSummary.getAutoLottoCount()).isEqualTo(LottoCount.from(7));
        assertThat(lottoCountSummary.getManulLottoCount()).isEqualTo(ManualLottoCount.from(3));
    }
}
