package lotto;

import java.util.Set;

public class LottoWinningRank {
    public static String getWinningRank(Set<Integer> winningNumbers, Set<Integer> boughtLottoNumbers) {
        int matchCount = 0;

        for (Integer boughtLottoNumber : boughtLottoNumbers) {
            if (winningNumbers.contains(boughtLottoNumber)) {
                matchCount++;
            }
        }

        if (matchCount == 6) {
            return "6개 일치";
        } else if (matchCount == 5) {
            return "5개 일치";
        } else if (matchCount == 4) {
            return "4개 일치";
        } else if (matchCount == 3) {
            return "3개 일치";
        } else {
            return "꽝";
        }
    }
}
