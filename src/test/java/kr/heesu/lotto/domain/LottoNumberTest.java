package kr.heesu.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void equals_test() {
        LottoNumber num1 = LottoNumber.of(5);
        LottoNumber num2 = LottoNumber.of(5);

        assertThat(num1.equals(num2)).isTrue();
        assertThat(num1.hashCode()).isEqualTo(num2.hashCode());
    }

    @Test
    void validation_test() {
        assertThatThrownBy(() -> LottoNumber.of(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.of(100)).isInstanceOf(IllegalArgumentException.class);
    }
}