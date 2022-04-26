package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {

    @ParameterizedTest(name = "로또 번호는 1~45이다.")
    @ValueSource(ints = {0, 46})
    void validation(int number) {
        assertThatThrownBy(() -> LottoNo.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("내부적인 캐싱을 통해 동일성 보장")
    @Test
    void of() {
        assertThat(LottoNo.of(1)).isSameAs(LottoNo.of(1));
        assertThat(LottoNo.of(45)).isSameAs(LottoNo.of(45));
    }
}
