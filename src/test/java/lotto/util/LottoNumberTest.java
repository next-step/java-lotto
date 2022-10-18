package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    @DisplayName("기준 번호 개수")
    void getLottoNumberList() {

        // expected
        assertThat(LottoNumber.getLottoNumberList()).hasSize(LottoNumber.LOTTO_NUMBER_SIZE);
    }
}
