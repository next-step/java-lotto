package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void create(int number) {
        // given
        LottoNumber self = new LottoNumber(number);

        // when
        LottoNumber other = new LottoNumber(number);

        // then
        assertThat(self).isEqualTo(other);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid_create(int number) {
        // given
        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
