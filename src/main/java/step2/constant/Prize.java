package step2.constant;

import java.util.stream.Stream;

public enum Prize {

    THREE(3, 5000, "3개 일치 (5000원)-"),
    FOUR(4, 50000, "4개 일치 (50000원)-"),
    FIVE(5, 1500000, "5개 일치 (1500000원)-"),
    ALL(6, 2000000000, "6개 일치 (2000000000원)-"),
    BAD_LUCK(0, 0, "꽝!");

    private int correct;
    private int reward;
    private String comment;

    Prize(int correct, int reward, String comment) {
        this.correct = correct;
        this.reward = reward;
        this.comment = comment;
    }

    public static Prize getPrize(int number) {
        return Stream.of(Prize.values())
                     .filter(prize -> prize.getCorrect() == number)
                     .findFirst().orElse(BAD_LUCK);
    }

    public int getCorrect() {
        return correct;
    }
}
