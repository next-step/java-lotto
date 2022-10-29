package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManualCountTest {
    @Test
    @DisplayName("로또 수동 개수가 로또 구입개수보다 크게 되면 에러를 뱉는다")
    void validateTest_greaterThanLottoCount_ThenIllegalArgumentException() {
        LottoManualCount lottoManualCount = new LottoManualCount(10);
        LottoCount lottCount = new LottoCount(9);
        assertThatThrownBy(() -> lottoManualCount.validateCount(lottCount))
                .isInstanceOf(RuntimeException.class);
    }
}
