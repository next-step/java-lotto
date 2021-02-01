package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ROICalculatorTest {

//    @Test
//    void getRevenue() {
//        ROICalculator.getRevenue()
//    }

    @Test
    void calculateReturnOnInvestment() {
        assertThat(ROICalculator.calculateReturnOnInvestment(5000, 14000)).isEqualTo(0.35);
    }
}