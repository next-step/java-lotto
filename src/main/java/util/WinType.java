package util;

public enum WinType {
    FIRST(6, 2_000_000_000),
    SECOND(6, 1_500_000),
    THIRD(5, 150_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private long count;
    private int prize;

    WinType(long count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int calculatePrize(long value) {
        return (int) (value * this.prize);
    }

    public static WinType findByCount(long count) {
        for (WinType type : values()) {
            if (type.count == count) {
                return type;
            }
        }
        return LOSE;
    }

    public long getCount() {
        return this.count;
    }
}
