package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTokens {
    private final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String DEFAULT_VALUE = "0";
    private final String SPLIT_REGEX = ",|:";

    private String[] tokens;

    public NumberTokens(String inputString) {
        if (isNullOrEmpty(inputString)) {
            this.tokens = new String[]{DEFAULT_VALUE};
            return;
        }
        if (isPatternDelimiter(inputString)){
            this.tokens = splitPatternDelimiter(inputString);
            return;
        }
        this.tokens = inputString.split(SPLIT_REGEX);
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isPatternDelimiter(String text) {
        return DELIMITER_PATTERN.matcher(text).matches();
    }

    private String[] splitPatternDelimiter(String text) {
        Matcher patternMather = DELIMITER_PATTERN.matcher(text);
        while (patternMather.find()) {
            String customDelimiter = patternMather.group(1);
            return patternMather.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private boolean isPositiveNumber(String text){
        if(POSITIVE_NUMBER_PATTERN.matcher(text).matches()){
            return true;
        }
        throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
    }

    public String[] getTokens(){
        return Arrays.stream(tokens)
                .filter(m -> isPositiveNumber(m))
                .toArray(String[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberTokens numbers1 = (NumberTokens) o;
        return Arrays.equals(tokens, numbers1.tokens);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tokens);
    }
}
