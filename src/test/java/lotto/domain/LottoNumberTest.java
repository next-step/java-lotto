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
    public void createOutOfRange(int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void compareTo(int a) {
        final int b = 5;
        final int expected = Integer.compare(a, 5);

        final int result = new LottoNumber(a).compareTo(new LottoNumber(b));

        assertThat(result).isEqualTo(expected);
    }
}
