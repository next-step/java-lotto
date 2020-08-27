package cc.oakk.lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationAdaptersTest {
    @Test
    public void throwIfNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> ValidationAdapters.throwIfNull(null));
    }
}
