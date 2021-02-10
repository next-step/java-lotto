package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ROICalculatorTest {

    @Test
    void calculateReturnOnInvestment() {
        Money revenue = Money.of(5000);
        Money investMoney = Money.of(14000);
        assertThat(ROICalculator.calculateReturnOnInvestment(revenue, investMoney)).isEqualTo(0.35);
    }
}