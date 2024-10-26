package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 생성() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        Assertions.assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
        Assertions.assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
    }

    @Test
    void 로또번호가_정해진_범위내의_숫자가_아니면_예외_발생() {
        // given
        int lottoNumber = 46;

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(lottoNumber))
                .withMessageMatching("로또번호는 \\d+~\\d+ 사이의 숫자만 가능합니다");
    }
}
