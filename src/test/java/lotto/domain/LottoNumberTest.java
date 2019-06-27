package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber("1");
        assertThat(new LottoNumber(1)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위를_벗어나는_값(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(value);
        });
    }
}
