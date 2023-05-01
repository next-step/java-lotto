package lotto.domain;

import java.util.Arrays;

public class StringConcatenater {
    public static String concatStrings(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(strings)
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static String concatStrings(String string, String[] stringArr) {
        return concatStrings(
                string,
                concatStrings(stringArr)
        );
    }
}
