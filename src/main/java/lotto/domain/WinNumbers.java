package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumbers {
    private final List<Integer> winNumbers;

    public WinNumbers(String[] winNumbers) {
        this.winNumbers = toWinNumbers(winNumbers);
    }

    public WinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    private List<Integer> toWinNumbers(String[] winNumber) {
        List<Integer> winNumberList = new ArrayList<>();
        for (String number : winNumber) {
            winNumberList.add(Integer.parseInt(number));
        }

        return winNumberList;
    }

    public HitCount hitNumberCount(Numbers numbers) {
        int hitCount = 0;
        for (int winNumber : this.winNumbers) {
            hitCount = hitCount + numbers.contains(winNumber);
        }

        return new HitCount(hitCount);
    }
}
