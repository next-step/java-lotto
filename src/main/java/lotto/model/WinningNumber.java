package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private static final String SPLIT_TOKEN = ",";

    private List<LottoNumber> winningNumbers;

    public WinningNumber(String numbers) {
        this.winningNumbers = this.splitNumbers(numbers);
    }

    private List<LottoNumber> splitNumbers(String numbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String winningNumber : numbers.split(SPLIT_TOKEN)) {
            LottoNumber number = LottoNumberPicker.pickNumber(Integer.parseInt(winningNumber));
            LottoNumberUtil.containsNumber(winningNumbers, number);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public boolean containsNumber(LottoNumber number) {
        return this.winningNumbers.contains(number);
    }

    public List<LottoNumber> getWinningNumbers() {
        return this.winningNumbers;
    }

}
