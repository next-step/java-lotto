package step2.domain;

public enum LottoTier {

    FIRST(6, 2000000000),
    SECOND(5, 150000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private int matchedNumberCount;
    private int prize;

    LottoTier(int matchedNumberCount, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    public int calculatePrize(int count) {
        return count * prize;
    }

    public static LottoTier getTier(int matchedNumberCount) {
        for (LottoTier lottoTier : LottoTier.values()) {
            return getIfSameMatchedNumberCount(lottoTier, matchedNumberCount);
        }
        return LottoTier.NONE;
    }

    private static LottoTier getIfSameMatchedNumberCount(LottoTier lottoTier, int matchedNumberCount) {
        if(lottoTier.getMatchedNumberCount() == matchedNumberCount) {
            return lottoTier;
        }
        return LottoTier.NONE;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getPrize() {
        return prize;
    }
}
