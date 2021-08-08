package lotto.model;


import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private WinningNumber winningNumber;
    private int bonusNumber;

    public WinningNumbers(String numbers, int bonusNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : numbers.split(",")) {
            int number = Integer.parseInt(winningNumber);
            LottoNumberUtil.validNumber(number);
            winningNumbers.add(number);
        }
        LottoNumberUtil.validNumber(bonusNumber);
        winningNumber = new WinningNumber(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int checkOverlapNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winningNumber.containsNumber(number))
                .count();
    }

    public boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
