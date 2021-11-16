package lotto;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Statistics {

    private static final int MIN_COUNT = 0;
    private final Map<Grade, Long> grades;
    private final Dollars dollars;

    public Statistics(Map<Grade, Long> grades, Dollars dollars) {
        checkArguments(grades, dollars);
        this.grades = grades;
        this.dollars = dollars;
    }

    private void checkArguments(Map<Grade, Long> results, Dollars dollars) {
        checkNotNull(dollars);
        checkNotNull(results);
        checkNonNegativeKey(results);
    }

    private void checkNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    private void checkNonNegativeKey(Map<Grade, Long> results) {
        for (Long count : new ArrayList<>(results.values())) {
            checkNonNegative(count);
        }
    }

    private void checkNonNegative(Long count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("개수가 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(grades, that.grades) && Objects.equals(dollars, that.dollars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grades, dollars);
    }
}
