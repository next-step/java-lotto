package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @DisplayName(value = "2등 당첨 확인하기")
    @Test
    void is_second_price() {
        assertThat(WinningResult.addNumberOfWinning(5, true)).isEqualTo(WinningResult.SECOND_PRICE);
    }
}
