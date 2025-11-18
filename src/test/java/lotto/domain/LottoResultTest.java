package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 수익률_100퍼센트_미만() {
        double result = LottoResult.profitPercent(14000, 5000);
        Assertions.assertThat(result).isEqualTo(0.35);
    }

    @Test
    void 수익률_100퍼센트_이상() {
        double result = LottoResult.profitPercent(26000, 1500000);
        Assertions.assertThat(result).isEqualTo(57.69);
    }

}
