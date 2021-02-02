package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.util.ROICalculator;
import org.junit.jupiter.api.Test;

class ROICalculatorTest {

    @Test
    void calculateReturnOnInvestment() {
        assertThat(ROICalculator.calculateReturnOnInvestment(5000, 14000)).isEqualTo(0.35);
    }
}