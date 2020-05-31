package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumbersTest {

    @Test
    public void countSameNumbersAsWinningNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        WinningNumbers winningNumber = new WinningNumbers("1, 2, 3, 4, 5, 6");
        BonusNumber bonusNumber = new BonusNumber(7);

        Rank rank = lottoNumbers.getRank(winningNumber, bonusNumber);

        assertThat(rank).isNotNull();
    }
}