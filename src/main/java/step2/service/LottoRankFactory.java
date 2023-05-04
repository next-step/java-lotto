package step2.service;

public class LottoRankFactory {

    public static LottoRank getLottoRank(long countWinNumber, boolean containBonusNumber) {
        if (containBonusNumber && LottoRank.isSecondsCount(countWinNumber)) {
            return LottoRank.SECOND;
        }

        return LottoRank.getLottoNumber(countWinNumber);
    }
}
