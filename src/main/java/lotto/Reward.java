package lotto;

public enum Reward {
    Blank(0), THREE(5000), FOUR(50000), FIVE(1500000), SIX(2000000000);
    public int value;
    Reward(int win) {
        this.value = win;
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


