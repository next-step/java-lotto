package lottogame.model.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호가_1미만이거나_45를초과하면_예외처리를_할_수_있다(int num) {
        assertThatThrownBy(
                () -> new LottoNum(num)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}