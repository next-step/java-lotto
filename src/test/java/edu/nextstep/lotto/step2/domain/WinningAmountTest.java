package edu.nextstep.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningAmountTest {

    @DisplayName("로또 수익 계산 테스트")
    @Test
    void create() {
        LottoList lottoList = new LottoList(14000);
        WinningList winningList = new WinningList("1,2,3,4,5,6");

        assertThat(WinningAmount.FOURTH.getBenefit().apply(lottoList, winningList)).isGreaterThanOrEqualTo(0);
    }
}