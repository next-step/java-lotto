package step2.service;

import step2.functional.PrizeAmount;

import java.util.Map;

public enum LottoRank {

    REMAIN(-1, nWinner -> 0),
    FOURTH(3, nWinner -> nWinner * 5000),
    THIRD(4, nWinner -> nWinner * 50000),
    SECOND(5, nWinner -> nWinner * 1500000),
    FIRST(6, nWinner -> nWinner * 2000000000);

    private final int countOfMatch;

    private final PrizeAmount prizeAmount;

    LottoRank(int countOfMatch, PrizeAmount prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank getLottoNumber(Integer matchingCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.countOfMatch == matchingCount) {
                return lottoRank;
            }
        }
        return REMAIN;
    }

    public static double calculateRateOfReturn(int numOfLottoTicket, Map<LottoRank, Integer> winnerResults) {
        int sumOfAllRanks = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sumOfAllRanks += lottoRank.prizeAmount.getPrizeAmount(winnerResults.get(lottoRank));
        }
        return sumOfAllRanks / (numOfLottoTicket * Lotto.PRICE_PER_LOTTO);
    }

    public static boolean isRemain(LottoRank lottoNumber) {
        return lottoNumber == REMAIN;
    }
}
