package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또번호는_1이상_45이하여야합니다() {
        assertThatThrownBy(() -> {
            new LottoNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);


        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        assertThat(new LottoNumber(45)).isEqualTo(new LottoNumber(45));
    }
}
