package lotto.model;

import lotto.service.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallTest {

    @Test
    void shouldValidateLottoBall() {
        assertThatThrownBy(() -> LottoBall.noBonusBall(LottoNumberPicker.MAX_BOUND_NUM)).isInstanceOf(IllegalArgumentException.class);
    }
}
