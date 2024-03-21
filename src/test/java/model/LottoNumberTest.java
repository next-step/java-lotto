package model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, -3, 0, 46, 47})
    void 보너스_볼의_범위가_1에서_45를_벗어나면_예외가_발생한다(final int bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(bonusNumber));
    }
}
