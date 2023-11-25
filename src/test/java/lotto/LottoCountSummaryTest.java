package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCount;
import lotto.domain.LottoCountSummary;
import lotto.domain.ManualLottoCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountSummaryTest {
    @Test
    void of() {
        // given
        LottoCount totalLottoCount = LottoCount.from(10);
        ManualLottoCount manualLottoCount = ManualLottoCount.from(3);

        // when
        LottoCountSummary lottoCountSummary = LottoCountSummary.of(totalLottoCount, manualLottoCount);

        // then
        assertThat(lottoCountSummary.getAutoLottoCount()).isEqualTo(LottoCount.from(7));
        assertThat(lottoCountSummary.getManulLottoCount()).isEqualTo(ManualLottoCount.from(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void isLessThanAutoLottoCount(int input) {
        LottoCountSummary lottoCountSummary = LottoCountSummary.of(1, 4);
        assertThat(lottoCountSummary.isLessThanAutoLottoCount(input)).isFalse();
        assertThat(lottoCountSummary.isLessThanAutoLottoCount(3)).isTrue();
    }
}
