package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberRangeTest {
    @Test
    public void constructor_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumberRange(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void between_ShouldNotThrow_IllegalArgumentException() {
        assertThat(LottoNumberRange.between(100, -100)).isEqualTo(new LottoNumberRange(-100, 100));
    }

    @Test
    public void createRangeList() {
        assertThat(LottoNumberRange.between(0, 5).createRangeList()).containsExactly(0, 1, 2, 3, 4);
    }
}
