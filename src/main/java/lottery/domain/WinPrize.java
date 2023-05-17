package lottery.domain;

public enum WinPrize {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(1500000),
    THIRD_PLACE(50000),
    FOURTH_PLACE(5000),
    LOST(0);


    private final int value;

    WinPrize(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
