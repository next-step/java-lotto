package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void matchTest() {
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(5));
        assertThat(lottoNumber.compareTo(new LottoNumber(4))).isEqualTo(1);
        assertThat(lottoNumber.compareTo(new LottoNumber(5))).isEqualTo(0);
        assertThat(lottoNumber.compareTo(new LottoNumber(6))).isEqualTo(-1);
    }
}
