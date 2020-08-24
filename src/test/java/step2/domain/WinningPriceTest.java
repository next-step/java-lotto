package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningPriceTest {

    @Test
    @DisplayName("당첨금액 비교 테스트")
    public void getWinningPriceTest() {
        assertThat(WinningPrice.valueOf(6)).isEqualTo(2000000000);
        assertThat(WinningPrice.valueOf(5)).isEqualTo(1500000);
        assertThat(WinningPrice.valueOf(4)).isEqualTo(50000);
        assertThat(WinningPrice.valueOf(3)).isEqualTo(5000);
        assertThat(WinningPrice.valueOf(2)).isEqualTo(0);
    }
}
