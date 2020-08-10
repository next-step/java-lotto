package lotto;

import common.StringResources;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @Test
    public void inputFailTest() {

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoInput(0))
                .withMessage(StringResources.ERR_MUST_BUY);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoInput(13500))
                .withMessage(StringResources.ERR_WRONG_UNIT);
    }

    @Test
    public void inputSuccessTest() {

        int money = 10000;
        LottoInput input = new LottoInput(money);
        assertThat(input.getAmountMoney()).isEqualTo(money);
    }
}
