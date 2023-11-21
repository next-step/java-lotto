package com.fineroot.lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.dto.WinningNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    @Test
    @DisplayName("LottoBundle 생성")
    void create() {
        LottoBundle lottoBundle = LottoBundle.from(10);
        assertThat(lottoBundle).isInstanceOf(LottoBundle.class);
    }

    @Test
    @DisplayName("결과 출력 테스트")
    void lottoBundleStatus() {
        LottoBundle lottoBundle = LottoBundle.from(10);
        assertThat(lottoBundle.toLottoBundleStatus().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("당첨 확인")
    void matchWinner() {
        LottoBundle lottoBundle = LottoBundle.fromList(List.of("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"));
        WinnerStatus winnerStatus = lottoBundle.matchWinner(WinningNumber.from("1,2,3,8,9,10"));
        assertThat(winnerStatus.matchCount(WinningRank.FORTH_PRIZE)).isEqualTo(2);
    }
}
