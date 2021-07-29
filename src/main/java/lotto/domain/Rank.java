package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 200000000, "first"),
    SECOND(6, 15000000, "second"),
    THIRD(5, 1000000, "third"),
    FORTH(4, 50000, "forth"),
    FIFTH(3, 5000, "fifth");

    private static final int FIRST_CASE = 6;
    private static final int SECOND_OR_THIRD_CASE = 5;
    private static final int FORTH_CASE = 4;
    private static final int FIFTH_CASE = 3;


    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int forth = 0;
    private static int fifth = 0;

    private final int matchCount;
    private final int reward;
    private final String grade;


    Rank(int matchCount, int reward, String grade) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.grade = grade;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getGrade() {
        return grade;
    }

    public static void valueOf(int matchCount, boolean bonusBall) {

        switch (matchCount) {
            case FIRST_CASE:
                first++;
                break;
            case SECOND_OR_THIRD_CASE:
                checkBonusBall(bonusBall);
                break;
            case FORTH_CASE:
                forth++;
                break;
            case FIFTH_CASE:
                fifth++;
                break;
            default:
                break;
        }
    }

    private static void checkBonusBall(boolean bonusBall) {
        if (bonusBall) {
            second++;
            return;
        }
        third++;
    }

    public static Map<String, Integer> lotteryRewards() {
        Map<String, Integer> map = new HashMap<>();
        map.put(FIRST.grade, first);
        map.put(SECOND.grade, second);
        map.put(THIRD.grade, third);
        map.put(FORTH.grade, forth);
        map.put(FIFTH.grade, fifth);
        return map;
    }

}
