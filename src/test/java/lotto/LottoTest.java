package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void invalidNumbersWhenInputNullAndEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList()));
    }
}
