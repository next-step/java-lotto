package step2.service;

import step2.functional.PrizeAmount;

import java.util.Map;

public enum LottoRank {

    REMAIN(-1, nWinner -> 0),
    FOURTH(3, nWinner -> nWinner * 5000),
    THIRD(4, nWinner -> nWinner * 50000),
    SECOND(5, nWinner -> nWinner * 1500000),
    FIRST(6, nWinner -> nWinner * 2000000000);

    private static final int LOTTO_PER_PRICE = 1000;

    private final int countOfMatch;

    private final PrizeAmount prizeAmount;

    LottoRank(int countOfMatch, PrizeAmount prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank getLottoNumber(Integer matchingCount) {
        if (FIRST.countOfMatch == matchingCount) {
            return FIRST;
        }
        if (SECOND.countOfMatch == matchingCount) {
            return SECOND;
        }
        if (THIRD.countOfMatch == matchingCount) {
            return THIRD;
        }
        if (FOURTH.countOfMatch == matchingCount) {
            return FOURTH;
        }
        return REMAIN;
    }

    public static double calculateRateOfReturn(int numOfLottoTicket, Map<LottoRank, Integer> winnerResults) {
        return (FOURTH.prizeAmount.getPrizeAmount(winnerResults.get(FOURTH))
                + THIRD.prizeAmount.getPrizeAmount(winnerResults.get(THIRD))
                + SECOND.prizeAmount.getPrizeAmount(winnerResults.get(SECOND))
                + FIRST.prizeAmount.getPrizeAmount(winnerResults.get(FIRST)))
                / (numOfLottoTicket * LOTTO_PER_PRICE);
    }

    public static boolean isRemain(LottoRank lottoNumber) {
        return lottoNumber == REMAIN;
    }
}
