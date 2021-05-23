package com.lotto.domain;

import com.lotto.exception.IllegalInputException;
import com.lotto.exception.IllegalLottoCountException;

import java.util.HashSet;
import java.util.Set;

public class LottoWinningNumbers {
    private Set<LottoNumber> winningNumbers;

    public LottoWinningNumbers(Set<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static LottoWinningNumbers createLottoWinningNumbers(String winningNumbers)
            throws IllegalInputException, IllegalLottoCountException {
        Set<LottoNumber> set;
        try {
            set = addWinningNumber(winningNumbers);
        } catch (NumberFormatException exception) {
            throw new IllegalInputException();
        }
        if (isLottoCount(set)) {
            throw new IllegalLottoCountException();
        }

        return new LottoWinningNumbers(set);
    }

    private static boolean isLottoCount(Set<LottoNumber> set) {
        return set.size() != Lotto.LOTTO_COUNT;
    }

    private static Set<LottoNumber> addWinningNumber(String winningNumbers) throws NumberFormatException {
        String[] splitNumbers = winningNumbers.split(",");
        Set<LottoNumber> set = new HashSet<>();
        for(String sNumber : splitNumbers) {
            set.add(new LottoNumber(Integer.valueOf(sNumber.trim())));
        }
        return set;
    }

    public boolean contains(LottoNumber number) {
        return this.winningNumbers.contains(number);
    }
}
