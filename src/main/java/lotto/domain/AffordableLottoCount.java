package lotto.domain;

public class AffordableLottoCount {
    private static final String EXCEP_INVALID_AFFORDABLE_LOTTO_COUNT = "AffordableLottoCount 데이터로 유효하지 않습니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int manualLottoCount;
    private final Money money;

    public AffordableLottoCount(Money money, int manualLottoCount) {
        validate(money, manualLottoCount);
        this.money = money;
        this.manualLottoCount = manualLottoCount;
    }

    void validate(Money money, int manualLottoCount) {
        if (money.calculateBuyableLottos(LOTTO_PRICE) < manualLottoCount) {
            throw new IllegalArgumentException(EXCEP_INVALID_AFFORDABLE_LOTTO_COUNT);
        }
    }

    public int getCountToAutoGenerate() {
        return calculateBuyableLottos() - manualLottoCount;
    }

    public int getCountToManualGenerate() {
        return manualLottoCount;
    }


    public double getYield(int totalPrizeMoney) {
        return money.getYield(totalPrizeMoney);
    }

    public int calculateBuyableLottos() {
        return money.calculateBuyableLottos(LOTTO_PRICE);
    }
}
