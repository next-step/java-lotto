package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validLottoNumber(int initLottoNum) {
        Assertions.assertThatThrownBy(() -> {
            new LottoNumber(initLottoNum);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareTo() {
        Assertions.assertThat(new LottoNumber(1).compareTo(new LottoNumber(1)))
                .isEqualTo(0);
        Assertions.assertThat(new LottoNumber(1).compareTo(new LottoNumber(2)))
                .isEqualTo(-1);
        Assertions.assertThat(new LottoNumber(2).compareTo(new LottoNumber(1)))
                .isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, false"}, delimiter = ',')
    void testEquals(int argNumber, boolean argBoolean) {
        Assertions.assertThat(new LottoNumber(1).equals(new LottoNumber(argNumber)))
                .isEqualTo(argBoolean);
    }
}