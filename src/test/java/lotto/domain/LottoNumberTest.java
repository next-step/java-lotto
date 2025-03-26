package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumberTest {
    @DisplayName("로또 넘버가 1 ~ 45 사이가 아닐 시 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void invalidNumberTest(int argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(argument))
                .withMessage("LottoNumber is between 1 and 45");
    }

    @Test
    void stringCreateTest() {
        assertThat(new LottoNumber("3")).isEqualTo(new LottoNumber(3));
    }

}
