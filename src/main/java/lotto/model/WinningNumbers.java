package lotto.model;


import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String numbers, int bonusNumber) {
        winningNumber = new WinningNumber(numbers);

        LottoNumber bonus = LottoNumberPicker.pickNumber(bonusNumber);
        LottoNumberUtil.containsNumber(winningNumber.getWinningNumbers(), bonus);
        this.bonusNumber = bonus;
    }



    public int checkOverlapNumber(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumber::containsNumber)
                .count();
    }

    public boolean checkBonusNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
