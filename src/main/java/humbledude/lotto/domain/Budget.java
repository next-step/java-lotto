package humbledude.lotto.domain;

public class Budget {
    private final long budget;
    private long amountOfManualLottos = 0;

    public Budget(long budget) {
        this.budget = budget;
    }

    public void setAmountOfManualLottos(long amount) {
        long maxAmount = LottoStore.howManyCanIBuy(budget);
        if (maxAmount < amount) {
            throw new IllegalArgumentException("예산을 초과해서 수동 로또를 사려고 하네요");
        }
        this.amountOfManualLottos = amount;
    }

    public long getAmountOfAutoLottos() {
        long maxAmount = LottoStore.howManyCanIBuy(budget);
        return maxAmount - amountOfManualLottos;
    }
}
