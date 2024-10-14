package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("유효한 로또 번호가 생성된다.")
    void create(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertEquals(number, lottoNumber.getNumber());

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("유효하지 않는 로또 번호면 예외가 발생한다.")
    void throwExceptionForInvalidNumber(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(number);
        });
    }

}
