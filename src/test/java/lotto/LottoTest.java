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
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    }

    @Test
    void valideLottoNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.valideLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void valideLottoNumberOk() {
        boolean result = lotto.valideLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result).isTrue();
    }

    @Test
    void howManySameLottoNumber6() {
        int result = lotto.howManySameLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void howManySameLottoNumber3() {
        int result = lotto.howManySameLottoNumber(Arrays.asList(1, 2, 3, 11, 22, 33));
        assertThat(result).isEqualTo(3);
    }
}