package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class WinningPriceTest {

    @Test
    @DisplayName("당첨금액 비교 테스트")
    public void getWinningPriceTest() {
        assertThat(WinningPrice.valueOf(6,false)).isEqualTo(2000000000);
        assertThat(WinningPrice.valueOf(5,true)).isEqualTo(30_000_000);
        assertThat(WinningPrice.valueOf(5,false)).isEqualTo(1500000);
        assertThat(WinningPrice.valueOf(4,false)).isEqualTo(50000);
        assertThat(WinningPrice.valueOf(3,false)).isEqualTo(5000);
        assertThat(WinningPrice.valueOf(2,false)).isEqualTo(0);
    }

    @Test
    @DisplayName("2등 3등 비교 테스트")
    public void matchBonusTest() {
        assertThat(WinningPrice.valueOf(5,false)).isEqualTo(WinningPrice.valueOf(5,true));
    }

}
