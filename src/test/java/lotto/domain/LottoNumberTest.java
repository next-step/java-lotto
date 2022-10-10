package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }
}
