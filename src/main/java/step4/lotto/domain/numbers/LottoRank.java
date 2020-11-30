package step4.lotto.domain.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class LottoRank {
    private static final int MAX_LOTTO_MATCH_COUNT = 6;
    private static final int MIN_LOTTO_MATCH_COUNT = 3;
    private static final int HIGH_RANK_DIVISION = 5;

    private LottoTicket winningNumbers;
    private int bonusNumber = 0;

    LottoRank(int bonusNumber, LottoTicket winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public int getRank(SortedSet<Integer> paramSet) {
        LottoRankEnum lottoRankEnum = null;

        int lottoMatchCount = (int) winningNumbers.getLottoTicket().stream()
                        .filter(oc -> paramSet.contains(oc))
                        .count();

        if (lottoMatchCount == MAX_LOTTO_MATCH_COUNT) {
            return 1;
        }

        if (lottoMatchCount < MIN_LOTTO_MATCH_COUNT) {
            return 0;
        }

        if (lottoMatchCount >= HIGH_RANK_DIVISION) {
            lottoMatchCount = checkBounusNumber(lottoMatchCount, paramSet);
        }
        lottoRankEnum = LottoRankEnum.findByRank(lottoMatchCount);

        return lottoRankEnum.getLottoRank();
    }

    private int checkBounusNumber(int lottoMatchCount, SortedSet<Integer> paramSet) {
        int returnValue = lottoMatchCount;

        if (paramSet.contains(bonusNumber)) {
            returnValue++;
        }

        return returnValue;
    }

}
