package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    @Test
    @DisplayName("전체 구매 게임 수 보다 수동게임 구매 숫자가 클경우 IllegalArgumentException")
    void validateManualGameCountTest() {
        int manualCount = 5;
        int totalCount = 4;
        assertThatThrownBy(() -> LottoService.validateManualGameCount(manualCount, totalCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}