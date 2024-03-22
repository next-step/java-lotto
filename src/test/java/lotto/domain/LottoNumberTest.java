package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void lotto_number() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

}
