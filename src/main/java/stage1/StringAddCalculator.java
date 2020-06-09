package stage1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static String[] tokens;
    public static int splitAndSum(String string) {
        if (string == null || "".equals(string)) {
            return 0;
        }
        tokens = splitTokens(string);
        return Arrays.stream(tokens).map(Integer::parseInt)
                .map(l -> {if (l < 0) throw new RuntimeException(); return l;})
                .reduce((l, r) -> l + r)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static String[] splitTokens(String string) {
        String delimeter = ",:";
        Matcher m = Pattern.compile("(?<=//)(.)\n(.*)").matcher(string);
        if (m.find()) {
            delimeter += m.group(0).split("\n")[0];
            return m.group(0).split("\n")[1].split(String.format("[%s]", delimeter));
        }
        return string.split(String.format("[%s]", delimeter));
    }
}
