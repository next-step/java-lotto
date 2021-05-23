package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.WinningType;

import static org.assertj.core.api.Assertions.*;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //이익일 때 profit은 1보다 크다.
        WinningType[] plusWinningTypes = {WinningType.FIRST, WinningType.SECOND, WinningType.SEVENTH};
        assertThat(profitCalculator.calculate(3000, plusWinningTypes) > 1).isTrue();

        //손해일 때 profit은 1보다 작다.
        WinningType[] MinusWinningTypes = {WinningType.FIFTH, WinningType.SIXTH, WinningType.SEVENTH};
        assertThat(profitCalculator.calculate(3000, MinusWinningTypes) < 1).isTrue();
    }
}
