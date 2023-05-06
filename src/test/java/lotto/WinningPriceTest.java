package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPriceTest {

    @Test
    @DisplayName("equalCount 값이 6과 동일한 데이터를 반환한다.")
    void WiningPrice_6(){
        WinningPrice winningPrice = WinningPrice.of(6);
        assertThat(winningPrice).isEqualTo(WinningPrice.FIRST);
    }

    @Test
    @DisplayName("equalCount 값이 5와 동일한 데이터를 반환한다.")
    void WiningPrice_5(){
        WinningPrice winningPrice = WinningPrice.of(5);
        assertThat(winningPrice).isEqualTo(WinningPrice.SECOND);
    }

    @Test
    @DisplayName("equalCount 값이 4와 동일한 데이터를 반환한다.")
    void WiningPrice_4(){
        WinningPrice winningPrice = WinningPrice.of(4);
        assertThat(winningPrice).isEqualTo(WinningPrice.THIRD);
    }

    @Test
    @DisplayName("equalCount 값이 3과 동일한 데이터를 반환한다.")
    void WiningPrice_3(){
        WinningPrice winningPrice = WinningPrice.of(3);
        assertThat(winningPrice).isEqualTo(WinningPrice.FOUR);
    }

}
