package domain;

import exception.InvalidRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("LottoNumber를 생성")
    @Test
    void of() {
        LottoNumber number = LottoNumber.of(1);

        assertThat(number.getValue()).isEqualTo(1);
    }

    @DisplayName("유효하지 않은 LottoNumber를 생성시에 exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void of_invalidNumbers(int number) {

        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(InvalidRangeNumberException.class);
    }
}
