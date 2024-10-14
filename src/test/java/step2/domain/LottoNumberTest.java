package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void 로또번호가_유효한_값이면_정상적으로_생성된다(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또번호가_유효하지_않으면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1과 45 사이여야 합니다.");
    }
}
