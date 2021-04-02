package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumbers {
    private final Numbers winNumbers;
    private final Number bonusNumber;

    public WinNumbers(String[] winNumbers, int bonusNumber) {
        this.winNumbers = toWinNumbers(winNumbers);
        this.bonusNumber = new Number(bonusNumber);
    }

    public WinNumbers(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = new Numbers(winNumbers);
        this.bonusNumber = new Number(bonusNumber);
    }

    private Numbers toWinNumbers(String[] winNumber) {
        List<Integer> winNumberList = new ArrayList<>();
        for (String number : winNumber) {
            validateNumberFormat(number);
            winNumberList.add(Integer.parseInt(number));
        }

        return new Numbers(winNumberList);
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해 주세요.");
        }
    }

    public HitCount hitNumberCount(Numbers numbers) {
        return new HitCount(winNumbers.sumContainsCount(numbers), numbers.contains(bonusNumber));
    }
}
