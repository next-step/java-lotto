package constant;

public class Rank {
    private final long countOfMatchedNumber;

    public Rank(long countOfMatchedNumber) {
        this.countOfMatchedNumber = countOfMatchedNumber;
    }

    public long getCountOfMatchedNumber() {
        return countOfMatchedNumber;
    }

    public String findRank() {
        switch ((int) countOfMatchedNumber) {
            case 3:
                return "FOURTH";
            case 4:
                return "THIRD";
            case 5:
                return "SECOND";
            case 6:
                return "FIRST";
            default:
                return "UNKNOWN";
        }
    }
}
