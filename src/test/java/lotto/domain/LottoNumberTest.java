package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호가 잘 생성되는지")
    @Test
    void lottoNumberTest() {
        assertThat(new LottoNumber(1))
                .isEqualTo(new LottoNumber(1));
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 큰 경우 IllegalArgumentException을 잘 반환하는지")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void lottoNumberTest_withInvalidValue(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
