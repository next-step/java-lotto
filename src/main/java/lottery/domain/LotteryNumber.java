package lottery.domain;

public class LotteryNumber implements Comparable<LotteryNumber> {
    public final static int MIN =  1;
    public final static int MAX = 45;

    private final int number;

    public LotteryNumber(int number) {
        sanitizeNumber(number);
        this.number = number;
    }

    private static void sanitizeNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LotteryNumber other) {
        return Integer.compare(number, other.number);
    }
}
