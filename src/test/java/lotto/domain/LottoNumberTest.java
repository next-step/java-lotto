package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @Test
    @DisplayName("로또번호는 1부터 45사이의 숫자만 포함한다.")
    void shouldContainNumbersBetween1And45Only() {
        final LottoNumber lottoNumber1 = new LottoNumber(1);
        final LottoNumber lottoNumber45 = new LottoNumber(45);

        assertThat(lottoNumber1).isEqualTo(new LottoNumber(1));
        assertThat(lottoNumber45).isEqualTo(new LottoNumber(45));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}
