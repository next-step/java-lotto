package lotto.domain;

import static lotto.domain.LottoResult.REWARD_FIRST_GRADE;
import static lotto.domain.LottoResult.REWARD_FOURTH_GRADE;
import static lotto.domain.LottoResult.REWARD_NONE_GRADE;
import static lotto.domain.LottoResult.REWARD_SECOND_GRADE;
import static lotto.domain.LottoResult.REWARD_THIRD_GRADE;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    public static final int REWARD_FIRST_GRADE = 2_000_000_000;
    public static final int REWARD_SECOND_GRADE = 1500000;
    public static final int REWARD_THIRD_GRADE = 50000;
    public static final int REWARD_FOURTH_GRADE = 5000;
    public static final int REWARD_NONE_GRADE = 0;

    private static Map<Integer, Grade> gradeMap = new HashMap<>();
    static {
        gradeMap.put(6, Grade.FIRST);
        gradeMap.put(5, Grade.SECOND);
        gradeMap.put(4, Grade.THIRD);
        gradeMap.put(3, Grade.FOURTH);
    }

    private Grade grade;

    private LottoResult(int fitCount) {
        this.grade = gradeMap.getOrDefault(fitCount, Grade.NONE);
    }

    public static LottoResult of(int fitCount) {
        return new LottoResult(fitCount);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "grade=" + grade +
            '}';
    }

    public int fitCount() {
        return grade.getFitCount();
    }

    public int reward() {
        return grade.getReward();
    }
}

enum Grade {
    FIRST(6, REWARD_FIRST_GRADE),
    SECOND(5, REWARD_SECOND_GRADE),
    THIRD(4, REWARD_THIRD_GRADE),
    FOURTH(3, REWARD_FOURTH_GRADE),
    NONE(0, REWARD_NONE_GRADE);

    private int fitCount;
    private int reward;

    Grade(int fitCount, int reward) {
        this.fitCount = fitCount;
        this.reward = reward;
    }

    public int getFitCount() {
        return fitCount;
    }

    public int getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return "Grade{" + this.name() + " " +
            "fitCount=" + fitCount +
            ", reward=" + reward +
            '}' + "\n";
    }
}