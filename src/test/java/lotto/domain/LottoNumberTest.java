package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또_번호가_1에서_45사이_숫자_외의_값일_경우_예외가_발생한다(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(value));
    }

    @Test
    public void 값이같은_두객채는_같아야한다() {
        int value = 1;
        assertThat(LottoNumber.of(value) == LottoNumber.of(value)).isTrue();
    }
}
