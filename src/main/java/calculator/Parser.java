package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    
    public static List<Operand> parseInput(String userInput) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher m = pattern.matcher(userInput);
        if (m.find()) {
            userInput = m.group(2);
            delimiter = m.group(1);
        }
        String[] parseResult = userInput.split(delimiter);
        return Arrays.stream(parseResult).map(Operand::new).collect(Collectors.toList());
    }
}
