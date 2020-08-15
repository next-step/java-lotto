package calculator.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;

public class MatcherCache {
    private static final ConcurrentHashMap<String, Matcher> matcherCache = new ConcurrentHashMap<>();

    public static Matcher getMatcher(String input) {
        return matcherCache.get(input);
    }

    public static boolean hasMatcher(String input) {
        return matcherCache.containsKey(input);
    }

    public static void putMatcher(String input, Matcher matcher) {
        matcherCache.put(input, matcher);
    }

}
