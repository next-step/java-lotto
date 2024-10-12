package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningResult {

    public static final int VALID_MATCH_COUNT_MIN = 3;
    public static final int VALID_MATCH_COUNT_MAX = 6;

    private final List<Integer> staticsList;

    public WinningResult(List<Integer> staticsList) {
        this.staticsList = staticsList;
    }

    public WinningResult(int... numbers) {
        this(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()));
    }

    public WinningResult() {
        this(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
    }

    public List<Integer> getStaticsList() {
        return staticsList;
    }

    public void incrementMatchCount(int matchCount) {
        staticsList.set(matchCount, staticsList.get(matchCount) + 1);
    }

    public int calculateProfitRate() {
        int profit = 0;
        for (int match = 3; match <= 6; ++match) {
            int howMany = staticsList.get(match);
            LottoMatch LottoMatch = lotto.domain.LottoMatch.findEnumByMatchCount(match);
            profit += LottoMatch.calculatePrize(howMany);
        }
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult that = (WinningResult) o;
        return Objects.equals(staticsList, that.staticsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staticsList);
    }
}
