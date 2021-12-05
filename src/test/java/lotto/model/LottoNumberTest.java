package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @ParameterizedTest(name = "1이상 45이하의 숫자가 아니면 IllegalArgumentException을 throw한다")
    @ValueSource(ints = {0, 46})
    void testLottoNumberBounds(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}