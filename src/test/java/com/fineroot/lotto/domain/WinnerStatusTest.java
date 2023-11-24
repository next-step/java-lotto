package com.fineroot.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.domain.LottoBundle;
import com.fineroot.lotto.domain.WinnerStatus;
import com.fineroot.lotto.domain.WinningRank;
import com.fineroot.lotto.dto.Money;
import com.fineroot.lotto.dto.WinningNumber;
import com.fineroot.lotto.dto.WinningNumberSet;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerStatusTest {

    @Test
    @DisplayName("create 생성")
    void create() {
        WinnerStatus winnerStatus = WinnerStatus.create();
        assertThat(winnerStatus).isInstanceOf(WinnerStatus.class);
    }

    @Test
    @DisplayName("from 생성")
    void from() {
        WinnerStatus winnerStatus = WinnerStatus.from(
                new EnumMap<>(Map.of(
                        WinningRank.FIRST_PRIZE, 1,
                        WinningRank.SECOND_PRIZE, 1,
                        WinningRank.THIRD_PRIZE, 1,
                        WinningRank.FORTH_PRIZE, 1)));
        assertThat(winnerStatus).isInstanceOf(WinnerStatus.class);
    }

    @Test
    @DisplayName("당첨 카운트 올리기")
    void increaseWinningCount() {
        WinnerStatus winnerStatus = WinnerStatus.create();
        winnerStatus.increaseWinningCount(WinningRank.FIRST_PRIZE);
        assertThat(winnerStatus.matchCount(WinningRank.FIRST_PRIZE)).isOne();
    }

    @Test
    @DisplayName("총 수익률")
    void totalEarningRate() {
        LottoBundle lottoBundle = LottoBundle.fromList(
                List.of("1,2,3,4,5,6",
                        "7,8,9,10,11,12",
                        "13,14,15,16,17,18",
                        "19,20,21,22,23,24",
                        "25,26,27,28,29,30"));
        WinningNumberSet winningNumber = WinningNumberSet.of(WinningNumber.from("1,2,3,7,8,9"), LottoNumber.from(10));
        WinnerStatus winnerStatus = lottoBundle.matchWinner(winningNumber);
        double earningRate = winnerStatus.totalEarningRate(Money.from(5000));
        assertThat(earningRate).isEqualTo(2.0d);
    }
}