package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints={0, 46})
    void test_invalid_number(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(value);
        });
    }

    @Test
    void test_compare_to() {
        assertThat(new LottoNumber(3).compareTo(new LottoNumber(4))).isEqualTo(-1);
        assertThat(new LottoNumber(3).compareTo(new LottoNumber(3))).isEqualTo(0);
        assertThat(new LottoNumber(3).compareTo(new LottoNumber(2))).isEqualTo(1);
    }
}
