package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.valueOf(1);

        assertThat(lottoNumber.value()).isEqualTo(1);
    }

    @Test
    void 로또의_범위는_1에서_45이다() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또 번호는 1부터 45입니다.");

    }

    @Test
    void 로또_번호_캐시한_결과() {
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
    }
}
