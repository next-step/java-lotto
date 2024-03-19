package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("숫자 1 ~ 45까지의 숫자만 가질 수 있다.")
    @Test
    void create() {
        Assertions.assertThat(new LottoNumber(45)).isEqualTo(new LottoNumber(45));
        Assertions.assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        Assertions.assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
