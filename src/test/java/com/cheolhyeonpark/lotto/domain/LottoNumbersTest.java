package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumbersTest {

    NumbersGenerator numbersGenerator = new NumbersGenerator();

    @Test
    public void countSameNumbersAsWinningNumber() {
        LottoNumbers lottoNumbers = numbersGenerator.getAutoLottoNumbers();
        WinningNumbers winningNumber = numbersGenerator.getWinningNumbers("1, 2, 3, 4, 5, 6");
        BonusNumber bonusNumber = numbersGenerator.getBonusNumber(7);

        Rank rank = lottoNumbers.getRank(winningNumber, bonusNumber);

        assertThat(rank).isNotNull();
    }
}