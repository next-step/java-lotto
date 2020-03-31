package lotto.type;

import lombok.Getter;

import java.util.Arrays;
import java.util.function.Function;

public enum RankType {
    NO_RANK(0, matchCondition -> matchCondition.getCondition() < 3 || matchCondition.getCondition() > 6),
    RANK1(2_000_000_000, matchCondition -> matchCondition.getCondition() == 6),
    RANK2(1_500_000, matchCondition -> matchCondition.getCondition() == 5 && matchCondition.isMatchBonusBall()),
    RANK3(1_500_000, matchCondition -> matchCondition.getCondition() == 5 && !matchCondition.isMatchBonusBall()),
    RANK4(50_000, matchCondition -> matchCondition.getCondition() == 4),
    RANK5(5_000, matchCondition -> matchCondition.getCondition() == 3);

    private int reward;
    private Function<MatchCondition, Boolean> expression;

    RankType(int reward, Function<MatchCondition, Boolean> expression) {
        this.reward = reward;
        this.expression = expression;
    }

    public int getTotalReward(int count) {
        return this.reward * count;
    }

    public static RankType getRank(int condition, boolean matchBonusBall) {
        return Arrays.stream(RankType.values())
                .filter(type -> type.expression.apply(new MatchCondition(condition, matchBonusBall)))
                .findAny().get();
    }

    @Getter
    private static class MatchCondition {
        private int condition;
        private boolean matchBonusBall;

        public MatchCondition(int condition, boolean matchBonusBall) {
            this.condition = condition;
            this.matchBonusBall = matchBonusBall;
        }
    }
}
