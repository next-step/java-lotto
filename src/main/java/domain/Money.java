package domain;

public class Money {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public double calcYield(double totalWinnings){
        return totalWinnings / money;
    }

    public int getTicketCount() {
        return money / LOTTO_TICKET_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return money;
    }
}
