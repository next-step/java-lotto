package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LottoUtilTest {

    @Test
    @DisplayName("수익률 계산")
    void calculate_saveOfReturn() {
        assertThat(LottoUtil.calculateSaveOfReturn(14000, 5000)).isEqualTo(0.35, offset(0.01));
    }
}
