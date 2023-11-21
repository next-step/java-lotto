package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTestValidate {
    @Test
    @DisplayName("로또 번호는 1이상 45이하이다.")
    void test3() throws Exception {
        int outRangeNumber = 57;
        assertThatThrownBy(() -> new LottoNumberValidate(outRangeNumber))
                .hasMessageContaining("1~45 사이");
    }
}