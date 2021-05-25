package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.common.WinningType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfit() {
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //이익일 때 profit은 1보다 크다.
        List<WinningType> plusWinningTypes = Arrays.asList(WinningType.FIFTH, WinningType.FORTH, WinningType.SEVENTH);
        assertThat(profitCalculator.calculate(3000, plusWinningTypes) >= 1).isTrue();

        //손해일 때 profit은 1보다 작다.
        List<WinningType> MinusWinningTypes = Arrays.asList(WinningType.FIFTH, WinningType.SEVENTH, WinningType.SEVENTH);
        assertThat(profitCalculator.calculate(10000, MinusWinningTypes) < 1).isTrue();
    }

    @Test
    @DisplayName("수익률 계산 소수점 테스트")
    void calculateProfit_shouldFloor() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        //소수점 둘째자리까지 표기되며 이후는 버림
        List<WinningType> plusWinningTypes = Arrays.asList(WinningType.FORTH, WinningType.FORTH, WinningType.SEVENTH);
        assertThat(profitCalculator.calculate(3000, plusWinningTypes)).isEqualTo(3.33);

        List<WinningType> MinusWinningTypes = Arrays.asList(WinningType.FIFTH, WinningType.SIXTH, WinningType.SEVENTH);
        assertThat(profitCalculator.calculate(3000, MinusWinningTypes)).isEqualTo(0.00);
    }
}
