package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("기준 번호 개수")
    void getLottoNumberList() {

        // expected
        assertThat(LottoNumbers.getAutoNumberList()).hasSize(6);
    }
}
