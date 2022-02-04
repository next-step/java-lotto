package lotto.domain;

public class LottoResult {

    private final int bonusSuccessCount;
    private final int normalSuccessCount;

    public LottoResult(int bonusSuccessCount, int normalSuccessCount) {
        this.bonusSuccessCount = bonusSuccessCount;
        this.normalSuccessCount = normalSuccessCount;
    }

    public int getBonusSuccessCount() {
        return bonusSuccessCount;
    }

    public int getNormalSuccessCount() {
        return normalSuccessCount;
    }
}
