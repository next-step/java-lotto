package lotto.domain.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void create_Test() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
        assertThat(lottoNumber == LottoNumber.of(1)).isTrue();
    }

    @Test
    void 범위_벗어난_로또숫자_Test() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
