package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void compare() {
        LottoNumber lottoNumber = LottoNumber.of(3);

        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    }
}
