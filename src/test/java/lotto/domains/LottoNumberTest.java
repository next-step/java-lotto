package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void 생성자_테스트() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isNotNull();
    }

    @Test
    void 로또번호_0이하_46이상_에러_테스트() {
        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_동일_인스턴스_반환_테스트() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
        assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
    }

    @Test
    void 로또번호_반환_테스트() {
        assertThat(LottoNumber.of(1).number()).isEqualTo(1);
    }
}
