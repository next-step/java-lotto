package step2.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningPriceTest {

    @Test
    public void getWinningPriceTest() {
        assertThat(WinningPrice.getPriceWithWinningNumbers(6)).isEqualTo(2000000000);
        assertThat(WinningPrice.getPriceWithWinningNumbers(5)).isEqualTo(1500000);
        assertThat(WinningPrice.getPriceWithWinningNumbers(4)).isEqualTo(50000);
        assertThat(WinningPrice.getPriceWithWinningNumbers(3)).isEqualTo(5000);
        assertThat(WinningPrice.getPriceWithWinningNumbers(2)).isEqualTo(0);
    }
}
