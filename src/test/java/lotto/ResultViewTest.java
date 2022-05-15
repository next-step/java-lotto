package lotto;

import lotto.view.ResultView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @Test
    void evaluateRateShouldReturnLostOrEarnedProperly() {
        assertThat(ResultView.evaluateRate(0.9)).isEqualTo("📉Lost..");
        assertThat(ResultView.evaluateRate(1.1)).isEqualTo("📈Earned!");
    }
}
