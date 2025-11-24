package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);

        Assertions.assertThat(lottoNumber.value()).isEqualTo(1);
    }
}
