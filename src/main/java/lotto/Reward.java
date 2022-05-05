package lotto;

public enum Reward {
    Blank(new Money(0)), THREE(new Money(5000)), FOUR(new Money(50000)), FIVE(new Money(1500000)), SIX(new Money(2000000000));
    public Money money;

    Reward(Money money) {
        this.money = money;
    }

    public static Reward of(int win) {
        switch (win) {
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            default:
                return Blank;
        }
    }
};


