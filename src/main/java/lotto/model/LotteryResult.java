package lotto.model;

import lotto.enums.Grade;

public final class LotteryResult {
    private static final String COINCIDE_MESSAGE = "개 일치";
    private static final String SECOND_MESSAGE = ", 보너스 볼 일치";
    private final Grade grade;
    private final int count;

    public LotteryResult(Grade grade, int count) {
        this.grade = grade;
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(grade.getExpectNumber()).append(COINCIDE_MESSAGE);
        if (grade.isSecond()) {
            sb.append(SECOND_MESSAGE);
        }
        return sb
                .append("(").append(grade.getAwardPrice())
                .append(")")
                .append("- ")
                .append(count).append("개").toString();
    }
}
