package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.ProfitCalculator;
import step3.domain.WinningType;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    private ProfitCalculator profitCalculator = new ProfitCalculator();

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitRatioTest(){
        List<WinningType> winningTypes = new ArrayList<>();
        winningTypes.add(WinningType.FIFTH);
        double profitRatio = profitCalculator.calculateProfitRatio(winningTypes,5000);

        assertThat(profitRatio).isEqualTo(1);
    }

}
