package lotto.domain.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    void validateLottoNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}