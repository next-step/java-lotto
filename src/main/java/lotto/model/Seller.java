package lotto.model;

public class Seller {
    private final Lotto winningLotto;

    public Seller(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static Seller of(Lotto winningLotto) {
        return new Seller(winningLotto);
    }

    public Lotto winnerLotto() {
        return this.winningLotto;
    }
}
