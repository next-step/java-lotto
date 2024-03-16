package lotto;

public class Amount {
    private Amount() {
    }

    public static Integer getAmount(long matchedCount) {
        if (matchedCount == 3) {
            return 5000;
        }
        if (matchedCount == 4) {
            return 50000;
        }
        if (matchedCount == 5) {
            return 1500000;
        }
        if (matchedCount == 6) {
            return 2000000000;
        }
        return null;
    }
}
