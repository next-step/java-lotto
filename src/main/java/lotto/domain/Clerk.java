package lotto.domain;

public class Clerk {

    private Money money;
    private static final int THOUSAND = 1000;

    public Clerk(Money money) {
        this.money = money;
    }

    public int returnedLottoCount() {
        return money.won() / THOUSAND;
    }


}
