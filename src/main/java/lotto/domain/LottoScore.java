package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoMatcher.values;

public class LottoScore {
    private Map<LottoMatcher, Integer> map;

    public LottoScore(List<LottoMatcher> lottoMatchers) {
        this.map = Stream.of(LottoMatcher.values())
                .collect(Collectors.toMap(Function.identity(), v -> 0));
        updateScore(lottoMatchers);
    }

    private void updateScore(List<LottoMatcher> lottoMatchers) {
        lottoMatchers.forEach(this::incrementScore);
    }

    private void incrementScore(LottoMatcher lottoMatcher) {
        lottoMatcher.incrementScore(map);
    }

    public int amount() {
        return Arrays.stream(values())
                .filter(LottoMatcher::isMatching)
                .mapToInt(match -> match.amount(map.get(match)))
                .sum();

    }

    public int fifthCount() {
        return map.getOrDefault(LottoMatcher.FIFTH_MATCH, 0);
    }

    public int fourthCount() {
        return map.getOrDefault(LottoMatcher.FOURTH_MATCH, 0);
    }

    public int thirdCount() {
        return map.getOrDefault(LottoMatcher.THIRD_MATCH, 0);
    }

    public int secondCount() {
        return map.getOrDefault(LottoMatcher.SECOND_MATCH, 0);
    }

    public int firstCount() {
        return map.getOrDefault(LottoMatcher.FIRST_MATCH, 0);
    }
}
