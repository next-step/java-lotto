package lotto;

import lotto.domain.CashPayments;
import lotto.domain.SelfInputCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelfInputCountTest {
    @Test
    @DisplayName("가지고 있는 수동 구매 갯수를 살 수 있는 금액인지 학인한다.")
    void test() {
        //Given
        SelfInputCount selfInputCount = new SelfInputCount(1);
        //When
        selfInputCount.canBuy(new CashPayments(1000));
        //Then
    }
}
