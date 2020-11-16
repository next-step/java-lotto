package lotto.domain;

public class Utils {

    private Utils() {
    }

    public static int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }

    public static Numbers makeRangeNumbers(int startInclusive, int endExclusive) {
        return Numbers.builder()
                .range(startInclusive, endExclusive)
                .build();
    }
}
