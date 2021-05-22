package study.lotto;

import java.util.*;

public class LottoPaper {
    private MarkedLottoNumbers markedLottoNumbers;
    private int matchCount;

    public LottoPaper() {
        this.markedLottoNumbers = new MarkedLottoNumbers();
        this.matchCount = 0;
    }

    public LottoPaper(List<Integer> numbers) {
        this.markedLottoNumbers = new MarkedLottoNumbers(numbers);
        this.matchCount = 0;
    }

    public MarkedLottoNumbers markedLottoNumbers() {
        return markedLottoNumbers;
    }

    public int checkPrize(WinningNumbers winningNumbers) {
        for (Integer number : markedLottoNumbers.value()) {
            matchNumber(winningNumbers, number);
        }
        return matchCount;
    }

    private void matchNumber(WinningNumbers winningNumbers, Integer number) {
        if (winningNumbers.value().contains(number)){
            matchCount++;
        }
    }
}
