package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleStatusTest {
    @Test
    @DisplayName("LottoBundleStatus 생성 확인")
    void create() {
        LottoBundleStatus lottoBundleStatus = LottoBundleStatus.from(
                List.of("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"));
        assertThat(lottoBundleStatus).isInstanceOf(LottoBundleStatus.class);
    }
}
