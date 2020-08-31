package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void constructor_ShouldThrow_OnInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(Integer.MIN_VALUE));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(Integer.MAX_VALUE));
    }

    @Test
    public void compareTo() {
        LottoNumber number = new LottoNumber(15);
        assertThat(number.compareTo(new LottoNumber(5))).isGreaterThan(0);
        assertThat(number.compareTo(new LottoNumber(15))).isEqualTo(0);
        assertThat(number.compareTo(new LottoNumber(25))).isLessThan(0);
    }
}
