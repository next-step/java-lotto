package lotto.domain;

public class Lotto {

    private Lotto() { }

    public static Lotto newLotto() {
        return new Lotto();
    }

    public void start() {
        int purchaseAmount = 100000;
    }
}
