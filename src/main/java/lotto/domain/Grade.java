package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static lotto.utils.Validator.checkNotNull;

public enum Grade {
    FIRST(6, 2_000_000_000),
    BONUS(5, 30_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    BANG(0, 0);

    private static final Grade[] CACHED_GRADES = Grade.values();
    private static final long DEFAULT_COUNT = 0L;
    private static final int INCREASE_COUNT_UNIT = 1;
    private static final int BONUS_WIN_MATCH_COUNT = 5;

    private final int matchCount;
    private final long reward;

    Grade(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Grade from(int matchCount, boolean matchBonus) {
        if (isBonusWin(matchCount, matchBonus)) {
            return BONUS;
        }
        return from(matchCount);
    }

    private static boolean isBonusWin(int matchCount, boolean matchBonus) {
        return matchCount == BONUS_WIN_MATCH_COUNT && matchBonus;
    }

    private static Grade from(int matchCount) {
        return stream(CACHED_GRADES)
                .filter(matchesExcludedBonus(matchCount))
                .findFirst()
                .orElse(BANG);
    }

    private static Predicate<Grade> matchesExcludedBonus(int matchCount) {
        return grade -> (grade != BONUS) && (grade.matchCount == matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }

    public static Map<Grade, Long> mapOf(List<Grade> grades) {
        checkNotNull(grades);
        Map<Grade, Long> resultGrades = initMap();
        for (Grade grade : grades) {
            resultGrades.computeIfPresent(grade, increaseCount());
        }
        return resultGrades;
    }

    private static Map<Grade, Long> initMap() {
        return stream(CACHED_GRADES)
                .filter(Grade::isWin)
                .collect(Collectors.toMap(grade -> grade, grade -> DEFAULT_COUNT));
    }

    public boolean isWin() {
        return this != BANG;
    }

    private static BiFunction<Grade, Long, Long> increaseCount() {
        return (grade, count) -> count + INCREASE_COUNT_UNIT;
    }
}
