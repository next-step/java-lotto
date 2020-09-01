package com.lotto.dto;

import com.lotto.domain.LotteryNumber;
import com.lotto.domain.WinningLottery;

import java.util.Set;

public class WinningLotteryDTO {
    Set<LotteryNumber> winningLotteryNumbers;
    LotteryNumber bonusLotteryNumber;

    public WinningLotteryDTO(Set<LotteryNumber> winningLotteryNumbers, LotteryNumber bonusLotteryNumber) {
        this.winningLotteryNumbers = winningLotteryNumbers;
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    public WinningLottery of() {
        return new WinningLottery(winningLotteryNumbers, bonusLotteryNumber);
    }
}
