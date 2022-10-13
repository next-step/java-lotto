package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "45:45"}, delimiter = ':')
    @DisplayName("로또 번호를 생성할 수 있다.")
    void createNumber(int value, int expected) {
        assertThat(LottoNumber.from(value)).isEqualTo(LottoNumber.from(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("번호는 1 ~ 45 만 가능하다.")
    void wrongNumber(int value) {
        assertThatThrownBy(() -> LottoNumber.from(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
