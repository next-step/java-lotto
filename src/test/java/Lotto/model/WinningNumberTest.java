package Lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumberTest {
    @Test
    void shouldNotAllowWinningNumber_WhenBonusNumberIsIncludedInWinningNumbers(){
        assertThatIllegalArgumentException()
                .isThrownBy(()->new WinningNumber(List.of(1,2,3,4,5,6), 6))
                .withMessage("bonusNumber is already included in winningNumbers.");
    }
}
