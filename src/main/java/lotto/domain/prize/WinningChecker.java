package lotto.domain.prize;

import java.util.List;

public class WinningChecker {
    public int checkWinNumber(List<Integer> lottoNumber, List<Integer> winningNumbers) {
        int winCount = 0;
        for (int winNumber : winningNumbers) {
            winCount = getWinCount(lottoNumber, winCount, winNumber);
        }
        return winCount;
    }

    private int getWinCount(List<Integer> lottoNumber, int winCount, int winNumber) {
        if (lottoNumber.contains(winNumber)) {
            winCount++;
        }
        return winCount;
    }
}