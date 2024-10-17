package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = getLottoNumber(5);
        assertThat(lottoNumber.getValue()).isEqualTo(5);
    }

    @Test
    void create_valueValidation_range() {
        assertThatThrownBy(()->getLottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void create_valueValidation_minus() {
        assertThatThrownBy(()->getLottoNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    private LottoNumber getLottoNumber(int num) {
        return new LottoNumber(num);
    }

}
