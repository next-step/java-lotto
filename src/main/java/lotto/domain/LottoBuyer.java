package lotto.domain;

import java.util.Objects;
import java.util.Scanner;

public class LottoBuyer {
    private Lottos lottos;
    private Money earned;
    private Money paid;

    public LottoBuyer() {
        this(0L, 0L);
    }

    public LottoBuyer(Lottos lottos) {
        this.lottos = lottos;
        this.earned = new Money(0);
        this.paid = new Money(0);
    }

    public LottoBuyer(long earned, long paid) {
        this.earned = new Money(earned);
        this.paid = new Money(paid);
    }

    public Money buy() {
        Scanner scanner = new Scanner(System.in);
        String buyAmount = scanner.nextLine();
        Money moneyToPay = new Money(Long.parseLong(buyAmount));
        paid = paid.add(moneyToPay);
        return moneyToPay;
    }

    public void receive(Lottos lottos) {
        this.lottos = lottos;
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
        LottoBuyer that = (LottoBuyer) o;
        return Objects.equals(lottos, that.lottos) && Objects.equals(earned, that.earned) && Objects.equals(paid, that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, earned, paid);
    }
}
