package lotto;

import lotto.domain.CashPayments;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CashPaymentsTest {
    @Test
    @DisplayName("매개변수로 전달된 총 수익금으로 수익률을 구한다.")
    void test() {
        //Given
        CashPayments cashPayments = new CashPayments(5000);
        long totalPrizeMoney = 10000;
        //When
        double earningsRate = cashPayments.getEarningsRate(totalPrizeMoney);
        //Then
        Assertions.assertThat(earningsRate).isEqualTo(2.0);
    }

}
