package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {

    @ParameterizedTest(name = "로또 번호는 1~45이다.")
    @ValueSource(ints = {0, 46})
    void validation(int number) {
        assertThatThrownBy(() -> new LottoNo(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals() {
        assertThat(new LottoNo(1)).isEqualTo(new LottoNo(1));
        assertThat(new LottoNo(2)).isEqualTo(new LottoNo(2));
    }
}
