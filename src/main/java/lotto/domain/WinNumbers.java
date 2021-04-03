package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumbers {
    private final Numbers winNumbers;
    private final Number bonusNumber;

    public WinNumbers(String[] winNumbers, int bonusNumber) {
        this.winNumbers = toWinNumbers(winNumbers);
        this.bonusNumber = Number.of(bonusNumber);
    }

    public WinNumbers(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = new Numbers(winNumbers);
        this.bonusNumber = Number.of(bonusNumber);
    }

    public WinNumbers(Numbers winNumbers, Number bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
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
        int sumHitCount = winNumbers.sumContainsCount(numbers);
        if (sumHitCount == Prize.SECOND.getHitCount().getHitCount()) {
            return new HitCount(sumHitCount, numbers.contains(bonusNumber));
        }
        return new HitCount(sumHitCount);
    }
}
