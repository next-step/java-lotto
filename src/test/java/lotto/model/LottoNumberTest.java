package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 생성자_테스트() {
        LottoNumber number = new LottoNumber(1);

        assertThat(number).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 생성자_예외() {
        assertThatThrownBy(() -> {
            LottoNumber number = new LottoNumber(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            LottoNumber number = new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
