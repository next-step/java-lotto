package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("로또 번호는 1~45이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateLottoNumberTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumber = new LottoNumber(number);
        });
    }
}
