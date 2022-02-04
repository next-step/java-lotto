package lotto.domain;

public class LottoResult {


    private final int normalSuccessCount;
    private final int bonusSuccessCount;

    public LottoResult(int normalSuccessCount, int bonusSuccessCount) {
        this.normalSuccessCount = normalSuccessCount;
        this.bonusSuccessCount = bonusSuccessCount;
    }

    public int getBonusSuccessCount() {
        return bonusSuccessCount;
    }

    public int getNormalSuccessCount() {
        return normalSuccessCount;
    }
}
