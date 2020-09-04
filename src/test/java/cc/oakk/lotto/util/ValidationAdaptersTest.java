package cc.oakk.lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.function.Supplier;

public class ValidationAdaptersTest {
    @Test
    public void throwIfNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> ValidationAdapters.throwIfNull(null));
    }

    @Test
    public void throwIfNegative() {
        assertThatIllegalArgumentException().isThrownBy(() -> ValidationAdapters.throwIfNegative(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> ValidationAdapters.throwIfNegative(Integer.MIN_VALUE));

        assertThatIllegalArgumentException().isThrownBy(() -> ValidationAdapters.throwIfNegative(-1, "ERROR!"))
                .withMessage("ERROR!");

        assertThat(ValidationAdapters.throwIfNegative(0)).isEqualTo(0);
        assertThat(ValidationAdapters.throwIfNegative(Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void tryUntilSuccess() {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            int i = 0;
            @Override
            public Integer get() {
                i += 1;
                if (i < 5) {
                    throw new RuntimeException();
                }
                return i;
            }
        };
        int result = ValidationAdapters.tryUntilSuccess(supplier, t -> {});
        assertThat(result).isEqualTo(5);
    }
}
