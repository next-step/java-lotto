package lotto.service;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoFee.validateManualGameCount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("전체 구매 게임 수 보다 수동게임 구매 숫자가 클경우 IllegalArgumentException")
    void validateManualGameCountTest() {
        int manualCount = 5;
        int totalCount = 4;
        assertThatThrownBy(() -> validateManualGameCount(manualCount, totalCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}