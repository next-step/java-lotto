package lotto.domain;

import common.StringResources;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningAmountTest {

    @Test
    public void wrongRange() {

        assertThatIllegalArgumentException().isThrownBy(() ->
                WinningAmount.of(2)
        ).withMessage(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);

        assertThatIllegalArgumentException().isThrownBy(() ->
                WinningAmount.of(7)
        ).withMessage(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
    }
}
