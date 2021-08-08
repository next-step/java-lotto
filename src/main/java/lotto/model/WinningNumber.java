package lotto.model;


import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers = new ArrayList<>();

    public WinningNumber(String numbers) {
        for (String winningNumber : numbers.split(",")) {
            int number = Integer.parseInt(winningNumber);
            LottoNumberUtil.validNumber(number);
            winningNumbers.add(number);
        }
    }


    public int checkOverlapNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }


}
