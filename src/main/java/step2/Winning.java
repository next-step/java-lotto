package step2;

public enum Winning {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(1500000),
    THIRD_PRIZE(50000),
    FORTH_PRIZE(5000);

    int prize;

    Winning(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}
