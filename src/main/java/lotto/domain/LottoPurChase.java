package lotto.domain;

public class LottoPurChase {
    private final Money money;
    private final LottoCount lottoCount;


    public LottoPurChase(int money, int autoCount, int manualCount) {
        this(new Money(money), new LottoCount(autoCount, manualCount));
    }
    public LottoPurChase(Money money, LottoCount lottoCount) {
        this.money = money;
        this.lottoCount = lottoCount;
    }

    public Money getMoney() {
        return this.money;
    }

    public int getAutoCount() {
        return this.lottoCount.getAutoCount();
    }

    public int getManualCount() {
        return this.lottoCount.getManualCount();
    }
}
