package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN - 1, LottoNumber.MAX + 1})
    void 로또번호는_1부터_45사이의_숫자이다(int outOfBounds) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(outOfBounds));
    }

    @Test
    void 번호값이_같은_로또넘버는_같다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
