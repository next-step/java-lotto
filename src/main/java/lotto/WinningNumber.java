package lotto;

import java.util.Set;
import java.util.TreeSet;

public class WinningNumber {
    private static final int MINIMUM_VALUE = 6;
    private Set<Integer> winnings;

    public WinningNumber(String data) {
        winnings = new TreeSet<>();
        toNumbersSet(data);
    }

    public Set<Integer> getWinningNumbers() {
        return winnings;
    }

    private void toNumbersSet(String data) {
        String[] datas = splitData(data);
        if (checkMinimum(datas))
            throw new IllegalArgumentException(MINIMUM_VALUE + "자리를 입력 하셔야 합니다.");

        for (String number : datas) {
            winnings.add(Integer.parseInt(number));
        }
    }

    private boolean checkMinimum(String[] datas) {
        return MINIMUM_VALUE != datas.length;
    }

    private String[] splitData(String data) {
        return data.split(", ");
    }
}
