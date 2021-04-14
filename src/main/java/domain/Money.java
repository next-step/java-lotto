package domain;

public class Money {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int money;
    private int manualCount;

    public Money(int money) {
        this.money = money;
    }

    public Money(int money, int manualCount) {
        validate(money, manualCount);
        this.money = money;
        this.manualCount = manualCount;
    }

    private void validate(int money, int manualCount) {
        if( money < (manualCount * LOTTO_TICKET_PRICE)){
            throw new IllegalArgumentException();
        }
    }

    public double calcYield(double totalWinnings){
        return totalWinnings / money;
    }

    public int getTicketCount() {
        return (money / LOTTO_TICKET_PRICE) - manualCount;
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
