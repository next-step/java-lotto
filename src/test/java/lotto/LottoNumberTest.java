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
            LottoNumber.of(value);
        });
    }

    @Test
    void test_compare_to() {
        assertThat(LottoNumber.of(3).compareTo(LottoNumber.of(4))).isEqualTo(-1);
        assertThat(LottoNumber.of(3).compareTo(LottoNumber.of(3))).isEqualTo(0);
        assertThat(LottoNumber.of(3).compareTo(LottoNumber.of(2))).isEqualTo(1);
    }
}
