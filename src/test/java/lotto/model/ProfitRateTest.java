package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    void 로또_수익률_객체_생성_및_내부값_정상() {
        // given
        ProfitRate profitRate = new ProfitRate(10000, 1000);

        // when
        double rate = profitRate.getProfitRate();

        // then
        assertThat(rate).isCloseTo(10.0,
                Percentage.withPercentage(99.9));
    }

    @Test
    void 로또_수익률_총상금_음수일시_예외발생() {
        // given, when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ProfitRate(-1L, 1000));
        assertThat(exception).hasMessage("총 상금은 " + 0L + " 이상입니다.");
    }

    @Test
    void 로또_수익률_지불한돈_1000이하_일시_예외발생() {
        // given, when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ProfitRate(0, -1));
        assertThat(exception).hasMessage("지불한 돈은 " + 1000.0 + " 이상입니다.");
    }
}
