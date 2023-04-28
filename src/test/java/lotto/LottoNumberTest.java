package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @Test
    public void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    public void equal() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.isEqual(1)).isTrue();
    }
}
