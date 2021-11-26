package com.kakao.lotto.supportInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseInfoTest {

    @Test
    @DisplayName("티켓 한장의 가격은 1000원이다.")
    void getTicketNumber() {
        assertThat(new PurchaseInfo(20000).getTotalTicketCount()).isEqualTo(20);
    }

    @Test
    @DisplayName("가능한 돈만큼 자동으로 로또 티켓을 산다.")
    void getTicketNumberChange() {
        assertThat(new PurchaseInfo(1500).getTotalTicketCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("수동으로 지정하여 로또 티켓을 구입할 수도 있다.")
    void getTicketWithPickedLotteries() {
        List<List<Integer>> pickedLotteries = Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new PurchaseInfo(1500, pickedLotteries).getTotalTicketCount()).isEqualTo(1);
    }
}
