package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;

import java.util.List;

public class LottoWinningNumbers {

    private List<Integer> numbers;

    private LottoWinningNumbers() {

    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static LottoWinningNumbers manipulateInputWinningLottoNumbers(String input) {
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
        lottoWinningNumbers.numbers = LottoViewHelper.manipulateInputLottoNumbers(input);
        return lottoWinningNumbers;
    }
}
