package lotto.core;

import lombok.EqualsAndHashCode;
import lotto.core.exception.LottoRuleException;

@EqualsAndHashCode(of = "number")
public class Ball implements Comparable<Ball> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    protected Ball(final int number) {
        if (validation(number)) {
            throw new LottoRuleException(String.format("번호는 %d이상 %d이하의 숫자만 존재할수있습니다.", MIN, MAX));
        }

        this.number = number;
    }

    public int number() {
        return number;
    }

    private static boolean validation(int number) {
        return number < MIN || number > MAX;
    }

    @Override
    public int compareTo(Ball ball) {
        return this.number - ball.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
