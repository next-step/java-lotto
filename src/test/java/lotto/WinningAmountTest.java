package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningAmountTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0,0",
            "5,5000",
            "4,50000",
            "3,1500000",
            "1,2000000000",
    })
    @DisplayName("[WinningAmount] 등수 별 당첨 금액 테스트")
    public void amountTest(int winningLevel, int expectedWinningAmount) {
        assertThat(WinningAmount.of(WinningLevel.of(winningLevel)))
                .isEqualTo(WinningAmount.of(expectedWinningAmount));
    }
}
