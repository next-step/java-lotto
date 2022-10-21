package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-10-21
 */
class LottoNumberTest {

    @Test
    void 생성() {
        LottoNumber lottoNumber = LottoNumber.of(7);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(7));
    }

    @Test
    void 생성_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }
}