package lotto.domain;

public class Clerk {

    private Money money;
    private static final int THOUSAND = 1000;
    private int manualLottoCount = 0;
    private int totalLottoCount = 0;

    public Clerk(Money money, int manualLottoCount) {
        this(money);
        this.manualLottoCount = manualLottoCount;
    }

    public Clerk(Money money) {
        this.money = money;
        this.totalLottoCount = money.won() / THOUSAND;
    }

    public int returnedLottoTotalCount() {
        return this.totalLottoCount;
    }

    public int returedAutoLottoCount() {
        return this.totalLottoCount - this.manualLottoCount;
    }
}
