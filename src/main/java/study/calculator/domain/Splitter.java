package study.calculator.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final List<String> REGEX_KEYWORDS =
            Arrays.asList("?", "*", "+", "(", ")", "[", "]", "{", "}");

    private Splitter() {
    }

    public static List<String> split(String text) {
        if (Objects.isNull(text)) {
            return Collections.emptyList();
        }

        List<String> piecesByCustomDelimiter =
                splitWithCustomDelimiter(text);

        return splitWithDefaultDelimiter(piecesByCustomDelimiter);
    }

    private static List<String> splitWithDefaultDelimiter(
            List<String> texts) {
        String delimitersRegEx = String.join("|", DEFAULT_DELIMITERS);
        List<String> pieces = new ArrayList<>();

        for (String text : texts) {
            pieces.addAll(Arrays.asList(text.split(delimitersRegEx)));
        }

        return pieces;
    }

    private static List<String> splitWithCustomDelimiter(
            String text) {
        String customDelimiter =
                escapeRegExKeyword(findCustomDelimiter(text));

        if (Objects.isNull(customDelimiter)) {
            return Collections.singletonList(text);
        }
        String operandsWithoutCustomDelimiter =
                removeCustomDelimiter(text);

        return Arrays
                .asList(operandsWithoutCustomDelimiter.split(customDelimiter));
    }

    private static String findCustomDelimiter(String text) {
        Matcher m =
                Pattern.compile("//(?<delimiter>.*)\\\\n").matcher(text);

        if (m.find()) {
            return m.group("delimiter");
        }

        return null;
    }

    private static String escapeRegExKeyword(String keyword) {
        if (REGEX_KEYWORDS.contains(keyword)) {
            return "\\" + keyword;
        }
        
        return keyword;
    }

    private static String removeCustomDelimiter(String text) {
        return text.replaceAll("//.*\\\\n", "");
    }
}
