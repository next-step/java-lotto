package lotto;

import lotto.domain.CashPayments;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashPaymentsTest {
    private CashPayments cashPayments;
    
    @BeforeEach
    void setUp() {
        cashPayments = new CashPayments(5000);
    }
    
    @Test
    @DisplayName("매개변수로 전달된 총 수익금으로 수익률을 구한다.")
    void test() {
        //Given
        long totalPrizeMoney = 10000;
        //When
        double earningsRate = cashPayments.getEarningsRate(totalPrizeMoney);
        //Then
        Assertions.assertThat(earningsRate).isEqualTo(2.0);
    }
    
    @Test
    @DisplayName("매개변수로 전달된 기본금액으로 구매가능 횟수를 구한다.")
    void getBuyableCountTest() {
        //Given
        int defaultPrice = 1000;
        //When
        int buyableCount = cashPayments.getBuyableCount(defaultPrice);
        //Then
        Assertions.assertThat(buyableCount).isEqualTo(5);
    }
}
