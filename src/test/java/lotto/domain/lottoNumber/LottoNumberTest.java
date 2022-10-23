package lotto.domain.lottoNumber;

import lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.get(1);

        assertThat(lottoNumber).isEqualTo(LottoNumber.get(1));
    }

    @Test
    void valid() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> LottoNumber.get(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumber.get(46)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumber.get(-1)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void lotto번호_캐싱() {
        LottoNumber lottoNumber = LottoNumber.get(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.get(1));
    }
}
