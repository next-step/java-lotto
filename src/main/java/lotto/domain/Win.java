package lotto.domain;

import java.util.List;
import java.util.Set;

public class Win {

    public int countMatchingNumbers(Set<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int getPrizeMoney(int matchCount) {
        return WinningPrize.getPrizeMoney(matchCount);
    }

}
