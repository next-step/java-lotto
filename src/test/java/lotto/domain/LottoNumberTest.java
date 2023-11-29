package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @Test
    void test_숫자비교() {
        LottoNumber x = LottoNumber.Of(1);
        LottoNumber y = LottoNumber.Of(2);
        assertThat(x.compareTo(y) < 0).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MAX_NUMBER + 1, LottoNumber.MIN_NUMBER - 1})
    void exceptionTest_범위를_넘는_값(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.Of(input));
    }
}