package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {
    @Test
    void LottoNumber_숫자가_아닌경우() {
        assertThatThrownBy(() -> new LottoNumber("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void LottoNumber_숫자범위를_넘어선경우(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
