package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberSelectorTest {

    @DisplayName("랜덥 한 6자리 수 추출 테스트")
    @Test
    void select_number_test() {
        assertThat(LottoNumberSelector.selectNumbers().size()).isEqualTo(6);
    }
}
