package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRevenueCalculatorTest {

    @Test
    void calculatorTest() {
        int money = 14000;
        int winMoney = 5000;

        String result = LottoRevenueCalculator.revenueCalculate(money, winMoney);
        assertEquals(result, "0.36");
    }
}
