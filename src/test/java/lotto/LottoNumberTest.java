package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100} )
    void 로또_번호가_1부터_45_사이의_숫자가_아닌_경우_예외를_발생시킨다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
