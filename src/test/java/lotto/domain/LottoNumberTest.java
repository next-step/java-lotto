package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void create(int expected) {
        assertThat(new LottoNumber(expected)).isEqualTo(new LottoNumber(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void create_out_of_range(int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(expected));
    }
}
