package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinResultTest {
    @Test
    @DisplayName("3000원으로 3등하나 당첨시 수익률 1.66")
    void yield_test() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 4, 6, 9, 10)),
                new Lotto(Arrays.asList(7, 11, 14, 15, 35, 38)),
                new Lotto(Arrays.asList(3, 4, 9, 11, 24, 43))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        WinResult result = new WinResult(lottos, winNumbers, 3000);
        assertThat(result.getYield()).isEqualTo("1.66");
    }
}