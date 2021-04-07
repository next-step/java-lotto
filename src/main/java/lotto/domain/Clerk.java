package lotto.domain;

public class Clerk {

    private Money money;


    public Clerk(Money money) {
        this.money = money;
    }

    public int returnedLottoCount() {
        return money.won() / 1000;
    }


}
