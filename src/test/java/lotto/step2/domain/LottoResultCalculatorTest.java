package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {
    @Test
    @DisplayName("수익률 계산하기")
    void calculate_yield() {
        double yield = LottoResultCalculator.parseYield(List.of(LottoRank.FIFTH), new PaymentPriceTest().paymentPrice);
        assertThat(yield).isEqualTo(0.35);
    }
}
