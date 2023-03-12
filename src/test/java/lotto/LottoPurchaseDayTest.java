package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseDayTest {

    @DisplayName("정상 시나리오 체크")
    @Test
    void scenario() {
        LottoPurchaseDay lottoPurchaseDay = new LottoPurchaseDay();
        lottoPurchaseDay.scenario(14000, "19,10,7,17,3,25,43", 7);
    }
}
