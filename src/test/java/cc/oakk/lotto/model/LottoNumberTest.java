package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void constructor_ShouldThrow_OnInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(Integer.MIN_VALUE));

        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(Integer.MAX_VALUE));
    }

    @Test
    public void compareTo() {
        LottoNumber number = LottoNumber.of(15);
        assertThat(number.compareTo(LottoNumber.of(5))).isGreaterThan(0);
        assertThat(number.compareTo(LottoNumber.of(15))).isEqualTo(0);
        assertThat(number.compareTo(LottoNumber.of(25))).isLessThan(0);
    }
}
