package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1이상 45이하이다.")
    void test1() {
        int outRangeNumber = 46;
        assertThatThrownBy(() -> LottoNumber.of(outRangeNumber))
                .hasMessageContaining("1~45 사이");
    }
}