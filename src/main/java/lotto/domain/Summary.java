package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Summary {
    List<MatchCount> matchCounts;

    public Summary(List<MatchCount> matchCounts) {
        validate(matchCounts);
        this.matchCounts = matchCounts;
    }

    private void validate(List<MatchCount> matchCounts) {
        if (matchCounts == null || matchCounts.isEmpty()) {
            throw new IllegalArgumentException("매치된 숫자가 없습니다.");
        }
    }

    public Rewards rewards() {
        List<Reward> rewards = matchCounts.stream()
                .map(Reward::valueOf)
                .collect(Collectors.toUnmodifiableList());
        return new Rewards(rewards);
    }


}
