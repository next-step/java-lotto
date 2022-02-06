package lotto.domain;

public class LottoResult {

    private final int normalSuccessCount;
    private final boolean bonusSuccessCount;

    public LottoResult(final int normalSuccessCount, final boolean bonusSuccessCount) {
        this.normalSuccessCount = normalSuccessCount;
        this.bonusSuccessCount = bonusSuccessCount;
    }

    public boolean getBonusSuccessCount() {
        return bonusSuccessCount;
    }

    public int getNormalSuccessCount() {
        return normalSuccessCount;
    }
}
