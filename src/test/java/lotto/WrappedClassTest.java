package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoCount;
import lotto.domain.Price;
import lotto.exception.InputValueException;
import lotto.exception.LottoNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrappedClassTest {

    @Test
    void 보너스볼은_음수일_수_없다() {
        Assertions.assertThatThrownBy(() -> BonusBall.of("-1")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 보너스볼은_1이상_45이하() {
        Assertions.assertThatThrownBy(() -> BonusBall.of("0")).isInstanceOf(LottoNumberException.class);
        Assertions.assertThatThrownBy(() -> BonusBall.of("46")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 로또_개수는_음수일_수_없다() {
        Assertions.assertThatThrownBy(() -> LottoCount.of("-1")).isInstanceOf(LottoNumberException.class);
    }

    @Test
    void 가격은_음수일_수_없다() {
        Assertions.assertThatThrownBy(() -> Price.of("-1000")).isInstanceOf(InputValueException.class);
    }
}
