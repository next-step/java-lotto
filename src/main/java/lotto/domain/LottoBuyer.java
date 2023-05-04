package lotto.domain;

import java.util.Objects;

public class LottoBuyer {
    private Lottos lottos;
    private Money earned;
    private Money paid;

    public LottoBuyer() {
        this(0, 0);
    }

    public LottoBuyer(Lottos lottos) {
        this(lottos, 0, 0);
    }

    public LottoBuyer(Lottos lottos, long earned, long paid) {
        this.lottos = lottos;
        this.earned = new Money(earned);
        this.paid = new Money(paid);
    }

    public LottoBuyer(long earned, long paid) {
        this.earned = new Money(earned);
        this.paid = new Money(paid);
    }

    private void calculatePaid() {
        paid = paid.add(lottos.calculateAmount());
    }

    public void receive(Lottos lottos) {
        this.lottos = lottos;
        calculatePaid();
    }

    public Matchs checkWinning(Lotto winningLotto) {
        return new Matchs(lottos.countMatching(winningLotto));
    }

    public void earn(Money winningAmount) {
        earned = earned.add(winningAmount);
    }

    public double calculateRateOfEarning() {
        return earned.divide(paid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer buyer = (LottoBuyer) o;
        return Objects.equals(lottos, buyer.lottos) && Objects.equals(earned, buyer.earned) && Objects.equals(paid, buyer.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, earned, paid);
    }
}
