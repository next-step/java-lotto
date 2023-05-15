package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTest {

    @Test
    void 총_당첨_금액() {
        Map<Win, Integer> winTotal = new EnumMap<>(Win.class);
        winTotal.put(Win.WIN_3, 3);
        winTotal.put(Win.WIN_4, 4);
        winTotal.put(Win.WIN_5, 0);
        winTotal.put(Win.WIN_6, 1);
        assertThat(Win.totalMoney(winTotal)).isEqualTo(2000215000);
    }

    @Test
    void 수익률_계산() {
        int income = 5000;
        int outcome = 14000;
        assertThat(Win.calculateProfitRate(income, outcome)).isEqualTo("0.35");
    }

}
