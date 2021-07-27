package lotto.domain;

import lotto.exception.IllegalLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호는 1보다 크거나 같고 45보다 작거나 같아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46", "1000"})
    void lotto_number_validation(String num) {
        assertThatThrownBy(() -> LottoNumber.of(num))
                .isInstanceOf(IllegalLottoNumberException.class);
    }
}
