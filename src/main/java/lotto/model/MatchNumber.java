package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum MatchNumber implements Comparator<MatchNumber> {


    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX_WITH_BONUS_BALL(6, 30_000_000),
    SIX(6, 2_000_000_000);

    private final Integer count;

    private final Integer money;

    MatchNumber(Integer count, Integer money) {
        this.count = count;
        this.money = money;
    }

    public static MatchNumber getMatchNumber(List<LottoBall> lottoBalls) {
        List<MatchNumber> matchNumbers = findByCount(lottoBalls);
        if (isSecondRank(matchNumbers, lottoBalls)) {
            return MatchNumber.SIX_WITH_BONUS_BALL;
        }
        return matchNumbers.stream().filter((matchNumber -> !matchNumber.equals(MatchNumber.SIX_WITH_BONUS_BALL))).findAny().orElseThrow(IllegalStateException::new);
    }

    private static boolean isSecondRank(List<MatchNumber> matchNumbers, List<LottoBall> lottoBalls) {
        return matchNumbers.contains(MatchNumber.SIX_WITH_BONUS_BALL) && lottoBalls.stream().anyMatch(LottoBall::isBonusBall);
    }

    private static List<MatchNumber> findByCount(List<LottoBall> lottoBalls) {
        return Arrays.stream(values()).filter((balls -> balls.count == lottoBalls.size())).collect(Collectors.toList());
    }

    public static boolean hasMoney(MatchNumber matchNumber) {
        return !(matchNumber.equals(ONE) || matchNumber.equals(TWO) || matchNumber.equals(ZERO));
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

    @Override
    public int compare(MatchNumber x, MatchNumber y) {
        if (x.count != y.count) {
            return x.count - y.count;
        }
        if (x.equals(MatchNumber.SIX_WITH_BONUS_BALL)) {
            return -1;
        }
        return 1;
    }
}
