package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {Lotto.MIN - 1, Lotto.MAX + 1})
    void 로또번호는_1부터_45사이의_숫자이다(int outOfBounds) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(outOfBounds));
    }
}
