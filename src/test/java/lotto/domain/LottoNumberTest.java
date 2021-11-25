package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {

    @DisplayName("가능한 로또 번호")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int okNumber) {
        assertDoesNotThrow(() -> new LottoNumber(okNumber));
    }

    @DisplayName("불가능한 로또 번호")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_fail(int wrongNumber) {
        assertThatThrownBy(() -> new LottoNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 로또번호는 없습니다.");
    }

    @Test
    void equals() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

}
