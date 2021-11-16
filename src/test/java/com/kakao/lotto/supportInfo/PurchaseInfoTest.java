package com.kakao.lotto.supportInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseInfoTest {

    @Test
    @DisplayName("티켓 한장의 가격은 1000원이다.")
    void getTicketNumber() {
        assertThat(new PurchaseInfo(20000).getTicketNumber()).isEqualTo(20);
    }

    @Test
    @DisplayName("가능한 돈만큼 로또 티켓을 산다.")
    void getTicketNumberChange() {
        assertThat(new PurchaseInfo(1500).getTicketNumber()).isEqualTo(1);
    }
}
