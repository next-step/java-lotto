package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void create(int number) {
        // given
        LottoNumber self = LottoNumber.of(number);

        // when
        LottoNumber other = LottoNumber.of(number);

        // then
        assertThat(self).isEqualTo(other);
        assertThat(self == other).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid_create(int number) {
        // given
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
