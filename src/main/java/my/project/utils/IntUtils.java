package my.project.utils;

import my.project.constants.Comments;
import my.project.messages.ExceptionMessages;

public class IntUtils {
    public static void isQualified(Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_HAS_NEGATIVE);
        }
    }

    public static void isMoneyQualified(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(Comments.MIN_MONEY);
        }
        if (money > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_IS_OVER);
        }
    }

    private IntUtils() {
    }
}
