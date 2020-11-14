package lotto.domain;

public class Utils {
    public static Numbers makeRangeNumbers(int startInclusive, int endExclusive) {
        return Numbers.builder()
                .range(startInclusive, endExclusive)
                .build();
    }
}
