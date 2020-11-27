package step4.lotto.domain.numbers;

import java.util.SortedSet;

public class LottoRank {

    private static final int DEFAULT_LOTTO_RANK = 7; // 로또 등수구할때 기본으로 세팅되어있는 값
    private static final int MIN_LOTTO_WINNING_RANK = 6;
    private static final int HIGH_RANK_DIVISION = 5;
    private LottoTicket winningNumbers;
    private int bonusNumber = 0;

    LottoRank(int bonusNumber, LottoTicket winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public int getRank(SortedSet<Integer> paramSet) {
        int lottoMatchCount = 0;
        LottoRankEnum lottoRankEnum = null;

        for (Integer number : paramSet) {
            lottoMatchCount = checkSameValue(number, lottoMatchCount);
        }

        if (lottoMatchCount == 6) {
            return 1;
        }

        if (lottoMatchCount >= HIGH_RANK_DIVISION) {
            lottoMatchCount = checkBounusNumber(bonusNumber, lottoMatchCount, paramSet);
            lottoRankEnum = LottoRankEnum.findByRank(lottoMatchCount);
        }

        return lottoRankEnum.getLottoRank();
    }

    private int checkSameValue(int paramValue, int lottoMatchCount) {
        int returnValue = lottoMatchCount;

        if (winningNumbers.getLottoTicket().contains(paramValue)) {
            returnValue++;
        }

        return returnValue;
    }

    private int checkBounusNumber(int paramNumber, int lottoMatchCount, SortedSet<Integer> paramSet) {
        int returnValue = lottoMatchCount;

        if (paramSet.contains(paramNumber)) {
            returnValue++;
        }

        return returnValue;
    }

}
