package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호의 숫자는 6개여야 한다.")
    @Test
    void lotto_number_validation() {
        assertThatThrownBy(() -> LottoNumbers.of(("1,2,3,4,5")))
                .isInstanceOf(IllegalLottoNumberCountException.class);
    }
}