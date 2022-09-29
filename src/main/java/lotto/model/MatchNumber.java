package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MatchNumber {


    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1500_000),
    FIVE_WITH_BONUS_BALL(6,30_000_000),
    SIX(6, 2000_000_000);

    private final Integer count;

    private final Integer money;

    MatchNumber(Integer count, Integer money) {
        this.count = count;
        this.money = money;
    }
    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

    public static MatchNumber getMatchNumber(Lotto lotto) {
        List<MatchNumber> matchNumbers = findByCount(lotto);
        if (isInvalidMatchNumbers(matchNumbers)){
            throw new IllegalStateException();
        }
        if (matchNumbers.size() == 1){
            return matchNumbers.get(0);
        }
        return getMatchNumberByBonusBall(lotto, matchNumbers);
    }
    private static List<MatchNumber> findByCount(Lotto lotto){
        return Arrays.stream(values()).filter((balls -> balls.count == lotto.size())).collect(Collectors.toList());
    }

    private static boolean isInvalidMatchNumbers(List<MatchNumber> matchNumbers) {
        return matchNumbers.size() >= 3 || matchNumbers.size() <= 0;
    }

    private static MatchNumber getMatchNumberByBonusBall(Lotto lotto, List<MatchNumber> matchNumbers) {
        if (matchNumbers.size() == 2 || lotto.hasBonusBall()){
            return MatchNumber.FIVE_WITH_BONUS_BALL;
        }
        return MatchNumber.FIVE;
    }
    public static boolean hasMoney(MatchNumber matchNumber) {
        return !(matchNumber.equals(ONE) || matchNumber.equals(TWO) || matchNumber.equals(ZERO));
    }

}
