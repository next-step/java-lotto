package humbledude.lotto.domain;

public class Budget {
    public static final long LOTTO_TICKET_PRICE = 1000;

    private final long budget;
    private long amountOfManualLottos = 0;

    public Budget(long budget) {
        this.budget = budget;
    }

    public long getMaxAmountOfLottos() {
        return budget / LOTTO_TICKET_PRICE;
    }

    public void setAmountOfManualLottos(long amount) {
        if (getMaxAmountOfLottos() < amount) {
            throw new IllegalArgumentException("예산을 초과해서 수동 로또를 사려고 하네요");
        }
        this.amountOfManualLottos = amount;
    }

    public long getAmountOfManualLottos() {
        return amountOfManualLottos;
    }

    public long getAmountOfAutoLottos() {
        return getMaxAmountOfLottos() - amountOfManualLottos;
    }
}
