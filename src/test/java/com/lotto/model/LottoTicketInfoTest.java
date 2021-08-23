package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketInfoTest {
    @DisplayName("수동 구매 갯수가 실제 티켓 구매 갯수보다 많을 시 테스트")
    @Test
    public void exceedManualCountTest() {
        //given
        int money = 999;
        int manualCount = 1;
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTicketInfo(money, manualCount);
        });
    }
}
