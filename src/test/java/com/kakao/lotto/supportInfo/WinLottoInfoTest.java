package com.kakao.lotto.supportInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoInfoTest {

    @Test
    @DisplayName("입력으로 온 정답 로또 숫자 리스트를 반환한다.")
    void getWinLottoNumbers() {
        WinLottoInfo winLottoInfo = new WinLottoInfo("1,2,3,4,5,6");
        assertThat(winLottoInfo.getWinLottoNumbers()).containsExactly(1,2,3,4,5,6);
    }
}
