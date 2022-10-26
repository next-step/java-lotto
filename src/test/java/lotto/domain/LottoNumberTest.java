package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 숫자 생성")
    @Test
    void create() {
        int number = 45;
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(45));
    }

    @ParameterizedTest(name = "로또 숫자 생성 실패 - input: {0}")
    @ValueSource(ints = {-100, -1, 0, 46, 100})
    void invalid(final int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class)
                                                         .hasMessageContaining("로또 숫자 범위");
    }
}
