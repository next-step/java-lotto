package cc.oakk.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void constructor_ShouldThrow_OnBelowZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, -1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, Integer.MIN_VALUE));
    }
}
