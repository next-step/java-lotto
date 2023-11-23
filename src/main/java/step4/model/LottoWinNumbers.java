package step4.model;

import step4.utils.NumberSplitUtils;

import java.util.List;

public class LottoWinNumbers {

    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> winNumbers;

    public LottoWinNumbers(String winNumber) {
        List<Integer> winNumbers = NumberSplitUtils.splitWinNumberString(winNumber);
        validate(winNumbers.size());
        this.winNumbers = winNumbers;
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    private void validate(int number) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자가 아닙니다.");
        }
    }
}
