package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RankMapping {
    private final List<RankCondition> rankings = new ArrayList<>();

    public RankMapping() {
        rankings.add(new SecondRank());
        rankings.add(new ThirdRank());
        rankings.add(new OtherRank());
    }

    public RankCondition rank(int matchCount, boolean bonus){
        return rankings.stream()
                .filter(r -> r.condition(matchCount, bonus))
                .findFirst()
                .orElse(new OtherRank());
    }

}
