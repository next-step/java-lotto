package game.lotto.util;

import java.util.regex.Pattern;

public class WinningNumberSplitor {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

    public static String[] split(String stringWinningNumber) {

        return SPLIT_PATTERN.split(stringWinningNumber);
    }

}
