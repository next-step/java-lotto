package autoLotto;

import java.util.HashMap;
import java.util.Map;

import static autoLotto.Match.*;

public class Matcher {
    private static Map<Integer, Match> matcher = new HashMap<>();

    static {
        matcher.put(3, THREE);
        matcher.put(4, FOUR);
        matcher.put(5, FIVE);
        matcher.put(6, SIX);
    }

    public static Match get(final int number) {
        return matcher.get(number);
    }
}
