package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("out of lotto range")
    @Test
    void checkIsValidTest() {
        int illegalNumber = 47;
        Assertions.assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(illegalNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}