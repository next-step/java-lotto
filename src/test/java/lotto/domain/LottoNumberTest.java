package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints={-1, 0, 46})
    void generateErrorTest(int input) {
        assertThatThrownBy(() ->new LottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateTest() {
        assertThat(LottoNumber.of("4")).isEqualTo(new LottoNumber(4));
        assertThat(LottoNumber.of("1")).isEqualTo(new LottoNumber(1));
        assertThat(LottoNumber.of("45")).isEqualTo(new LottoNumber(45));
    }
}
