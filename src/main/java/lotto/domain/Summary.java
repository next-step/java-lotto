package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Summary {
    private final List<MatchResult> matchResults;

    public Summary(List<MatchResult> matchResults) {
        validate(matchResults);
        this.matchResults = matchResults;
    }

    private void validate(List<MatchResult> matchResults) {
        if (matchResults == null || matchResults.isEmpty()) {
            throw new IllegalArgumentException("매치된 숫자가 없습니다.");
        }
    }

    public Rewards rewards() {
        Map<Reward, Integer> rewards = matchResults.stream()
                .map(Reward::valueOf)
                .collect(Collectors.toUnmodifiableMap(reward -> reward, reward -> 1, Integer::sum));
        return new Rewards(rewards);
    }
}
