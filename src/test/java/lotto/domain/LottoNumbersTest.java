package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 자동 번호 발급 기능")
    void randomLottoNumbers() {
        assertThatCode(LottoNumbers::randomLottoNumbers)
                .doesNotThrowAnyException();
    }
}
