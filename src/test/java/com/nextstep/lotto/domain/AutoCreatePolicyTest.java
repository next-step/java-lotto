package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoCreatePolicyTest {
    @DisplayName("자동으로 LottoTicket을 만들 수 있다.")
    @Test
    void createLottoTicketTest() {
        int expectedSize = 6;

        AutoCreatePolicy autoCreatePolicy = new AutoCreatePolicy();
        LottoTicket lottoTicket = autoCreatePolicy.create();

        assertThat(lottoTicket.getLottoNumbers()).hasSize(expectedSize);
    }
}
