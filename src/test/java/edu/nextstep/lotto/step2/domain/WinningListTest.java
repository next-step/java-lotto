package edu.nextstep.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningListTest {

    @DisplayName("당첨 번호 생성 테스트")
    @Test
    void create() {
        WinningList winningList = new WinningList("1,2,3,4,5,6");
        assertThat(winningList.getWinningNumberList().size()).isEqualTo(6);
    }
}