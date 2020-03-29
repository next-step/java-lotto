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
            if(lottoTier.matchedNumberCount == matchedNumberCount) {
                return lottoTier;          //TODO: indent 2 이하 어떻게 풀면 좋을 지
            }
        }
        return LottoTier.NONE;
    }
}
