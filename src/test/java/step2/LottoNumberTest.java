package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void number() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
        assertThat(lottoNumber).isNotEqualTo(new LottoNumber(5));
    }

    @Test
    void illegalArgumentException_InputNumberIsLessThan1_or_BiggerThan45() {
        assertThatThrownBy(() -> new LottoNumber(-1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
