package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBuyDayTest {
    @DisplayName("정상 시나리오 체크")
    @Test
    void scenario() {
        LottoBuyDay lbd = new LottoBuyDay();
        lbd.scenario(14000, "19,10,7,17,3,25,43", 7);
    }
}
