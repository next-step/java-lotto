package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTest {
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();

    }

    @Test
    void valideLottoNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.valideLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void valideLottoNumberOk() {
        Lotto lotto = new Lotto();
        boolean result = lotto.valideLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result).isTrue();
    }
}