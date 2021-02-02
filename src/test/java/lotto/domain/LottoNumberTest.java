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

    @DisplayName("compare test")
    @Test
    void compareToTest() {
        LottoNumber smallNumber = new LottoNumber(1);
        LottoNumber sameWithSmallNumber = new LottoNumber(1);
        LottoNumber bigNumber = new LottoNumber(41);
        assertThat(smallNumber.compareTo(bigNumber)).isEqualTo(-1);
        assertThat(bigNumber.compareTo(smallNumber)).isEqualTo(1);
        assertThat(smallNumber.compareTo(sameWithSmallNumber)).isEqualTo(-1);
    }
}