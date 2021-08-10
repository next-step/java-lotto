package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @DisplayName(value = "꽝 확인하기")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void is_no_price(final int number) {
        assertThat(WinningResult.addNumberOfWinning(number, true)).isEqualTo(WinningResult.NO_PRICE);
        assertThat(WinningResult.addNumberOfWinning(number, false)).isEqualTo(WinningResult.NO_PRICE);
    }

    @DisplayName(value = "5등 당첨 확인하기")
    @Test
    void is_fifth_price() {
        assertThat(WinningResult.addNumberOfWinning(3, true)).isEqualTo(WinningResult.FIFTH_PRICE);
        assertThat(WinningResult.addNumberOfWinning(3, false)).isEqualTo(WinningResult.FIFTH_PRICE);
    }

    @DisplayName(value = "4등 당첨 확인하기")
    @Test
    void is_fourth_price() {
        assertThat(WinningResult.addNumberOfWinning(4, true)).isEqualTo(WinningResult.FOURTH_PRICE);
        assertThat(WinningResult.addNumberOfWinning(4, false)).isEqualTo(WinningResult.FOURTH_PRICE);
    }

    @DisplayName(value = "3등 당첨 확인하기")
    @Test
    void is_third_price() {
        assertThat(WinningResult.addNumberOfWinning(5, false)).isEqualTo(WinningResult.THIRD_PRICE);
    }

    @DisplayName(value = "2등 당첨 확인하기")
    @Test
    void is_second_price() {
        assertThat(WinningResult.addNumberOfWinning(5, true)).isEqualTo(WinningResult.SECOND_PRICE);
    }

    @DisplayName(value = "1등 당첨 확인하기")
    @Test
    void is_first_price() {
        assertThat(WinningResult.addNumberOfWinning(6, true)).isEqualTo(WinningResult.FIRST_PRICE);
        assertThat(WinningResult.addNumberOfWinning(6, false)).isEqualTo(WinningResult.FIRST_PRICE);
    }
}
